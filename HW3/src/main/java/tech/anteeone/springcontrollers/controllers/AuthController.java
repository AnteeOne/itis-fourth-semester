package tech.anteeone.springcontrollers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.anteeone.springcontrollers.beans.FormValidationService;
import tech.anteeone.springcontrollers.beans.UserService;
import tech.anteeone.springcontrollers.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private FormValidationService validationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    private String requestProfile(){
        return "a";
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    private String requestAuth(){
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    private String authFormPostRequest(HttpServletRequest request,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "password2") String password2){
        UserDto userDto = new UserDto(email, password, password2);
        System.out.println(userDto.toString());
        if(validationService.formIsValid(userDto)){
            if(userService.findUserByEmail(userDto.getEmail()) == null){
                userService.saveUser(userDto);
                request.getSession().setAttribute("user",userDto);
                request.getSession().setAttribute("error",null);
                return "a";
            }
            request.getSession().setAttribute("error","error_uax"); // User Already Exists
        }
        request.getSession().setAttribute("error","error_iid"); // Incorrect Input Data
        return "redirect:/auth";
    }


}
