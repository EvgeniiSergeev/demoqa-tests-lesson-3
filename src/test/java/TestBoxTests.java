import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll

    static void beforeAll () {

        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {


          open("/text-box");

          $("#userName").setValue("Evgenii"); // [id=userName] = #userName [class=userName] = .userName
          $("#userEmail").setValue("evgenii@mail.ru");
          $("#currentAddress").setValue("Some address 1");
          $("#permanentAddress").setValue("Another address 1");
          $("#submit").click();

          $("#output").shouldHave( text("Evgenii"), text("evgenii@mail.ru"),
                  text("Some address 1"), text("Another address 1"));
}
}
