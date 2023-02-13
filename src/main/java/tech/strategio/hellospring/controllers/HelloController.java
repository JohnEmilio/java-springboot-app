package tech.strategio.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/hello")
public class HelloController {

    // Responds to GET request at /hello route with query parameter ?coder={your name}
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello () {
//        return "Hello, User!";
//    }

    // Responds to GET request at /hello route with query parameter ?coder={your name}
    @RequestMapping(value = "/hello", method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithReqParam (@RequestParam String coder, @RequestParam String language, Model model) {
        String greeting = coder;
        if (language.equals("spanish")){
            greeting = "Hola, " + greeting;
        }
        else if(language.equals("english")){
            greeting = "Hello, " + greeting;
        }
        else if (language.equals("greek")){
            greeting = "Γειά σου, " + greeting;
        }
        else {
            greeting = "Hello, " + greeting;
        }
        model.addAttribute("greeting", greeting);

        return "hello";
    }

    // Responds to GET request at /hello/{name} route where {name} is a unique path (such as an individual user)
    @GetMapping("/hello/{name}")
    public String helloWithPathVar (@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Responds to GET request at route /hello/goodbye and responds with basic response body
    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye () {
        return "Goodbye, Spring!";
    }

    @GetMapping("/form")
    public String helloForm () {
        return "form";

    }

    @GetMapping("/hello-names")
    public String helloNames (Model model) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Nadia");
        names.add("Patty");
        names.add("Alex");
        model.addAttribute("names", names);
        return "hello-list";

    }

}
