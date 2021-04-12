package com.cl.dao;

import com.cl.domain.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

    @Select("select * from goodsinfo")
    List<Goods> findAll();
    @Select("select * from goodsinfo where gName like '%${value}%' ")
    List<Goods> findLikeName(String gName);
}
