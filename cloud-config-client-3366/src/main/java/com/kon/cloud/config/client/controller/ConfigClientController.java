package com.kon.cloud.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@Slf4j
// 用于动态刷新配置，配合暴露端点使用（curl -X POST "http://localhost:3355/actuator/refresh"）
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getConfigInfo")
    public Map getConfigInfo() {
        return new HashMap<String, String>() {{
            this.put("serverPort", serverPort);
            this.put("configInfo", configInfo);
        }};
    }

}
