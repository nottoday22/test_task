import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;


public class DeleteRequestWithoutID {
    @Test(description = "We can't delete bear without ID")
    public void deleteRequestWithoutID() {
        RequestSpecification request = BearClient.bearClient();
        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Leo");
        requestParams.put("bear_type", "black");
        requestParams.put("bear_age", "12");
        request.body(requestParams.toJSONString());
        Response response = request.delete("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}