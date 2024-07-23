package com.intellif.trigger.http;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gumo
 * @since 2024-07-22
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("getTest")
    public String getTest(){
        log.info("测试完成");
        return "Hello word";
    }
}
