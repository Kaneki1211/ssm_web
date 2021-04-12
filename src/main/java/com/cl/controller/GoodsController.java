package com.cl.controller;

import com.cl.domain.Goods;
import com.cl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        List<Goods> goods = goodsService.findAll();
        request.getSession().setAttribute("goods",goods);
        return "main";
    }
    @RequestMapping("/searchGoods")
    public String searchGoods(String searchText , HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        String referer = request.getHeader("referer");
        //System.out.println(referer);

        request.getSession().setAttribute("searchText",searchText);
        List<Goods> likeGoods = goodsService.searchLikeName(searchText);
        //System.out.println(likeGoods);
        if(likeGoods != null) {
            request.setAttribute("errorMsg",null);
            request.setAttribute("likeGoods",likeGoods);
            return "searchGoods";
        }else {
            request.setAttribute("likeGoods",null);
            request.setAttribute("errorMsg","查询不到您要的结果!");
            return "searchGoods";
        }
    }
    @RequestMapping("/enterLogin")
    public String enterLogin(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        return "redirect:/user/enterLogin";
    }
    @RequestMapping("/enterRegister")
    public String enterRegister(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        return "redirect:/user/enterRegister";
    }
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        return "redirect:/user/quit";
    }
    @RequestMapping("/enterShopCar")
    public String enterShopCar(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        return "redirect:/ShopCar/enterShopCar";
    }
    @RequestMapping("/enterShopCarAdd")
    public String enterShopCarAdd(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        return "forward:/ShopCar/add";
    }
}
