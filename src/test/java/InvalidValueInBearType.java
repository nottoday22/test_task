import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class InvalidValueInBearType {
    @Test(description = "bear_type have only 4 values, all another are invalid")
    public void invalidValueInBearType() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Leo");
        requestParams.put("bear_type", "true");
        requestParams.put("bear_age", "12");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}