package saucedemo.rest.serviceObjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import saucedemo.rest.models.Postcode;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import saucedemo.rest.models.Postcode;

import java.util.HashMap;

import static io.restassured.RestAssured.when;

public class RandomPostcodeService extends BaseService {
    private String endpoint;

    public RandomPostcodeService(){
        endpoint = "random/postcodes";
    }

    public Postcode getRandomPostcode(){
        return Postcode.getPostcode(getRandomPostcodeResponse());
    }

    public Response getRandomPostcodeResponse(){
        return when().get(baseURL + endpoint);
    }
}

