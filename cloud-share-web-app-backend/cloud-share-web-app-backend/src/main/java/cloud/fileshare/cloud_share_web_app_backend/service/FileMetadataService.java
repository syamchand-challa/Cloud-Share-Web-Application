package cloud.fileshare.cloud_share_web_app_backend.service;


import cloud.fileshare.cloud_share_web_app_backend.dto.FileMetadataDTO;
import cloud.fileshare.cloud_share_web_app_backend.entity.FileMetadataEntity;
import cloud.fileshare.cloud_share_web_app_backend.entity.ProfileEntity;
import cloud.fileshare.cloud_share_web_app_backend.repository.FileMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FileMetadataService {

    private final ProfileService profileService;
    private final UserCreditsService userCreditsService;
    private final FileMetadataRepository fileMetadataRepository;

    public List<FileMetadataDTO> uploadFiles(MultipartFile[] files) throws IOException {
        ProfileEntity currentProfile = profileService.getCurrentProfile();
        List<FileMetadataEntity> savedFiles = new ArrayList<>();

        if (!userCreditsService.hasEnoughCredits(files.length)) {
            throw new RuntimeException("Not enough credits to upload files. Please purchase more credits");

        }

        Path uploadPath = Paths.get("upload").toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);

        for (MultipartFile file : files) {
            String fileName = UUID.randomUUID() + "." +
                    StringUtils.getFilenameExtension(file.getOriginalFilename());

            Path targetLocation = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            FileMetadataEntity fileMetadata = FileMetadataEntity.builder()
                    .fileLocation(targetLocation.toString())
                    .name(file.getOriginalFilename())
                    .size(file.getSize())
                    .type(file.getContentType())
                    .clerkId(currentProfile.getClerkId())
                    .isPublic(false)
                    .uploadedAt(LocalDateTime.now())
                    .build();


            userCreditsService.consumeCredit();
            savedFiles.add(fileMetadataRepository.save(fileMetadata));

        }
        return savedFiles.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private FileMetadataDTO mapToDTO(FileMetadataEntity fileMetadataEntity) {
        return FileMetadataDTO.builder()
                .id(fileMetadataEntity.getId())
                .fileLocation(fileMetadataEntity.getFileLocation())
                .name(fileMetadataEntity.getName())
                .size(fileMetadataEntity.getSize())
                .type(fileMetadataEntity.getType())
                .clerkId(fileMetadataEntity.getClerkId())
                .isPublic(fileMetadataEntity.getIsPublic())
                .uploadedAt(fileMetadataEntity.getUploadedAt())
                .build();
    }
    // Get files of logged-in user
    public List<FileMetadataDTO> getFiles() {
        ProfileEntity currentProfile = profileService.getCurrentProfile();
        List<FileMetadataEntity> files = fileMetadataRepository.findByClerkId(currentProfile.getClerkId());
        return files.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Get public file by ID
    public FileMetadataDTO getPublicFile(Long id) {
        Optional<FileMetadataEntity> fileOptional = fileMetadataRepository.findById(id);
        if (fileOptional.isEmpty() || !fileOptional.get().getIsPublic()) {
            throw new RuntimeException("Unable to get the file");
        }
        return mapToDTO(fileOptional.get());
    }
    // Get downloadable file
    public FileMetadataDTO getDownloadableFile(Long id) {
        FileMetadataEntity file = fileMetadataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
        return mapToDTO(file);
    }
    // Delete file
    public void deleteFile(Long id) {
        try {
            ProfileEntity currentProfile = profileService.getCurrentProfile();
            FileMetadataEntity file = fileMetadataRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("File not found"));

            if (!file.getClerkId().equals(currentProfile.getClerkId())) {
                throw new RuntimeException("File does not belong to current user");
            }

            Path filePath = Paths.get(file.getFileLocation());
            Files.deleteIfExists(filePath);

            fileMetadataRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting the file");
        }
    }
    // Toggle Public / Private
    public FileMetadataDTO togglePublic(Long id) {
        FileMetadataEntity file = fileMetadataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));

        file.setIsPublic(!file.getIsPublic());
        fileMetadataRepository.save(file);
        return mapToDTO(file);
    }

}
