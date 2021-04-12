package com.cl.service;

import com.cl.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAll();

    List<Goods> searchLikeName(String gName);
}
