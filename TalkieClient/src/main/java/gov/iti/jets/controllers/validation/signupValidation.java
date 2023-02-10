package gov.iti.jets.controllers.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signupValidation {
    public signupValidation(){

    }

    public boolean userNameValidate(String name) {
        if (name == null) {
            return false;
        }
        return true;
    }


    public boolean phoneNumberValidate(String phoneNo) {
        if(phoneNo == null)
            return false;

        String regex = "^(01)(0|1|2|5)[0-9]{8}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNo);

        return matcher.matches();
    }


    public boolean passwordValidate(String password) {
        if(password == null)
            return false;

        String regex = "(.+){8}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((password));

        return matcher.matches();
    }


    public boolean confirmPasswordValidate(String password , String confirmPassword) {
        if(confirmPassword == null || password==null)
            return false;

        return password==confirmPassword ;
    }


    public boolean emailValidate(String email) {
        if(email == null)
            return false;

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    public boolean countryValidation(String country) {

        return country==null;
    }


    public boolean birthdateValidation(String birthdate) {
        if(birthdate == null)
            return false;

        String regex = "^(.+){2}(/)(.+){2}(/)(.+){4}$" ;

        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthdate);

        return matcher.matches();
    }

    public boolean genderValidate(String gender ) {

        return gender == null;
    }


}
