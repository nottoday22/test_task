import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class DeleteNonExistentBear {

    @Test(description = "We haven't bear/9933.")
    public void deleteNonExistentBear() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "");
        requestParams.put("bear_type", "");
        requestParams.put("bear_age", "");
        request.body(requestParams.toJSONString());
        Response response = request.delete("/bear/9933");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
}