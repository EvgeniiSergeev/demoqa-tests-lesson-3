import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

        @BeforeAll

    static void beforeAll() {

        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

        @Test
        void successfulRegistrationTest() {
            String userName = "Evgenii";

            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()"); // удаление банеров рекламы со страницы
            executeJavaScript("$('footer').remove()"); // удаление банеров рекламы со страницы

            $("#firstName").setValue(userName); // [id=userName] = #userName [class=userName] = .userName
            $("#lastName").setValue("Bokov");
            $("#userEmail").setValue("evgenii@mail.ru");
//        $("#gender-radio-1").click(); // wrong
//        $("#gender-radio-3").parent().click(); // ищем радиокнопку через родителя и тапаем на нее
//        $(byText("Other")).click(); // not very good
            $("#genterWrapper").$(byText("Other")).click(); // не очень хороший пример с выбором кнопки для определ локали
//        $("label[for=gender-radio-3]").click(); // ищем радиокнопку через лэйбл и тапаем на нее
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click(); //// выбор даты рождения в календаре
            $(".react-datepicker__month-select").selectOption("September");  // выбираем день в месяце
//        $(".react-datepicker__month-select").selectOptionByValue("6");
            $(".react-datepicker__year-select").selectOption("1988");
//        <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
//        <div class="react-datepicker__day--030"                                     >30</div>
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click(); // ищем чекбокс и тапаем на нее
//        $("#hobbies-checkbox-1").parent().click();
            $("#uploadPicture").uploadFromClasspath("img/1.png"); // добавление файлика
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
            $("#currentAddress").setValue("Some address 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click(); // выбираем из списка
//        $("#react-select-3-option-0").click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click(); // выбираем из списка
            $("#submit").click();

            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text(userName), text("Bokov"),
                    text("evgenii@mail.ru"), text("1234567890"));
        }
}
