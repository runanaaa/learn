package edu.hubu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.User;
import edu.hubu.learn.entity.Info;
import edu.hubu.learn.service.InfoService;
import edu.hubu.learn.service.UserService;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;


    @RequestMapping("/{id}")
    public ModelAndView info(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
       Info info = infoService.getUser(id);
        mav.addObject("info", info);
        mav.setViewName("user");
        return mav;
    }
    
    @RequestMapping("/list")
     public ModelAndView infos(){
    ModelAndView mav =new ModelAndView();
    List<Info> infos =infoService.getInfos();
    mav.addObject("infos",infos);
    mav.setViewName("infos");
    return mav;

  }
  @RequestMapping("/add")



  public ModelAndView addInfo() {



      ModelAndView mav = new ModelAndView();



      mav.setViewName("info_add");



      return mav;



  }







  @RequestMapping("/do_add")



  public ModelAndView doAddInfo(Info info) {



      infoService.addInfo(info);



      ModelAndView mav = new ModelAndView("redirect:/info/list");



      return mav;



  }
}