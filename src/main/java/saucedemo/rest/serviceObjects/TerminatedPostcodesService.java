package saucedemo.rest.serviceObjects;

import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class TerminatedPostcodesService extends BaseService{
    private String endpoint;

    public TerminatedPostcodesService(){
        endpoint = "terminated_postcodes/";
    }

    public Response getTerminatedPostcode(String postcode){
        return when().get(baseURL + endpoint + postcode);
    }
}
