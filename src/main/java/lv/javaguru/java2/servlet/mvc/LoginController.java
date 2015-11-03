package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
public class LoginController implements MVCController {
    public MVCModel execute(HttpServletRequest request){
        return  new MVCModel("Login", "/index.jsp");
    }
}
