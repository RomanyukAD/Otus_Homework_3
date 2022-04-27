package Users;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.models.UserModel;
import api.CreateUserApi;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CreateUserArrayTest {
    private  CreateUserApi createUserApi;
    private static Faker faker;
    private Faker fakerRu;

    @BeforeTest
    public void connect() {
        createUserApi = new CreateUserApi();
        faker = new Faker();
        fakerRu = new Faker(new Locale("ru"));
    }

    @Test(dataProvider = "getFlightData")
    public void createUserWithKirillicFIO(String lastName, String firstName){
        UserModel userModel = UserModel.builder().id(123L).email("email@mail.ru").firstName(firstName).lastName(lastName).password("password")
                .phone("78932545215").username("username").build();
        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};
        createUserApi.createWithArrayUser(userListToCrete).then().statusCode(HttpStatus.SC_OK);;
    }

    @DataProvider
    public Object[][] getFlightData() {
        return new Object[][]{
                {"Ivanov Petrov", "Ivan Petr"},//Создание пользователя с двойными именем и фамилией, разделенными пробелом
                {"Ivanov-Petrov", "Ivan-Petr"},//Создание пользователя с двойными именем и фамилией, разделенными дефисом
                {"Ivanov", "Ivan"},//Создание пользователя с ФИО латиницей
                {"Иванов", "Иван"},//Создание пользователя с ФИО кириллицей
                {"Иванов", "И"},//Имя длиной в 1 символ
                {"И", "Иван"},//Фамилия длиной в 1 символ
        };
    }


    @Test
    public void getUserByName (){
        String username = faker.regexify("[a-z]{5}");
        String firstName = fakerRu.name().firstName();
        String lastName = fakerRu.name().lastName();
        Long id = 1L;

        UserModel userModel = UserModel.builder().id(id).email("email@mail.ru").firstName(firstName).lastName(lastName).password("password")
                .phone("78932545215").username(username).build();
        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};
        Response   respArrayUserApi = createUserApi.createWithArrayUser(userListToCrete);
        respArrayUserApi.then().statusCode(HttpStatus.SC_OK);
        Response  respGetUser = createUserApi.getUserByUserName(username);
        respGetUser.then().statusCode(HttpStatus.SC_OK);

    }

    @Test(dataProvider = "id")
    public void createUserWithDifferentId(Long id){
        String username = faker.regexify("[a-z]{5}");
        String firstName = fakerRu.name().firstName();
        String lastName = fakerRu.name().lastName();

        UserModel userModel = UserModel.builder().id(id).email("email@mail.ru").firstName(firstName).lastName(lastName).password("password")
                .phone("78932545215").username(username).build();
        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};
        Response   respArrayUserApi = createUserApi.createWithArrayUser(userListToCrete);
        respArrayUserApi.then().statusCode(HttpStatus.SC_OK);
        Response  respGetUser = createUserApi.getUserByUserName(username);
        respGetUser.then().statusCode(HttpStatus.SC_OK);
    }

    @DataProvider
    public Object[][] id() {
        return new Object[][]{
                {0L},
                {10L},
                {100L},
                {1000L}
        };
    }


    @Test(dataProvider = "userNames")
    public void createUserWithDifferentUserNames(String username){
        String firstName = fakerRu.name().firstName();
        String lastName = fakerRu.name().lastName();

        UserModel userModel = UserModel.builder().id(1L).email("email@mail.ru").firstName(firstName).lastName(lastName).password("password")
                .phone("78932545215").username(username).build();
        List<UserModel> userListToCrete = new ArrayList<UserModel>() {{add(userModel);}};
        Response   respArrayUserApi = createUserApi.createWithArrayUser(userListToCrete);
        respArrayUserApi.then().statusCode(HttpStatus.SC_OK);
        Response  respGetUser = createUserApi.getUserByUserName(username);
        respGetUser.then().statusCode(HttpStatus.SC_OK);
    }

    @DataProvider
    public Object[][] userNames() {
        return new Object[][]{
                {"d"},//длиной в 1 символ
                {"Админ"},//кириллица
                {"Admin"},//латиница
                {"Правильный Admin"},//кириллица + латиница
                {"Admin1"}//содержит цифры
        };
    }


}
