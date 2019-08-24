import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;


public class SmallLettersInBearTypeField {
    @Test(description = "Can't create bear if bear_type use small letters ")
    public void smallLettersInBearTypeField() {

            RequestSpecification request = BearClient.bearClient();

            JSONObject requestParams = new JSONObject();
            requestParams.put("bear_name", "Leo");
            requestParams.put("bear_type", "black");
            requestParams.put("bear_age", "12");
            request.body(requestParams.toJSONString());
            Response response = request.post("/bear");
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 400);

    }
}

//использование тестнг с мавеном, почитать тестнг



