package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

/**
 * Created by AST on 2015.11.03..
 */
//@Component
public class MVCModel {
    private Object data;
    private  String viewName;

    public MVCModel(Object data, String viewName) {
        this.data = data;
        this.viewName = viewName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getViewName() {

        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
