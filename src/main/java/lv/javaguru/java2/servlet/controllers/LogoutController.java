package lv.javaguru.java2.servlet.controllers;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by mike on 11/25/2015.
 */


@Controller
//@RequestMapping("/index.jsp")
public class LogoutController {
    //@RequestMapping(method=RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
