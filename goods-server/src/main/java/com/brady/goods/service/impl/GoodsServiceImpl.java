package com.brady.goods.service.impl;

import com.brady.goods.vo.HotWorld;
import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.entity.Goods;
import com.brady.goods.entity.GoodsExample;
import com.brady.goods.mapper.GoodsMapper;
import com.brady.goods.service.GoodsService;
import com.brady.goods.utils.DateUtil;
import com.brady.goods.utils.DozerUtils;
import com.brady.goods.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: brady.si
 * @create: 2020-12-07 22:54
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    @Override
    public int addGoods(GoodsDTO.AddGoodsDTO reqDto) {
        Goods goods = new Goods();
        goods.setGoodsName(reqDto.getGoodsName());
        goods.setPrice(reqDto.getPrice());
        goods.setGoodsDesc(reqDto.getGoodsDesc());
        goods.setInventory(reqDto.getInventory());
        goods.setCreateTime(DateUtil.getCurrentSeconds());
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public List<GoodsVO> queryGoods() {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andStatusEqualTo((byte)0);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        List<GoodsVO> vos = DozerUtils.getGoodsVOS(goodsList);
        return vos;
    }

    @Override
    public List<GoodsVO> queryGoodsByExample(GoodsDTO.QueryGoodsDTO dto) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria().andGoodsNameLike("%" + dto.getGoodsName() + "%");
        if (dto.getLowPrice() != null){
            criteria.andPriceGreaterThanOrEqualTo(dto.getLowPrice());
        }
        if (dto.getHighPrice() != null){
            criteria.andPriceLessThanOrEqualTo(dto.getHighPrice());
        }
        if (dto.getGoodsDesc() != null){
            criteria.andGoodsDescLike("%" + dto.getGoodsDesc() + "%");
        }

        List<Goods> goods = goodsMapper.selectByExample(example);
        if (goods == null){
            return null;
        }
        return DozerUtils.getGoodsVOS(goods);
    }

    @Override
    public List<GoodsVO> queryGoodsByName(GoodsDTO.QueryGoodsByNameDTO dto) {
        addHotWord(dto.getGoodsName());
        GoodsExample example = new GoodsExample();
        example.createCriteria().andGoodsNameLike("%" + dto.getGoodsName() + "%");
        List<Goods> goods = goodsMapper.selectByExample(example);
        if (goods != null){
            return DozerUtils.getGoodsVOS(goods);
        }
        return null;
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

    @Override
    public List<HotWorld> getHotWordService() {
        return getHotWord();
    }

    /**
     * 设置缓存失效时间，统一为凌晨零点
     * @param hotWord
     *
     */
    public void addHotWord(String hotWord) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        //晚上十二点与当前时间的毫秒差
        Long timeOut = (calendar.getTimeInMillis()-System.currentTimeMillis()) / 1000;
        // 加入排序set
        redisTemplate.opsForZSet().incrementScore("hotWord", hotWord, 1);
        redisTemplate.expire("hotWord",timeOut, TimeUnit.SECONDS);
    }

    public List<HotWorld> getHotWord(){
        ArrayList<HotWorld> worlds = new ArrayList<>();
//        Set<String> hotWord = redisTemplate.opsForZSet().reverseRangeByScore("hotWord", 0, 100);
        Set<ZSetOperations.TypedTuple<String>> hotWord = redisTemplate.opsForZSet().rangeByScoreWithScores("hotWord", 0, 100);
        Iterator<ZSetOperations.TypedTuple<String>> iterator = hotWord.iterator();
        while (iterator.hasNext()){
            HotWorld world = new HotWorld();
            ZSetOperations.TypedTuple<String> next = iterator.next();
            String value = next.getValue();
            world.setValue(value);
            Double score = next.getScore();
            world.setScore((int) Math.ceil(score));
            worlds.add(world);
        }
        return worlds;
    }
}
