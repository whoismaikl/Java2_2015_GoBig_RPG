package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class BarChartControllerImpl {
    @Autowired
    private ChartService barChartService;

    @ResponseBody
    @RequestMapping(value = "/getBarChart", method = {RequestMethod.GET}, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
      byte[] byteArray = barChartService.createBarChart(user);
        return byteArray;
    }
}
