package saucedemo.rest.serviceObjects;

public class AllServices {
    public RandomPostcodeService randomPostcode;
    public PostcodesService postcodes;
    public TerminatedPostcodesService terminatedPostcodes;
    public OutcodesService outcodes;

    public AllServices(){
        randomPostcode = new RandomPostcodeService();
        postcodes = new PostcodesService();
        terminatedPostcodes = new TerminatedPostcodesService();
        outcodes = new OutcodesService();
    }
}
