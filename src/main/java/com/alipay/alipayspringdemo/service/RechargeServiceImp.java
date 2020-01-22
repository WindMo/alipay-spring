package com.alipay.alipayspringdemo.service;

import com.alipay.alipayspringdemo.alipayService.AlipayConfig;
import com.alipay.alipayspringdemo.alipayService.AlipayService;
import com.alipay.alipayspringdemo.alipayService.TradeInfo;
import com.alipay.alipayspringdemo.util.TradeNoMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WindShadow
 * @verion 2020/1/11.
 */

@Service
public class RechargeServiceImp implements RechargeService {

    // 订单号生成器
    @Autowired
    TradeNoMaker maker;
    // 阿里支付服务
    @Autowired
    AlipayService alipayService;
    @Override
    public void rechargeByAccountId(String accountId, Double money, AlipayConfig alipayConfig, HttpServletRequest request, HttpServletResponse response) {

        // 配置订单信息
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setOutTradeNo(maker.ctreateTradeNo());// 由订单编号生成器生成订单号
        tradeInfo.setTotalAmount(String.valueOf(money));
        tradeInfo.setSubject("用户["+ accountId +"]进行充值");
        tradeInfo.setBody("校园卡充值");
        tradeInfo.setTimeoutExpress("1m");
        // 调用服务充值
        alipayService.pay(alipayConfig,tradeInfo,request,response);
    }
}
