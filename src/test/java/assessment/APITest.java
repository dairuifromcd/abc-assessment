package assessment;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;

@RunWith(Parameterized.class)
public class APITest {
    private static final String APIV1 = "api/v1/programs/";
    private static final String SUFFIX = ".json";
    private static final String MORNING_ARID = "ppJj0E8g2R";
    private static final String AFTERNOON_ARID = "ppxa2Amj2b";
    private static final String TEST = "http://test-program.abcradio.net.au/";
    private static final String STAGING = "http://staging-program.abcradio.net.au/";
    private static final String PRODUCTION = "http://program.abcradio.net.au/";

    private static final String ENTITY = "entity";
    private static final String ARID = "arid";
    private static final String TITLE = "title";

    private String domain;
    private String programID;
    private String json;

    public APITest(String domain, String programID) {
        this.domain = domain;
        this.programID = programID;
    }

    @Parameterized.Parameters
    public static Collection completeURL() {
        return Arrays.asList(new String[][] {
                //{STAGING, AFTERNOON_ARID},
                //{STAGING, MORNING_ARID},
                //{TEST, AFTERNOON_ARID},
                //{TEST, MORNING_ARID},
                {PRODUCTION, AFTERNOON_ARID},
                {PRODUCTION, MORNING_ARID}
        });
    }

    @Test
    public void testAPIV1Programs() {
        String url = domain + APIV1 + programID + SUFFIX;

        Response response =
        when().
                get(url).
        then().
                statusCode(200).
                contentType(JSON).
                body(ENTITY, Matchers.equalTo("Program")).
        extract().
                response();

        json = response.asString();

        if (programID.equals(MORNING_ARID)) {
            morningAPIChecker();
        } else if (programID.equals(AFTERNOON_ARID)) {
            afternoonAPIChecker();
        }
    }

    private void morningAPIChecker() {
        Assert.assertEquals(MORNING_ARID, getJsonValue(ARID));
        Assert.assertEquals("Mornings", getJsonValue(TITLE));
    }

    private void afternoonAPIChecker() {
        Assert.assertEquals(AFTERNOON_ARID, getJsonValue(ARID));
        Assert.assertEquals("Afternoons", getJsonValue(TITLE));
    }

    private String getJsonValue(String key) {
        return JsonPath.from(json).get(key);
    }
}
