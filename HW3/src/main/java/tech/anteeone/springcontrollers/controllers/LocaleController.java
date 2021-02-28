package tech.anteeone.springcontrollers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LocaleController {

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    private MessageSourceAccessor msa;

    @RequestMapping("/change")
    public String change(@RequestParam String locale){
        String[] localeData = locale.split("_");
        localeResolver.setLocale(request,response,new Locale(localeData[0],localeData[1]));
        return "redirect:auth";
    }




}
