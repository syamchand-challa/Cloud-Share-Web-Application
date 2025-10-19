package cloud.fileshare.cloud_share_web_app_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL auto increment
    private Long id;

    @Column(nullable = false, unique = true)
    private String clerkId;

    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private Integer credits;
    private String photoUrl;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}




