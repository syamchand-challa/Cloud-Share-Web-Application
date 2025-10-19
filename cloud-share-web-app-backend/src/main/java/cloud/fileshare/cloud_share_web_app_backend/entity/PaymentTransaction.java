package cloud.fileshare.cloud_share_web_app_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // MySQL lo Auto Increment PK

    @Column(nullable = false)
    private String clerkId;

    @Column(nullable = false, unique = true)
    private String orderId;

    private String paymentId;
    private String planId;

    private int amount;
    private String currency;
    private int creditsAdded;

    private String status;
    private LocalDateTime transactionDate;

    private String userEmail;
    private String userName;
}
