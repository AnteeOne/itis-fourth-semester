package tech.anteeone.springcontrollers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import tech.anteeone.springcontrollers.beans.FormValidationService;
import tech.anteeone.springcontrollers.beans.UserService;
import tech.anteeone.springcontrollers.beans.UserValidator;
import tech.anteeone.springcontrollers.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private FormValidationService validationService;

    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    private String requestProfile(){
        return "user";
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    private String requestAuth(ModelMap map){
        map.put("user",new UserDto());
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    private String authFormPostRequest(@Validated @ModelAttribute("user")UserDto userDto,
                                       BindingResult bindingResult,
                                       HttpServletRequest request,
                                       ModelMap map){
        System.out.println(userDto.toString());
// old custom validation <------------------------------------------------------->
//        if(validationService.formIsValid(userDto)){
//            if(userService.findUserByEmail(userDto.getEmail()) == null){
//                userService.saveUser(userDto);
//                request.getSession().setAttribute("user",userDto);
//                request.getSession().setAttribute("error",null);
//                return "user";
//            }
//            request.getSession().setAttribute("error","error_uax"); // User Already Exists
//        }
//        request.getSession().setAttribute("error","error_iid"); // Incorrect Input Data
//        return "redirect:auth";
// JSR303 validation <------------------------------------------------------->
//        if(bindingResult.hasErrors()){
//            bindingResult.getAllErrors().forEach(System.out::println);
//            return "redirect:auth";
//        }
//        request.getSession().setAttribute("user",userDto);
//        return "user";
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(System.out::println);
            return "redirect:auth";
        }
        if(userService.findUserByEmail(userDto.getEmail()) == null){
                userService.saveUser(userDto);
                request.getSession().setAttribute("user",userDto);
                request.getSession().setAttribute("error",null);
                return "user";
            }
        return "user";
    }


}
