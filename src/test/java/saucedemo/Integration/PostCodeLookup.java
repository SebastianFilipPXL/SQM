package saucedemo.Integration;

import org.apache.commons.lang.StringUtils;
import saucedemo.rest.models.Postcode;
import saucedemo.rest.serviceObjects.AllServices;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class PostCodeLookup {
    AllServices services;

    @BeforeClass
    public void setup(){
        services = new AllServices();
    }

    @Test
    public void getRandomPostcode(){
        String randomPostcodeNumber = services.randomPostcode.getRandomPostcode().postcode;
        Response getPostcode = services.postcodes.getPostcodeResponse(randomPostcodeNumber);

        assertThat(getPostcode.statusCode()).isEqualTo(200);
    }

    @Test
    public void getNearestPostcode(){
        Postcode randomPostcode = services.randomPostcode.getRandomPostcode();
        List<Postcode> nearestPostcodes = services.postcodes.getPostcodes(randomPostcode.latitude, randomPostcode.longitude);
        for (Postcode postcode : nearestPostcodes){
            System.out.println(postcode.postcode);
            assertThat(postcode.postcode).isNotEmpty();
        }
    }

    @Test
    public void validatePostcode(){
        String randomPostcodeNumber = services.randomPostcode.getRandomPostcode().postcode;
        Response validatePostcode = services.postcodes.getValidation(randomPostcodeNumber);

        assertThat(validatePostcode.statusCode()).isEqualTo(200);
    }

    @Test
    public void autocompletePostcode(){
        String randomPostcodeNumber = services.randomPostcode.getRandomPostcode().postcode;
        randomPostcodeNumber = StringUtils.chop(randomPostcodeNumber);
        randomPostcodeNumber = StringUtils.chop(randomPostcodeNumber);

        Response autocompletePostcode = services.postcodes.getAutocompletion(randomPostcodeNumber);

        assertThat(autocompletePostcode.statusCode()).isEqualTo(200);
    }

    @Test
    public void queryPostcode(){
        String randomPostcodeNumber = services.randomPostcode.getRandomPostcode().postcode;

        Response queryPostcode = services.postcodes.getQuery(randomPostcodeNumber);

        assertThat(queryPostcode.statusCode()).isEqualTo(200);
    }

    @Test
    public void getOutcode(){
        String randomOutcode = services.outcodes.getRandomOutcode();

        Response outcodeResponse = services.outcodes.getOutcodeResponse(randomOutcode);

        assertThat(outcodeResponse.statusCode()).isEqualTo(200);
    }

    @Test
    public void getNearestOutcode(){
        String randomOutcode = services.outcodes.getRandomOutcode();

        Response outcodeResponse = services.outcodes.getNearestOutcodeResponse(randomOutcode);

        assertThat(outcodeResponse.statusCode()).isEqualTo(200);
    }

    @Test
    public void getNearestLatAndLonOutcode(){
        double longitude = services.outcodes.getRandomLongitude();
        double latitude = services.outcodes.getRandomLatitude();

        Response outcodeResponse = services.outcodes.getNearestOutcodeLatAndLonResponse(longitude, latitude);

        assertThat(outcodeResponse.statusCode()).isEqualTo(200);
    }

    @Test
    public void getTerminatedPostcode(){
        String randomPostcodeNumber = services.randomPostcode.getRandomPostcode().postcode;

        Response terminatedPostcodeResponse = services.terminatedPostcodes.getTerminatedPostcode(randomPostcodeNumber);

        assertThat(terminatedPostcodeResponse.statusCode()).isAnyOf(200, 404);
    }
}
