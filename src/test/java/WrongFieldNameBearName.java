import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class WrongFieldNameBearName {
    @Test(description = "bear_nme is wrong, should be bear_name")
    public void wrongFieldNameBearName() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_nme", "Leo");
        requestParams.put("bear_type", "Black");
        requestParams.put("bear_age", "12");
        request.body(requestParams.toJSONString());
        Response response = request.put("/bear/99");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}