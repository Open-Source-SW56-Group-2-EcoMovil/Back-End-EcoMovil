package upc.edu.ecomovil.api.acceptance.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class US16Steps {

    @Given("The user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        // Implementación para navegar a la página de registro
    }

    @When("Enters his full name {string}")
    public void enters_his_full_name(String fullName) {
        // Implementación para ingresar el nombre completo
    }

    @When("Enters a valid email {string}")
    public void enters_a_valid_email(String email) {
        // Implementación para ingresar un correo electrónico válido
    }

    @When("Creates a valid password {string}")
    public void creates_a_valid_password(String password) {
        // Implementación para ingresar una contraseña válida
    }

    @When("Confirms the password {string}")
    public void confirms_the_password(String confirmPassword) {
        // Implementación para confirmar la contraseña
    }

    @When("Accepts the terms and conditions")
    public void accepts_the_terms_and_conditions() {
        // Implementación para aceptar los términos y condiciones
    }

    @When("Presses the {string} button")
    public void presses_the_button(String button) {
        // Implementación para presionar el botón de registro
    }

    @Then("The system sends a POST request to {string} with the user data")
    public void the_system_sends_a_post_request_to_with_the_user_data(String endpoint) {
        // Implementación para verificar que se envía una solicitud POST con los datos del usuario
    }

    @Then("The server responds with a {int} code and a {string} message")
    public void the_server_responds_with_a_code_and_a_message(int statusCode, String message) {
        // Implementación para verificar la respuesta del servidor
    }

    @Then("The confirmation message is displayed on the registration page")
    public void the_confirmation_message_is_displayed_on_the_registration_page() {
        // Implementación para verificar que se muestra el mensaje de confirmación
    }

    @When("Enters an existing email {string}")
    public void enters_an_existing_email(String email) {
        // Implementación para ingresar un correo electrónico existente
    }

    @When("Fills out the other fields correctly")
    public void fills_out_the_other_fields_correctly() {
        // Implementación para llenar los otros campos correctamente
    }

    @Then("The error message is displayed on the registration page")
    public void the_error_message_is_displayed_on_the_registration_page() {
        // Implementación para verificar que se muestra el mensaje de error
    }

    @When("He enters a password {string}")
    public void he_enters_a_password(String password) {
        // Implementación para ingresar una contraseña
    }

    @When("Enters a password confirmation {string}")
    public void enters_a_password_confirmation(String confirmPassword) {
        // Implementación para ingresar la confirmación de la contraseña
    }

    @Then("The system displays an error message {string}")
    public void the_system_displays_an_error_message(String errorMessage) {
        // Implementación para verificar que se muestra el mensaje de error
    }
}