import org.junit.jupiter.api.Test;

public class TestGender extends BrowserDriver {


    @Test
    public void LoginShop(){
        testFunctions.loginSection()
                .waitForSecond()
                .myAccountHover()
                .clickLoginInMyAccountButton()
                .waitForSecond()
                .setCorrectEmail()
                .waitForSecond()
                .loginBtnClick()
                .waitForSecond()
                .setCorrectPassword()
                .selectEmailBtnClick()
                .waitForSecond();
        testFunctions.shoppingSection()
                .search()
                .searchClick()
                .waitForSecond()
                .firstProductHover()
                .firstProductAddBasketClick()
                .thirdProductHover()
                .thirdProductAddBasketClick()
                .waitForSecond()
                .myShoppingBasketClick()
                .assertBasketFirstProduct()
                .assertBasketFirstProduct()
                .assertIncreasementOfProduct()
                .homePageButtonClick();
        testFunctions.loginSection()
                .signOutClick();
    }


}