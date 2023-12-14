package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DepositPage {
    //private SelenideElement head = $("h1.heading");
    private SelenideElement amount = $$(By.className("input__control")).get(0);
    private SelenideElement from = $$(By.className("input__control")).get(1);
    private SelenideElement deposit = $$(By.className("button")).get(0);
    public DepositPage() {
    }

    public Dashboard transfer(int amountToTransfer) {
        amount.setValue(Integer.toString(amountToTransfer));
        from.setValue("5559 0000 0000 0002");
        deposit.click();
        return new Dashboard();
    }


}
