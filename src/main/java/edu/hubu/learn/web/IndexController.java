package edu.hubu.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.User;
import edu.hubu.learn.entity.Info;
import edu.hubu.learn.service.InfoService;
import edu.hubu.learn.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;

    @RequestMapping("/info")
    public ModelAndView info() {
        ModelAndView mav = new ModelAndView();
        Info info = infoService.getUser(1l);
        mav.addObject("info", info);
        mav.setViewName("user");
        return mav;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUser(1l);
        mav.addObject("user", user);
        mav.setViewName("user");
        return mav;
    }
    
}