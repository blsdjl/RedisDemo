package com.by.redisdemo;

import com.by.redisdemo.redis.pojo.user;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisdemoApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("name","春秋分");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testSaveObj(){
        redisTemplate.opsForValue().set("hoise:1",new user("春秋分","天秋，有马"));
        val o = redisTemplate.opsForValue().get("hoise:1");
        System.out.println(o);
    }
}
