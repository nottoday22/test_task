import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class CapitalLetterInField {
    @Test(description = "should be bear_type.")
    public void capitalLetterInField() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Leo");
        requestParams.put("Bear_type", "BLACK");
        requestParams.put("bear_age", "12");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}