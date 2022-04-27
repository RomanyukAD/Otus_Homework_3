package api;

import api.constants.EndpointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api.models.UserModel;
import java.util.List;
import static io.restassured.RestAssured.given;

public class CreateUserApi {
    private String baseURL = "https://petstore.swagger.io/v2/";
    private final RequestSpecification spec;


    public CreateUserApi() {
        spec = given().baseUri(baseURL).contentType(ContentType.JSON);
    }


    public Response createWithArrayUser(List<UserModel> user) {
        return given(spec).body(user).log().all().when().post(EndpointsPath.CREATE_USER);
    }


    public Response getUserByUserName (String username) {
        return given(spec).log().all().when().get(String.format(EndpointsPath.GET_USER_BY_USERNAME, username));
    }




}
