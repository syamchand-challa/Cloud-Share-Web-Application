package cloud.fileshare.cloud_share_web_app_backend.repository;


import cloud.fileshare.cloud_share_web_app_backend.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByEmail(String email);

    ProfileEntity findByClerkId(String clerkId);

    Boolean existsByClerkId(String clerkId);
}

