package saucedemo.testObject.objects;

public interface IProductDetailObject extends IBaseObject{
    String getBackPackButtonText();
    String getProductName();
    void removeProductFromCart();
    void addProductToCart();
    void goBackToProducts();

}
