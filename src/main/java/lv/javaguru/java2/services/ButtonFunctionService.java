package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 11/24/2015.
 */
@Component
public class ButtonFunctionService {
    private final int BUTTON_FUNCTION_NAME_LENGTH = 6;
    public String getButtonName(final HttpServletRequest request) {
        String buttonName = "";
        Map<String, String[]> paramMap = request.getParameterMap();
        if (!paramMap.isEmpty()) {
            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                buttonName = entry.getKey();
            }
        }
        return buttonName;
    }
    public Long getId(String buttonName){
        String id = buttonName.substring(BUTTON_FUNCTION_NAME_LENGTH);
        return Long.valueOf(id);
    }
    public String getButtonFunction(String buttonName){
        return buttonName.substring(0,BUTTON_FUNCTION_NAME_LENGTH);
    }
}
