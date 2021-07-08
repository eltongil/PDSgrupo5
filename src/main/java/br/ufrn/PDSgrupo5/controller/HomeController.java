package br.ufrn.PDSgrupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("active_tab",null);
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
