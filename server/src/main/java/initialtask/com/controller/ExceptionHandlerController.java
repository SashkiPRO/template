package initialtask.com.controller;

import initialtask.com.exception.DBException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(DBException.class)
    public @ResponseBody String databaseError(Model model, DBException ex) {
        model.addAttribute("error", ex.getMessage());
        return "error!!";
    }

}
