package cloud.fileshare.cloud_share_web_app_backend.repository;

import cloud.fileshare.cloud_share_web_app_backend.entity.UserCredits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCreditsRepository extends JpaRepository<UserCredits, Long> {

    Optional<UserCredits> findByClerkId(String clerkId);


}
