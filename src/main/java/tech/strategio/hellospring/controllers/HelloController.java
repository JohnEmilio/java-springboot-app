package tech.strategio.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    // Responds to GET request at /hello route with query parameter ?coder={your name}
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello () {
//        return "Hello, User!";
//    }

    // Responds to GET request at /hello route with query parameter ?coder={your name}
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithReqParam (@RequestParam String coder, @RequestParam String language) {
        if (language.equals("spanish")){
            System.out.println("in spanish");
            return "Hola" + coder + "!";
        }
        else if(language.equals("english")){
            System.out.println("in english");
            return "Hello, " + coder + "!";
        }
        else if (language.equals("greek")){
            System.out.println("in greek");
            return "Γειά σου, " + coder + "!";
        }
        else {
            System.out.println("in else");
            return "Hello, " + coder + "!";
        }
    }

    // Responds to GET request at /hello/{name} route where {name} is a unique path (such as an individual user)
    @GetMapping("/{name}") public String helloWithPathVar (@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Responds to GET request at route /hello/goodbye and responds with basic response body
    @GetMapping("/goodbye")
    public String goodbye () {
        return "Goodbye, Spring!";
    }

    @GetMapping("/form")
    public String helloForm () {
        String html =
                "<html>" +
                        "<body style='text-align:center'>" +
                            "<h1>Hello please enter your name</h1>" +
                            "<form method='post' action='/hello'>" +
                                "<h3>Please Enter your Name</h3>" + "<input type='text' name='coder' />" + "<br>" +
                                "<h3>Please Choose your Language</h3>" + "<select name='language'>" +
                                    "<option value='Choose a Language'>Choose a Language</option>" +
                                    "<option value='english'>English</option>" +
                                    "<option value='spanish'>Spanish</option>" +
                                    "<option value='greek'>Greek</option>" +
                                    "</select>" +
                                "<input type='submit' value='Greet Me!' />" +
                            "</form>" +
                        "</body>"+
                "</html>";
        return html;

    }

}
