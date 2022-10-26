package ddnTesting.api;
;
import ddnTesting.models.ApiResponse;
import ddnTesting.models.User;
import lombok.SneakyThrows;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiGateway {

    private final String BASE_URL = "https://petstore.swagger.io/v2/";
    private UserApiService service;

    public UserApiGateway() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(UserApiService.class);
    }

    @SneakyThrows
    public Response<ApiResponse> createUser(User userData) {
        return service.createUser(userData).execute();
    }

    @SneakyThrows
    public Response<User> getUserByName(String userName) {
        return service.getUserByName(userName).execute();
    }

}
