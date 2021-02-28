package tech.anteeone.springcontrollers.beans;

import tech.anteeone.springcontrollers.dto.UserDto;

import java.util.regex.Pattern;

public class FormValidationService {

    public  boolean formIsValid(UserDto form) {

        return formEmailIsValid(form) &&
                formPasswordsIsValid(form);
    }

    public boolean formEmailIsValid(UserDto dto){
        return Pattern.compile(".+@.+").matcher(dto.getEmail()).matches();
    }

    public boolean formPasswordsIsValid(UserDto dao){
        return dao.getPassword().length() > 8 &&
                dao.getPassword().equals(dao.getPassword2());
    }
}
