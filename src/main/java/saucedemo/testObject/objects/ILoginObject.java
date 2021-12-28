package saucedemo.testObject.objects;

public interface ILoginObject extends IBaseObject {
    void fillInUsername(String username);
    void fillInPassword(String password);
    void clickLogin();
    void login(String username, String password);
    String getErrormessage();
    String getURL();
}
