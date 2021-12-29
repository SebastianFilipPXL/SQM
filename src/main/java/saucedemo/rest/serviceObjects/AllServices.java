package saucedemo.rest.serviceObjects;

public class AllServices {
    public RandomPostcodeService randomPostcode;
    public PostcodesService postcodes;

    public AllServices(){
        randomPostcode = new RandomPostcodeService();
        postcodes = new PostcodesService();
    }
}
