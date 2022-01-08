package saucedemo.testObject.objects;

public interface IProductObject extends IBaseObject {
    void selectFilterAtoZ();
    void selectFilterZtoA();
    void selectFilterLowToHigh();
    void selectFilterHighToLow();
    void goToCart();
    void addProductToCart();
    void removeProductFromCart();
    void clickBackPack();
    String getBackPackButtonText();
    String getFirstItemText();
    String getURL();
    String getBackpackName();

}
