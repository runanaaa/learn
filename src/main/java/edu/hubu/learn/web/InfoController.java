package edu.hubu.learn.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.Info;
import edu.hubu.learn.service.InfoService;
import lombok.extern.slf4j.Slf4j;
 


@Controller
@Slf4j
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;


    @RequestMapping("/{id}")
    public ModelAndView info(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
       Info info = infoService.getInfo(id);
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
      info.setAvatar("");
      infoService.addInfo(info);
      ModelAndView mav = new ModelAndView("redirect:/info/list");
      return mav;
  }
  @RequestMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable Long id) {
      infoService.deleteInfo(id);
      ModelAndView mav = new ModelAndView("redirect:/info/list");
      return mav;
  }
  @RequestMapping("/modify/{id}")
    public ModelAndView modifyInfo(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", infoService.getInfo(id));
        mav.setViewName("info_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyInfo(Info info) {
        info.setAvatar("");
        infoService.modifyInfo(info);
        ModelAndView mav = new ModelAndView("redirect:/info/list");
        return mav;
    }
     @RequestMapping("/search")
    public ModelAndView searchInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("info_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchInfo(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<Info> infos = infoService.searchInfos(keyword);
        mav.addObject("infos", infos);
        mav.setViewName("infos");
        return mav;
    }
      @RequestMapping("/add_avatar/{id}")
    public ModelAndView addInfoAvatar(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", infoService.getInfo(id));
        mav.setViewName("info_add_avatar");
        
        return mav;
    }

    @RequestMapping("/do_add_avatar/{id}")
    public ModelAndView doAddInfoAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable Long id) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = ResourceUtils.getURL("classpath:").getPath() + "../../../resources/main/static/";
            File dest = new File(filePath + fileName);
            log.info(dest.getAbsolutePath());
            file.transferTo(dest);
           Info info= infoService.getInfo(id);
            info.setAvatar(fileName);
            infoService.modifyInfo(info);
        } catch (Exception e) {
            log.error("upload avatar error", e.getMessage());
        }
        return new ModelAndView("redirect:/info/list");
    }
} 
