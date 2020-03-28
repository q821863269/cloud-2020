package com.kon.cloud.stream.rabbitmq.provider.controller;

import com.kon.cloud.stream.rabbitmq.provider.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lin Kun
 * @create 2020/3/28
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public Object sendMessage() {
        return messageProvider.send();
    }

}
