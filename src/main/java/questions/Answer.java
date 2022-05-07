package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.uTestRegister;

public class Answer implements Question<Boolean>{

    private String srtQuestion;

    public Answer(String srtQuestion) {
        this.srtQuestion = srtQuestion;
    }

    public static Answer toThe(String srtQuestion) {
        return new Answer(srtQuestion);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String text= Text.of(uTestRegister.Text).viewedBy(actor).asString();
        if(srtQuestion.equals(text)){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}
