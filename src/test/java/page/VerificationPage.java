package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
        private SelenideElement codeField = $("[data-test-id=\"code\"] input");
    //private SelenideElement codeField1 = $("input[data-test-id = 'code']"); // вот так не надо
    private SelenideElement button = $("button[role = 'button']");
    public VerificationPage () {
        codeField.shouldBe(Condition.visible);
    }

    public Dashboard validCode(DataHelper.VerificationCode code) {
        codeField.setValue(code.getCode());
        button.click();
        return new Dashboard();
    }
}
