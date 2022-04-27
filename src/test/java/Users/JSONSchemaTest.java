package Users;

import api.CreateUserApi;
import api.models.UserModel;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaTest {
    private  CreateUserApi createUserApi;
    @BeforeTest
    public void connect() {
        createUserApi = new CreateUserApi();
    }


    @Test
    public void createUserWithLatinFIO(){
        String firstName = "Ivanov";
        String lastName = "Ivan";

        UserModel userModel = UserModel.builder().id(123L).email("email@mail.ru").firstName(firstName).lastName(lastName).password("password")
                .phone("78932545215").username("username").build();
        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};
        CreateUserApi arrayUserApi = new CreateUserApi();

        arrayUserApi.createWithArrayUser(userListToCrete).then().log().all().body(matchesJsonSchemaInClasspath("schema/UserById.json"));
    }

}
