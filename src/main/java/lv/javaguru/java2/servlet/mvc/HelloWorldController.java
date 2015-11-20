package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AST on 2015.11.03..
 */
@Component
public class HelloWorldController implements MVCController {
    public MVCModel execute(HttpServletRequest request) {

        return new MVCModel("Hello from MVC", "/helloWorld.jsp");
    }
}
