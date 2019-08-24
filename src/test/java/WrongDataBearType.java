import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class WrongDataBearType {
    @Test(description = "bear_type can't be asfaggas")
    public void wrongDataBearType() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Saint");
        requestParams.put("bear_type", "asfgagas");
        requestParams.put("bear_age", "122");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}