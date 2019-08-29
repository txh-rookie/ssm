package cn.txh.controller;

import cn.txh.dao.IUserDao;
import cn.txh.domain.UserInfo;
import cn.txh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private IUserService userService;

    /**
     * 用户管理的方法
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userInfo =  userService.findAll();
        mv.addObject("userList",userInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 用户保存
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
         userService.save(userInfo);
          return "redirect:findAll";
    }
    /**
     * 根据id查询信息
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo =userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
}
