package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by AST on 2015.11.03..
 */
public interface MVCController {
    MVCModel execute(HttpServletRequest request) throws DBException, IOException, ParseException;
   // MVCModel executeDoGet(HttpServletRequest request, HttpServletResponse response) throws DBException;
   // MVCModel executeDoPost(HttpServletRequest request, HttpServletResponse response) throws DBException;

}
