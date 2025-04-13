package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SmsServiceImpl implements SmsService{

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value("${sms.ru.login}")
    private String login;

    @Value("${sms.ru.password}")
    private String password;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendSms(String phone, String text) {
        //https://smsc.ru/sys/send.php?login=<login>&psw=<password>&phones=<phones>&mes=<message>
        String url = smsUrl + "?login=" + login + "&psw=" + password + "&phones=" + phone + "&mes=" + text;
        log.info(url);
        String result = restTemplate.getForObject(url, String.class);
        log.info(result);
    }
}
