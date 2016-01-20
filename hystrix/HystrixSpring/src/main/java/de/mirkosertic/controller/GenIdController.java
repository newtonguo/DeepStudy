package de.mirkosertic.controller;

import de.mirkosertic.GetIdBean;
import de.mirkosertic.RandomBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenIdController {

    @Autowired
    private GetIdBean getIdBean;

    @RequestMapping("/getid")
    public ModelAndView simpleHello() {
        String message = "Welcome to our App, here is a random value : " + getIdBean.getId();
        return new ModelAndView("hello", "message", message);
    }
}
