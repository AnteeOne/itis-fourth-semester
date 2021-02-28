package tech.anteeone.springcontrollers.controllers;

import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import tech.anteeone.springcontrollers.beans.LanguageResolverService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Locale;

@Controller
public class IpController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    public LanguageResolverService languageResolver;

    @Autowired
    private LocaleResolver localeResolver;

    private final String IP_RU = "85.26.146.169";
    private final String IP_US = "143.110.220.166";


    @RequestMapping(value = "/iptest",method = RequestMethod.GET)
    private String ipTestRequest() throws UnknownHostException {
        IP2Location location = new IP2Location();
        try {
            location.Open("D:\\Projects\\Programming\\KFU\\itis_fourth_semester\\HW3\\src\\main\\resources\\ipproxy\\IP2LOCATION-LITE-DB1.BIN");
            IPResult result = location.IPQuery(IP_RU);
            if(result.getStatus().equals("OK")){
                localeResolver.setLocale(request,response,new Locale(languageResolver.resolveLanguage(result.getCountryShort())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "testip";
    }

}
