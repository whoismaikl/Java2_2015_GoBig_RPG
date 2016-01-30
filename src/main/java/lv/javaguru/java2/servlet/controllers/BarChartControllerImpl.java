package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.BarChartService;
import org.omg.CORBA.portable.OutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by AST on 2015.11.03..
 */
@Controller
public class BarChartControllerImpl {
    @Autowired
    private BarChartService barChartService;

    @RequestMapping(value = "/getBarChart", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        File file= barChartService.createBarChart(user);
        //BufferedImage image= javax.ImageIO.
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        //OutputStream out = response.getOutputStream();
        ImageIO.write((RenderedImage) file, "jpg", out);
        out.close();




        return new ModelAndView("/activeTasks.jsp", "model", "Active Tasks");

    }
}
