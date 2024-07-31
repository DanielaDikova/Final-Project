package utilis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentGeneration {

    public String createUser() {

        return new SimpleDateFormat("SSS").format(new Date()) + "Student";
    }

    public String createEmail() {

        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public String createInvalidEmail() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "!";
    }


    public String createPassword() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }


    public String createPasswordFor() {
        return new SimpleDateFormat("mmssSSS").format(new Date()) + "_student";
    }

}