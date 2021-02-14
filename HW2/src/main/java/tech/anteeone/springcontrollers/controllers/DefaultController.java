package tech.anteeone.springcontrollers.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/tests")
public class DefaultController {

    @RequestMapping
    public String index(ModelMap map) {
        map.put("viewVariable", "Index action");
        return "tests";
    }

    @RequestMapping("/s")
    public String simple(ModelMap map) {
        map.put("viewVariable", "Just simple action");
        return "tests";
    }

    @RequestMapping( { "/s1" , "/s2" } )
    public String simpleMultiple(ModelMap map) {
        map.put("viewVariable", "Just simple action for 2 addresses");
        return "tests";
    }

    @RequestMapping("/rb")
    @ResponseBody
    public String responseBody(){
        return "The only text on a page is this text - @ResponseBody annotation.";
    }

    @RequestMapping("/writer")
    public void writer(java.io.Writer writer) throws IOException{
        writer.write("This is plain/text done with java.io.Writer");
    }

    @RequestMapping("/rs")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String responseStatus(ModelMap map){
        map.put("viewVariable", "What do you want from me? I'm a teapot!");
        return "tests";
    }

    @RequestMapping(
            value = "/rmb",
            method = RequestMethod.GET,
            headers = "!user-agent=Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0",
            params = "secret_param=1"
    )
    public String requestMappingBunch(ModelMap map) {
        map.put("viewVariable", "Page with secret_param for not Mozilla 36 on Linux");
        return "tests";
    }

    @RequestMapping("/rp")
    public String requestParam(@RequestParam String param, ModelMap map) {
        map.put("viewVariable", "Request parameter:<br>" + param );
        return "tests";
    }

    @RequestMapping("/rpb")
    public String requestParamBanch(
            @RequestParam(
                    value        = "special_name",
                    required     = false,
                    defaultValue = "Default value"
            ) String param,
            ModelMap map
    ) {
        map.put("viewVariable", "Request parameter:<br>" + param );
        return "tests";
    }

    @RequestMapping("/pv/{param}")
    public String pathVariable(@PathVariable String param, ModelMap map){
        map.put("viewVariable", "Path variable:<br>" + param );
        return "tests";
    }

    @RequestMapping("/pvb/{param_special_name}/{param2}/path")
    public String pathVariableBunch(
            @PathVariable(
                    value = "param_special_name"
            ) String param,
            @PathVariable String param2,
            ModelMap map
    ){
        map.put("viewVariable", "Path variable:<br>" + param );
        return "tests";
    }

    @RequestMapping(
            value = "/request-param",
            method = RequestMethod.GET,
            headers = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.41 YaBrowser/21.2.0.1097 Yowser/2.5 Safari/537.36"
    )
    public String requestMappingBunchWithParam(@RequestParam(
            value        = "special_param",
            required     = true
    ) String param, ModelMap map) {
        map.put("viewVariable", "ooo it's soooo special, special param: " + param);
        return "tests";
    }


    @RequestMapping("/rh")
    public String requestHeader(@RequestHeader() Map<String, String> headers, ModelMap map) {

        ArrayList<Header> headersResult = new ArrayList<>();

        headers.forEach((key, value) -> {
            headersResult.add(new Header(key, value));
        });
        map.put("allHeaders", headersResult);

        return "tests";
    }
}
