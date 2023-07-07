package com.by.redisdemo;

import com.alibaba.fastjson2.JSON;
import com.by.redisdemo.redis.pojo.user;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class StringRedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("name","春秋分");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
        System.out.println("this is the test");
        System.out.println("this is the master");
        System.out.println("this is hot-fix");
    }

    @Test
    void testSaveObj(){
        user user = new user("春秋分", "迪拜司马，宝冢");
        String jsonString = JSON.toJSONString(user);
        stringRedisTemplate.opsForValue().set("horse:1",jsonString);
        val user1 = JSON.parseObject(jsonString, user.class);
        System.out.println(user1);
    }
}
