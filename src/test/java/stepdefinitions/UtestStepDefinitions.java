package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.*;
import java.util.List;
import model.UtestData;
import questions.Answer;


public class UtestStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^carloslesmes abre la pagina Utest y da click en el boton JoinToday$")
    public void alexAbreLaPaginaUtestYDaClickEnElBotonJoinToday() {
        OnStage.theActorCalled("carloslesmes").wasAbleTo(OpenUp.thepage());
    }

    @When("^Luego continua con el registro de sus datos en los formularios$")
    public void luegoContinuaConElRegistroDeSusDatosEnLosFormularios(List<UtestData>utestData) {
        OnStage.theActorInTheSpotlight().wasAbleTo(Register.OnThePage(utestData.get(0).getFirst_Name(), utestData.get(0).getLast_Name(), utestData.get(0).getEmail_Address(), utestData.get(0).getMonth_Birth(), utestData.get(0).getDay_Birth(), utestData.get(0).getYear_Birth(), utestData.get(0).getLanguage_Language(), utestData.get(0).getCity_City(), utestData.get(0).getPostal_Code(), utestData.get(0).getCountry_Country(),utestData.get(0).getSrtWindows(),utestData.get(0).getSrtVersion(),utestData.get(0).getSrtLanguage(),utestData.get(0).getSrtMobile(),utestData.get(0).getSrtModel(),utestData.get(0).getSrtSystem(),utestData.get(0).getCreate_Password(), utestData.get(0).getConfirm_Password()));
    }

    @Then("^Por ultimo da click y lee el mensaje del boton$")
    public void porUltimoDaClickYLeeElMensajeDelBotonCompleteSetup(List<UtestData>utestData) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(utestData.get(0).getSrtQuestion())));
    }

}
