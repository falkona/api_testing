package ddnTesting.api;

import ddnTesting.models.ApiResponse;
import ddnTesting.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApiService {

    @GET("user/{username}")
    Call<User> getUserByName(@Path("username") String userName);

    @POST("user")
    Call<ApiResponse> createUser(@Body User user);

}
