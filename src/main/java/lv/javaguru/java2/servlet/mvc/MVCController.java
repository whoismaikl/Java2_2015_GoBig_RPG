package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by AST on 2015.11.03..
 */
public interface MVCController {
    MVCModel execute(HttpServletRequest request) throws DBException;
   // MVCModel doGet(HttpServletRequest request, HttpServletResponse response) throws DBException;
   // MVCModel doPost(HttpServletRequest request, HttpServletResponse response) throws DBException;

}