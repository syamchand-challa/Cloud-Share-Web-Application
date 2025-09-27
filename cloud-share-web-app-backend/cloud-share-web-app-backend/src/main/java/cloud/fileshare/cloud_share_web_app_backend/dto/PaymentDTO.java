package cloud.fileshare.cloud_share_web_app_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private String planId;
    private Integer amount;
    private String currency;
    private Integer credits;
    private Boolean success;
    private String message;
    private String orderId;
}
