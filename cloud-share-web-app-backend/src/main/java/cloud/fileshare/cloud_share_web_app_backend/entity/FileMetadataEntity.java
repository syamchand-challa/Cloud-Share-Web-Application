package cloud.fileshare.cloud_share_web_app_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FileMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;

    private Long size;

    @Column(nullable = false)
    private String clerkId;

    private Boolean isPublic;

    @Column(nullable = false)
    private String fileLocation;

    private LocalDateTime uploadedAt;
}
