import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class PostRequestWithIdInUrl {
    @Test(description = "we should not use id in post request to create bear")
    public void postRequestWithIdInUrl() {
        RequestSpecification request = BearClient.bearClient();
        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Leo");
        requestParams.put("bear_type", "BLACK");
        requestParams.put("bear_age", "12");

        request.body(requestParams.toJSONString());
        Response response = request.post("/bear/999");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 405);
    }
}