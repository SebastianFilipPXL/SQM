package saucedemo.Integration;

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
}
