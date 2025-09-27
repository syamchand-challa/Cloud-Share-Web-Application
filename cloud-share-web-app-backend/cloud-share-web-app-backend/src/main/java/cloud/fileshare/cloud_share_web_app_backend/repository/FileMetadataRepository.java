package cloud.fileshare.cloud_share_web_app_backend.repository;

import cloud.fileshare.cloud_share_web_app_backend.entity.FileMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileMetadataRepository  extends JpaRepository<FileMetadataEntity, Long> {

    List<FileMetadataEntity> findByClerkId(String clerkId);

    Long countByClerkId(String clerkId);

}
