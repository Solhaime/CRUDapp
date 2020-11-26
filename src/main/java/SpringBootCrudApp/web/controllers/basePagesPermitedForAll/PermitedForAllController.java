package SpringBootCrudApp.web.controllers.basePagesPermitedForAll;

import SpringBootCrudApp.model.User;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import SpringBootCrudApp.service.userService.UserService;

@Controller
public class PermitedForAllController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String indexPage(){
        return "/index";
    }

/*
    @PostMapping("login")
    public String loginPage() {
        return "/user";
    }

    @GetMapping("login")
    public String loginPag1e() {
        return "/login";
    }
*/

    @GetMapping("/register")
    public String registerPage( Model model){
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") User user){
        user.addRole("USER");
        userService.add(user);
        return "/login";
    }

    @ExceptionHandler(HibernateException.class)
    public String constraintExceptionHandler(){
        return "constraintusername";
    }
}
