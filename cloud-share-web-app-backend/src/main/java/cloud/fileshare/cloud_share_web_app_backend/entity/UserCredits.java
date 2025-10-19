package cloud.fileshare.cloud_share_web_app_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_credits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // Auto-increment primary key

    @Column(nullable = false, unique = true)
    private String clerkId;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private String plan; // BASIC, PREMIUM, ULTIMATE
 }

