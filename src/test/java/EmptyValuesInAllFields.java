import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class EmptyValuesInAllFields {
    @Test(description = "We should use values in fields")
    public void noValuesInFields() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "");
        requestParams.put("bear_type", "");
        requestParams.put("bear_age", "");
        request.body(requestParams.toJSONString());
        Response response = request.put("/bear/99");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}