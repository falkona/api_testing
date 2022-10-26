package ddnTesting.tests;

import com.github.javafaker.Faker;
import ddnTesting.api.UserApiGateway;
import ddnTesting.models.ApiResponse;
import ddnTesting.models.User;
import ddnTesting.utils.DateUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import retrofit2.Response;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {

    private final UserApiGateway gateway = new UserApiGateway();
    private final DateUtils dateUtils = new DateUtils();
    private final Faker faker = new Faker();

    private User userData = new User()
            .setUsername(faker.random().hex())
            .setFirstName(faker.name().firstName())
            .setLastName(faker.name().lastName())
            .setEmail(faker.internet().emailAddress())
            .setPassword(faker.harryPotter().spell())
            .setPhone(faker.phoneNumber().cellPhone());

    @Test
    @Order(1)
    public void createUserTest() {
        Response<ApiResponse> response = gateway.createUser(userData);
        int code = response.code();
        // Код ответа 200
        assertEquals(200, code, "Код ответа не 200");
        // Полезная нагрузка ответа ок
        assertNotNull(response.body(), "Тело ответа пустое");
        assertEquals(200, response.body().getCode(), "Значение поля код не 200");
        assertEquals("unknown", response.body().getType(), "Значение поля Тип не unknown");
        assertNotNull(response.body().getMessage(), "Поле Message gecnjt");
        // Заголовки ок
        assertTrue(response.headers().get("date").contains(dateUtils.currentDateToString("E, dd MMM yyyy", Locale.US)), "Некорректный " +
                "заголовок date");
        userData.setId(Long.parseLong(response.body().getMessage()));
    }

    @Test
    @Order(2)
    public void getUserTest() {
        Response<User> response = gateway.getUserByName(userData.getUsername());
        assertEquals(userData, response.body(), "Данные пользователей не совпадают");
    }

}
