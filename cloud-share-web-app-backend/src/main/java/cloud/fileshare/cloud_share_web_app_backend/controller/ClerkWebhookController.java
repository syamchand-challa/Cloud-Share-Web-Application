package cloud.fileshare.cloud_share_web_app_backend.controller;


import cloud.fileshare.cloud_share_web_app_backend.dto.ProfileDTO;
import cloud.fileshare.cloud_share_web_app_backend.service.ProfileService;
import cloud.fileshare.cloud_share_web_app_backend.service.UserCreditsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/webhooks")
@RequiredArgsConstructor
public class ClerkWebhookController {

    private final ProfileService profileService;
    private final UserCreditsService userCreditsService;


    @Value("${clerk.webhook.secret}")
    private String webhookSecret;

    @PostMapping("/clerk")
    public ResponseEntity<?> handleClerkWebhook(@RequestHeader("svix-id") String svixId,
                                                @RequestHeader("svix-timestamp") String svixTimestamp,
                                                @RequestHeader("svix-signature") String svixSignature,
                                                @RequestBody String payload) {

        try{
            boolean isValid = verifyWebhookSignature(svixId, svixTimestamp, svixSignature, payload);
            if (!isValid) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid webhook signature");
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(payload);

            String eventType = rootNode.path("type").asText();

            switch (eventType) {
                case "user.created":
                    handleUserCreated(rootNode.path("data"));
                    break;
                case "user.updated":
                    handleUserUpdated(rootNode.path("data"));
                    break;
                case "user.deleted":
                    handleUserDeleted(rootNode.path("data"));
                    break;
            }
            return ResponseEntity.ok().build();

        } catch ( Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
             }
         }

    private void handleUserDeleted(JsonNode data) {
        String clerkId = data.path("id").asText();
        profileService.deleteProfile(clerkId);
    }
    private void handleUserUpdated(JsonNode data) {
        String clerkId = data.path("id").asText();

        // Extract user information
        String email = "";
        JsonNode emailAddresses = data.path("email_addresses");
        if (emailAddresses.isArray() && emailAddresses.size() > 0) {
            email = emailAddresses.get(0).path("email_address").asText();
        }

        String firstName = data.path("first_name").asText("");
        String lastName = data.path("last_name").asText("");
        String photoUrl = data.path("image_url").asText("");

        ProfileDTO updatedProfile = ProfileDTO.builder()
                .clerkId(clerkId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .photoUrl(photoUrl)
                .build();

        updatedProfile = profileService.updateProfile(updatedProfile);

        if (updatedProfile == null) {
            handleUserCreated(data);
        }

    }

    private void handleUserCreated(JsonNode data) {
            String clerkId = data.path("id").asText();

            String email = "";
            JsonNode emailAddresses = data.path("email_addresses");
            if (emailAddresses.isArray() && emailAddresses.size() > 0) {
                email = emailAddresses.get(0).path("email_address").asText();
            }

            String firstName = data.path("first_name").asText("");
            String lastName = data.path("last_name").asText("");
            String photoUrl = data.path("image_url").asText("");

            ProfileDTO newProfile = ProfileDTO.builder()
                    .clerkId(clerkId)
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .photoUrl(photoUrl)
                    .build();

            profileService.createProfile(newProfile);
        userCreditsService.createInitialCredits(clerkId);


    }

    private boolean verifyWebhookSignature(String svixId, String svixTimestamp, String svixSignature, String payload) {
        // validate the signature
        return true;
    }
}
