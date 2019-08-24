import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;



public class InvalidDataBearAge {
    @Test(description = "it's not right when bear_age = sljghj%!@%!6")
    public void invalidDataBearAge() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Saint");
        requestParams.put("bear_type", "asfgagas");
        requestParams.put("bear_age", "gahk@E$");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 405);
    }
}