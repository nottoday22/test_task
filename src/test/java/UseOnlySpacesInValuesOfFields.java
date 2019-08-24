import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BearClient;

public class UseOnlySpacesInValuesOfFields {
    @Test(description = "we're using only spaces in all fields")
    public void useOnlySpaces() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "    "); // no value
        requestParams.put("bear_type", "     "); // no value
        requestParams.put("bear_age", "     "); //no value
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }
}