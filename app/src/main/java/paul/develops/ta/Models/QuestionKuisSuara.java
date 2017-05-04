package paul.develops.ta.Models;

import android.app.Activity;

/**
 * Created by paulms on 4/26/2017.
 */

public class QuestionKuisSuara extends Activity {

    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;

    private String ANSWER;

    public QuestionKuisSuara() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";

        ANSWER = "";

    }

    public QuestionKuisSuara(String qUESTION, String oPTA, String oPTB, String oPTC,
                    String aNSWER) {
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;

        ANSWER = aNSWER;

    }

    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }

    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }

    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }

    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }

    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
}
