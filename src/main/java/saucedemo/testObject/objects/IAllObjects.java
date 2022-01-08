package saucedemo.testObject.objects;

public interface IAllObjects {
    ILoginObject loginObject();
    IProductObject productObject();
    IProductDetailObject productDetailObject();
    IProductOverviewObject productOverviewObject();
    IShoppingCartObject shoppingCartObject();
    ICheckoutInformationObject checkoutInformationObject();
    void quit();
}