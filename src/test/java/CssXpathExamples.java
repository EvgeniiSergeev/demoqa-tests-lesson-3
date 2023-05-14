import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">

        // Examples
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">

        // Examples
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $("input#email").setValue("1");
        $x("//*[@id='email']").setValue("1"); // * - значит любой элемент
        $x("//input[@id='email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email"

        // Examples
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box"

        // Examples
        $("[class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box"
        // </div>

        // Examples
        $(".inputtext").$("login_form_input_box").setValue("1");
        $(".inputtext .login_form_input_box").setValue("1");


        // Ищем по тексту
        //<div>Hello, qa.guru!</div>

        // Examples
        $x("//div[text()='Hello, qa.guru']").click();
        $(byText("Hello, qa.guru!")).click();
        $(withText("llo,qa.gur")).click();

    }

}
