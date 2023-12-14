package test;

import data.DataHelper;
import page.Dashboard;
import page.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.codeborne.selenide.Selenide.open;

public class Test {

    @org.junit.jupiter.api.Test
    void shouldOpenFillForm() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getCode();
        var dashboard = verificationPage.validCode(verificationCode);
        int amountOnCard = dashboard.getFirstCardBalance();
        int amountToTransfer = DataHelper.generateAmount(amountOnCard);
        dashboard.makeDeposit().transfer(amountToTransfer);
        int expectedAmount = amountOnCard + amountToTransfer;
        int actualAmount = dashboard.getFirstCardBalance();
        assertEquals(expectedAmount, actualAmount);
    }
}
