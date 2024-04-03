package uz.kamron.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/")
    public String indexPage(){
        return "first/index";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false)String name,
                            @RequestParam(value = "surname",required = false)String surname,
                            Model model){
        model.addAttribute("message","Hello, "+name+" "+surname);

        System.out.println("Hello, "+name+" "+surname);

        return "first/hello";
    }

    @GetMapping("/goodbyte")
    public String goodByePage(){
        return "first/goodbye";

    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b")int b,
                             @RequestParam("action")String action,
                             Model model){
        double result;

        switch (action){
            case "multiplication":
                result=a*b;
                break;
            case "devision":
                result=a/(double)b;
                break;
            case "subtraction":
                result=a-b;
                break;
            case "addition":
                result=a+b;
                break;
            default:
                result=0;
                break;
        }


        model.addAttribute("result",result);
        return "first/calculator";
    }
}
