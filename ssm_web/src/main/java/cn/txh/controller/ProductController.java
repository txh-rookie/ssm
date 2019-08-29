package cn.txh.controller;

import cn.txh.domain.Product;
import cn.txh.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController{
    @Autowired
    private IProductService productService;

    /**
     * 查询所有的方法
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name ="page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> productList = productService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("list");
        return mv;
    }

    /**
     *保存的方法
     * @param product
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll";
    }
    @RequestMapping("/delete")
    public String delete(String id) throws Exception{
         productService.delete(id);
         return "redirect:findAll";
    }
    @RequestMapping("/update")
    public ModelAndView update(Product product) throws Exception{
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:findAll");
        productService.update(product);
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception{
           ModelAndView mv=new ModelAndView();
          Product product=productService.findById(id);
          mv.addObject("product",product);
          mv.setViewName("product-update");
           return mv;
    }
}
