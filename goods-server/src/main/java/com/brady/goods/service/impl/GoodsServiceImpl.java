package com.brady.goods.service.impl;

import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.entity.Goods;
import com.brady.goods.entity.GoodsExample;
import com.brady.goods.mapper.GoodsMapper;
import com.brady.goods.service.GoodsService;
import com.brady.goods.utils.DateUtil;
import com.brady.goods.vo.GoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: brady.si
 * @create: 2020-12-07 22:54
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public int addGoods(GoodsDTO.AddGoodsDTO reqDto) {
        Goods goods = new Goods();
        goods.setGoodsName(reqDto.getGoodsName());
        goods.setPrice(reqDto.getPrice());
        goods.setGoodsDesc(reqDto.getGoodsDesc());
        goods.setInventory(reqDto.getInventory());
        goods.setCreateTime(DateUtil.getCurrentSeconds());
        return goodsMapper.insert(goods);
    }

    @Override
    public List<GoodsVO> queryGoods() {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andStatusEqualTo((byte)0);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        List<GoodsVO> vos = new ArrayList<>();
        for (Goods goods : goodsList) {
            GoodsVO goodsVO = new GoodsVO();
            goodsVO.setGoodsName(goods.getGoodsName());
            goodsVO.setPrice(goods.getPrice());
            goodsVO.setGoodsDesc(goods.getGoodsDesc());
            goodsVO.setSales(goods.getSales());
            goodsVO.setInventory(goods.getInventory());
            vos.add(goodsVO);
        }
        return vos;
    }

    @Override
    public Integer updateGoods(GoodsDTO.UpdateGoodsDTO dto) {
        Goods goods = new Goods();
        goods.setId(dto.getId());
        goods.setGoodsName(dto.getGoodsName());
        goods.setPrice(dto.getPrice());
        goods.setGoodsDesc(dto.getGoodsDesc());
        goods.setInventory(dto.getInventory());
        int res = goodsMapper.updateByPrimaryKeySelective(goods);
        return res;
    }

    @Override
    public Integer deleteGoods(Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setStatus((byte)1);
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }
}
