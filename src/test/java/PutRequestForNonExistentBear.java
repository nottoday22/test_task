import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class PutRequestForNonExistentBear {
    @Test(description = "We cant use put request for non existent bear.")
    public void nonExistentBear() {
        RequestSpecification request = BearClient.bearClient();
        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "kolya");
        requestParams.put("bear_type", "BROWN");
        requestParams.put("bear_age", "22");

        request.body(requestParams.toJSONString());
        Response response = request.put("/bear/999");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
}