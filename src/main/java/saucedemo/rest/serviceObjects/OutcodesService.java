package saucedemo.rest.serviceObjects;

import io.restassured.response.Response;
import saucedemo.rest.models.Postcode;

import java.security.PublicKey;

import static io.restassured.RestAssured.when;

public class OutcodesService extends BaseService{
    private String endpoint;

    public OutcodesService(){
        endpoint = "outcodes/";
    }

    public String getRandomOutcode(){
        String outcode = Postcode.getPostcode(getRandomPostcodeResponse()).outcode;
        return outcode;
    }

    public double getRandomLatitude(){
        double latitude = Postcode.getPostcode(getRandomPostcodeResponse()).latitude;
        return latitude;
    }

    public double getRandomLongitude(){
        double longitude = Postcode.getPostcode(getRandomPostcodeResponse()).longitude;
        return longitude;
    }

    public Response getRandomPostcodeResponse(){
        return when().get(baseURL + "random/postcodes");
    }

    public Response getOutcodeResponse(String outcode){
        return  when().get(baseURL + endpoint + outcode);
    }

    public Response getNearestOutcodeResponse(String outcode){
        return when().get(baseURL + endpoint + outcode + "/nearest");
    }

    public Response getNearestOutcodeLatAndLonResponse(double longitude, double latitude){
        return when().get(baseURL + endpoint + "?lon=" + longitude + "&lat=" + latitude);
    }
}
