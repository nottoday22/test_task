import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class ChangeBearNameWithPutRequest {
    @Test(description = "Name don't changing.")
    public void changeBearNameWithPutRequest() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "los");
        requestParams.put("bear_type", "BLACK");
        requestParams.put("bear_age", "12");
        request.body(requestParams.toJSONString());
        Response response = request.put("/bear/119");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}