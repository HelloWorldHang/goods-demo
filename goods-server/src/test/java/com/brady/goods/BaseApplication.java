package com.brady.goods;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: felix.fan
 * @date: 2019/4/28 14:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.brady.goods.Application.class)
@MapperScan("com.brady.goods.mapper")
public class BaseApplication {
}