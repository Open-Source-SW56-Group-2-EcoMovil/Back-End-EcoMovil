package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcomovilApiApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRegistrationEndpoint() {
        String url = "/api/auth/register";
        String requestBody = "{\"fullName\":\"María Pérez\",\"email\":\"maria@example.com\",\"password\":\"password123\",\"confirmPassword\":\"password123\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).contains("Registration successful");
    }
}