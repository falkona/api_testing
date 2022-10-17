package ddnTesting.tests;

import ddnTesting.api.UserApiGateway;
import ddnTesting.models.ApiResponse;
import ddnTesting.models.User;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    UserApiGateway gateway = new UserApiGateway();

    @Test
    public void createUserShouldReturn200() {
        User userData = new User()
                .setUsername("dariaNos1")
                .setFirstName("daria")
                .setLastName("nos")
                .setEmail("dd@dd.ru")
                .setPhone("79099999999");

        Response<ApiResponse> response = gateway.createUser(userData);
        int code = response.code();
        assertEquals(200, code, "Код ответа не 200");
    }

}
