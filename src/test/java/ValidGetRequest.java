import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BearClient;


public class ValidGetRequest {
    @BeforeTest

    public void doPostRequest() {
        RequestSpecification request = BearClient.bearClient();

        JSONObject requestParams = new JSONObject();
        requestParams.put("bear_name", "Saint");
        requestParams.put("bear_type", "POLAR");
        requestParams.put("bear_age", "122");
        request.body(requestParams.toJSONString());
        Response response = request.post("/bear");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);
    }
    @Test
    public void validGetRequest() {
        RequestSpecification request = BearClient.bearClient();
        Response response = request.get("/bear/1");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(bodyStringValue.contains("bear_type"));
        Assert.assertTrue(bodyStringValue.contains("bear_name"));
        Assert.assertTrue(bodyStringValue.contains("bear_age"));
        System.out.println(bodyStringValue);
    }
}