import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class AddOneMoreField {
    @Test(description = " We can't add another fields.")
    public void addOneMoreFieldInPostRequest() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Saint");
        requestParams.put("bear_type", "POLAR");
        requestParams.put("bear_age", "122");
        requestParams.put("wolf", "Red");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 405);
    }
}