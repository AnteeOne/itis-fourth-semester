package tech.anteeone.springcontrollers.beans;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tech.anteeone.springcontrollers.dto.UserDto;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o , Errors errors) {
        UserDto userDto = (UserDto) o;
        FormValidationService formValidationService = new FormValidationService();
        if(!formValidationService.formEmailIsValid(userDto)){
            errors.reject("email","email.incorrect");
        }
        if(!formValidationService.formPasswordsIsValid(userDto)){
            errors.reject("passwords","passwords.incorrect");
        }

    }
}
