package cloud.fileshare.cloud_share_web_app_backend.controller;

import cloud.fileshare.cloud_share_web_app_backend.dto.PaymentDTO;
import cloud.fileshare.cloud_share_web_app_backend.dto.PaymentVerificationDTO;
import cloud.fileshare.cloud_share_web_app_backend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody PaymentDTO paymentDTO) {
        PaymentDTO response = paymentService.createOrder(paymentDTO);
        if (response.getSuccess()) {
             return ResponseEntity.ok(response);
          }else {
            return ResponseEntity.badRequest().body(response);
            }
           }
    @PostMapping("/verify-payment")
    public ResponseEntity<?> verifyPayment(@RequestBody PaymentVerificationDTO request) {

        PaymentDTO response = paymentService.verifyPayment(request);
        if (response.getSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    }


