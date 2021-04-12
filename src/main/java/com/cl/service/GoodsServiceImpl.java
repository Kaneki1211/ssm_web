package com.cl.service;

import com.cl.dao.GoodsDao;
import com.cl.dao.UserDao;
import com.cl.domain.Goods;
import com.cl.domain.User;
import com.cl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> findAll() {
        List<Goods> goods = goodsDao.findAll();
        return goods;
    }

    @Override
    public List<Goods> searchLikeName(String gName) {
        List<Goods> likeGoods = goodsDao.findLikeName(gName);
        return likeGoods;
    }


}