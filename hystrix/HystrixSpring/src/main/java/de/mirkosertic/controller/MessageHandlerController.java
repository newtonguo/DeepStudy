package de.mirkosertic.controller;

import de.mirkosertic.GetIdBean;
import de.mirkosertic.domain.Message;
import de.mirkosertic.service.MessageHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 * Created by wangqinghui on 2016/1/21.
 */

@Controller
public class MessageHandlerController {


    @Autowired
    private MessageHandlerService messageHandlerService;

    @RequestMapping("/message")
    public ModelAndView simpleHello() {
        Message m = new Message();
        m.setDelayBy(200000);
        String message = "Welcome to our App, here is a random value : " + messageHandlerService.handleMessage(m).getReceived();
        return new ModelAndView("hello", "message", message);
    }
}
