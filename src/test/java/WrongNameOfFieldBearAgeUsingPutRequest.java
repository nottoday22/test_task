import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class WrongNameOfFieldBearAgeUsingPutRequest {
    @Test(description = "bear_ag is wrong. should be bear_age")
    public void wrongNameOfFielBearAgedUsingPutRequest() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Leo");
        requestParams.put("bear_ty", "Black");
        requestParams.put("bear_ag", "12");
        request.body(requestParams.toJSONString());
        Response response = request.put("/bear/99");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}