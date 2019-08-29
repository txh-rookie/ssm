package cn.txh.controller;

import cn.txh.domain.Orders;
import cn.txh.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController{
   @Autowired
    private IOrdersService ordersService;

  /* @RequestMapping("/findAll")为分页之前的查询所有的方法
   public ModelAndView findAll() throws Exception {
       ModelAndView mv=new ModelAndView();
       List<Orders> orderslist = ordersService.findAll();
       mv.addObject("ordersList",orderslist);
       mv.setViewName("orders-list");
       return mv;
   }*/
     @RequestMapping("/findAll")
     public ModelAndView findAll(@RequestParam(name ="page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
         ModelAndView mv=new ModelAndView();
         List<Orders> orderslist = ordersService.findAll(page,size);
         PageInfo pageInfo=new PageInfo(orderslist);
         mv.addObject("pageInfo",pageInfo);
         mv.setViewName("orders-page");
         return mv;
     }
     @RequestMapping("/findById")
     public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception {
         ModelAndView mv=new ModelAndView();
         Orders  orders=ordersService.findById(ordersId);
         mv.addObject("orders",orders);
         mv.setViewName("orders-show");
         return mv;
     }
}
