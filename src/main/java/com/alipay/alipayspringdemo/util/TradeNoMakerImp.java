package com.alipay.alipayspringdemo.util;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author WindShadow
 * @verion 2019/12/28.
 */

@Service
public class TradeNoMakerImp implements TradeNoMaker {

    @Override
    public String ctreateTradeNo() {

        LocalDateTime dateTime = LocalDateTime.now();
        String str = ""+dateTime.getYear()+dateTime.getMonthValue()+dateTime.getDayOfMonth()+dateTime.getHour()+dateTime.getMinute()+dateTime.getSecond();
        return str;
    }

    @Override
    public String ctreateTradeNo(Object... seed) {

        return null;
    }

    public static void main(String[] args) {


    }
}
