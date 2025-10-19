package cloud.fileshare.cloud_share_web_app_backend.controller;


import cloud.fileshare.cloud_share_web_app_backend.entity.PaymentTransaction;
import cloud.fileshare.cloud_share_web_app_backend.entity.ProfileEntity;
import cloud.fileshare.cloud_share_web_app_backend.repository.PaymentTransactionRepository;
import cloud.fileshare.cloud_share_web_app_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")

@RequiredArgsConstructor
public class TransactionController {

    private final PaymentTransactionRepository paymentTransactionRepository;
    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<?> getUserTransactions() {
        ProfileEntity currentProfile = profileService.getCurrentProfile();
        String clerkId = currentProfile.getClerkId();


        List<PaymentTransaction> transactions=paymentTransactionRepository.findByClerkIdAndStatusOrderByTransactionDateDesc(clerkId, "SUCCESS");
        return ResponseEntity.ok(transactions);
    }

}
