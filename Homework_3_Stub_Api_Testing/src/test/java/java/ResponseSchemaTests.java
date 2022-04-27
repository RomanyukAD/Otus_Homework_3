package java;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static helpers.Helpers.buildRequest;
import static helpers.Helpers.executeGetRequest;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ResponseSchemaTests {

  @Test
  void contextLoads() {
  }


  @Test
  public void GetAllCoursesTest() {
    String url = "http://localhost:8080/cource/get/all";
    RequestSpecification request = buildRequest();
    Response response = executeGetRequest(request, url);
    response.then().log().all().statusCode(200).body("name[0]", is("QA java"),
            "price[0]", is(15000) );
  }

  @Test
  public void GetAllUsersTest() {
    String url = "http://localhost:8080/user/get/all";
    RequestSpecification request = buildRequest();
    Response response = executeGetRequest(request, url);
    response.then().log().all().statusCode(200).body("name[0]", is("Test user"),
            "course[0]", is("QA"), "email[0]", is("test@test.test"),
            "age[0]", is(23));
  }


  @Test
  public void GetUserByIdSchemaTest() {
    String url = "http://localhost:8080/user/get/123";
    RequestSpecification request = buildRequest();
    Response response = executeGetRequest(request, url);
    response.then().log().all().statusCode(200).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Score.json"));
  }

  @Test
  public void GetAllCoursesSchemaTest() {
    String url = "http://localhost:8080/cource/get/all";
    RequestSpecification request = buildRequest();
    Response response = executeGetRequest(request, url);
    response.then().log().all().statusCode(200).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Courses.json"));
  }
}
