package tasks;

import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;
import userinterface.uTestRegister;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Register implements Task {

    private String first_Name;
    private String last_Name;
    private String email_Address;
    private String month_Birth;
    private String day_Birth;
    private String year_Birth;
    private String language_Language;
    private String city_City;
    private String postal_Code;
    private String country_Country;
    private String srtWindows;
    private String srtVersion;
    private String srtLanguage;
    private String srtMobile;
    private String srtModel;
    private String srtSystem;
    private String create_Password;
    private String confirm_Password;

    public Register(String first_Name, String last_Name, String email_Address, String month_Birth, String day_Birth, String year_Birth, String language_Language, String city_City, String postal_Code, String country_Country, String srtWindows, String srtVersion, String srtLanguage, String srtMobile, String srtModel, String srtSystem, String create_Password, String confirm_Password) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email_Address = email_Address;
        this.month_Birth = month_Birth;
        this.day_Birth = day_Birth;
        this.year_Birth = year_Birth;
        this.language_Language = language_Language;
        this.city_City = city_City;
        this.postal_Code = postal_Code;
        this.country_Country = country_Country;
        this.srtWindows = srtWindows;
        this.srtVersion = srtVersion;
        this.srtLanguage = srtLanguage;
        this.srtMobile = srtMobile;
        this.srtModel = srtModel;
        this.srtSystem = srtSystem;
        this.create_Password = create_Password;
        this.confirm_Password = confirm_Password;
    }

    public static Register OnThePage(String first_Name, String last_Name, String email_Address, String month_Birth, String day_Birth, String year_Birth, String language_Language, String city_City, String postal_Code, String country_Country,String srtWindows, String srtVersion, String srtLanguage, String srtMobile, String srtModel, String srtSystem,String create_Password, String confirm_Password) {
        return Tasks.instrumented(Register.class, first_Name, last_Name, email_Address, month_Birth, day_Birth, year_Birth, language_Language, city_City, postal_Code, country_Country,srtWindows,srtVersion,srtLanguage,srtMobile,srtModel,srtSystem,create_Password, confirm_Password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue((first_Name)).into(uTestRegister.Input_Firts_Name),
                Enter.theValue((last_Name)).into(uTestRegister.Input_Last_Name),
                Enter.theValue((email_Address)).into(uTestRegister.Input_Email),
                SelectFromOptions.byVisibleText((month_Birth)).from(uTestRegister.Input_Mont),
                SelectFromOptions.byVisibleText((day_Birth)).from(uTestRegister.Input_Day),
                SelectFromOptions.byVisibleText((year_Birth)).from(uTestRegister.Input_Year),
                Click.on(uTestRegister.Input_Language),
                Enter.theValue((language_Language)).into(uTestRegister.Input_Language).thenHit(Keys.ENTER),
                Click.on(uTestRegister.Next_Button),
                WaitUntil.the(uTestRegister.City, WebElementStateMatchers.isEnabled()),
                Enter.theValue((city_City)).into(uTestRegister.City),
                Hit.the(Keys.ARROW_DOWN).into(uTestRegister.City),
                WaitUntil.the(uTestRegister.City, WebElementStateMatchers.isEnabled()),
                Hit.the(Keys.ENTER).into(uTestRegister.City),
                WaitUntil.the(uTestRegister.Zip, WebElementStateMatchers.isEnabled()),
                Enter.theValue((postal_Code)).into(uTestRegister.Zip),
                Click.on(uTestRegister.Country),
                Enter.theValue((country_Country)).into(uTestRegister.Country_Container).thenHit(Keys.ARROW_DOWN, Keys.ENTER),
                Click.on(uTestRegister.Next_Button_Devices),
                /*Devices*/
                Click.on(uTestRegister.Container_Computer),
                Enter.theValue((srtWindows)).into(uTestRegister.input_Computer),
                Click.on(uTestRegister.Container_Version),
                Enter.theValue((srtVersion)).into(uTestRegister.Input_Version),
                Click.on(uTestRegister.Container_Language),
                Enter.theValue((srtLanguage)).into(uTestRegister.Input_LanguageComputer),
                Click.on(uTestRegister.Container_Mobile),
                Enter.theValue((srtMobile)).into(uTestRegister.Input_Mobile).thenHit(Keys.ARROW_DOWN, Keys.ENTER),
                Click.on(uTestRegister.Container_Model),
                Enter.theValue((srtModel)).into(uTestRegister.Input_Model).thenHit(Keys.ARROW_DOWN, Keys.ENTER),
                Click.on(uTestRegister.Container_System),
                Enter.theValue((srtSystem)).into(uTestRegister.Input_System).thenHit(Keys.ARROW_DOWN, Keys.ENTER),
                /*Fin Devices*/
                Click.on(uTestRegister.Button_Next_Last),
                Enter.theValue((create_Password)).into(uTestRegister.Password),
                Enter.theValue((confirm_Password)).into(uTestRegister.Confirm_Password),
                Click.on(uTestRegister.Informed),
                Click.on(uTestRegister.Terms),
                Click.on(uTestRegister.Privacy),
                Click.on(uTestRegister.Button_Complete)
        );
    }
}
