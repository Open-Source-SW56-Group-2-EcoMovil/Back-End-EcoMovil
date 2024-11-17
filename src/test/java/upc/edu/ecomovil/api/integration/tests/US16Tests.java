package upc.edu.ecomovil.api.integration.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import upc.edu.ecomovil.api.acceptance.tests.steps.US16Steps;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class US16Tests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port;
    }

    @Test
    public void testSuccessfulRegistration() {
        String url = baseUrl + "/api/auth/register";
        String requestBody = "{\"fullName\":\"María Pérez\",\"email\":\"maria@example.com\",\"password\":\"password123\",\"confirmPassword\":\"password123\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).contains("Registration successful");
    }

    @Test
    public void testFailedRegistrationByExistingEmail() {
        String url = baseUrl + "/api/auth/register";
        String requestBody = "{\"fullName\":\"María Pérez\",\"email\":\"maria@example.com\",\"password\":\"password123\",\"confirmPassword\":\"password123\"}";

        // First registration attempt
        restTemplate.postForEntity(url, requestBody, String.class);

        // Second registration attempt with the same email
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(409);
        assertThat(response.getBody()).contains("Email is already registered");
    }

    @Test
    public void testPasswordValidation() {
        String url = baseUrl + "/api/auth/register";
        String requestBody = "{\"fullName\":\"María Pérez\",\"email\":\"maria@example.com\",\"password\":\"123\",\"confirmPassword\":\"123\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody()).contains("Password must be at least 6 characters");

        requestBody = "{\"fullName\":\"María Pérez\",\"email\":\"maria@example.com\",\"password\":\"password123\",\"confirmPassword\":\"password456\"}";

        response = restTemplate.postForEntity(url, requestBody, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody()).contains("Passwords do not match");
    }
}