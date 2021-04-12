package com.cl.controller;

import com.cl.domain.Items;
import com.cl.domain.ShopCar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ShopCar")
public class ShopCarController {

    private ShopCar shopCar = null;

    @RequestMapping("/enterShopCar")
    public String enterShopCar() {
        System.out.println("进入shopcar");
        return "myShopCar";
    }

    @RequestMapping("/add")
    public String add(Items items, HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("添加："+items);
        String referer = request.getHeader("referer");
        System.out.println("referer链接："+referer);

        if(shopCar == null) {
            shopCar = new ShopCar();
        }
        boolean flag = true;
        int sum = 0;
        for (Items items1:shopCar.getGoodsList()) {

            if(items.getName().equals(items1.getName())) {
                items1.setCount(items1.getCount()+1);
                flag = false;
            }

        }

        if(flag) {
            shopCar.addItem(items);

        }
        for (Items items1:shopCar.getGoodsList()) {
            sum += items1.getCount()*items1.getPrice();
        }
        shopCar.setPrice(sum);
        request.getSession().setAttribute("shopCar",shopCar);
        return "redirect:"+referer;
    }

    @RequestMapping("/del")
    public String del(Items items , HttpServletRequest request) {
        System.out.println(items);
        shopCar.delItem(items);
        System.out.println("shopcar:"+shopCar);
        request.getSession().setAttribute("shopCar",shopCar);
        int sum = 0;
        for (Items items1:shopCar.getGoodsList()) {
            System.out.println("haha");
            sum += items1.getCount()*items1.getPrice();
        }
        shopCar.setPrice(sum);
        return "redirect:/ShopCar/enterShopCar";
    }
    @RequestMapping("/clear")
    public String clear( HttpServletRequest request) {
        shopCar.clearItem();
        shopCar.setPrice(0);
        request.getSession().setAttribute("shopCar",null);
        System.out.println();
        return "redirect:/ShopCar/enterShopCar";
    }

    @RequestMapping("/reduceCount")
    public String reduceCount(Items items ,  HttpServletRequest request) {
        Items itemsa = shopCar.getGoodsList().get(shopCar.find(items));
        itemsa.setCount(itemsa.getCount()-1);
        if(itemsa.getCount() <= 0) {
            shopCar.getGoodsList().remove(shopCar.find(items));
            if(shopCar.getGoodsList().size() == 0) {
                request.getSession().setAttribute("shopCar",null);
                return "redirect:/ShopCar/enterShopCar";
            }
        }
        request.getSession().setAttribute("shopCar",shopCar);
        int sum = 0;
        for (Items items1:shopCar.getGoodsList()) {
            sum += items1.getCount()*items1.getPrice();
        }
        shopCar.setPrice(sum);
        return "redirect:/ShopCar/enterShopCar";
    }

    @RequestMapping("/addCount")
    public String addCount(Items items ,  HttpServletRequest request) {
        Items itemsa = shopCar.getGoodsList().get(shopCar.find(items));
        itemsa.setCount(itemsa.getCount()+1);


        request.getSession().setAttribute("shopCar",shopCar);
        int sum = 0;
        for (Items items1:shopCar.getGoodsList()) {
            sum += items1.getCount()*items1.getPrice();
        }
        shopCar.setPrice(sum);
        return "redirect:/ShopCar/enterShopCar";
    }
    @RequestMapping("/enterGoods")
    public String enterGoods(Items items ,  HttpServletRequest request) {
        return "redirect:/goods/findAll";
    }

}
