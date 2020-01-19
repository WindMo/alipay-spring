package com.alipay.alipayspringdemo.alipayService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author WindShadow
 * @verion 2019/12/24.
 */

public interface AlipayService {

    /**
     *  支付宝服务接口
     */

    // 充值
    boolean pay(AlipayConfig alipayConfig, TradeInfo orderInfo, HttpServletRequest request, HttpServletResponse response);

    // 支付宝验签
    boolean rsaCheck(AlipayConfig alipayConfig, HttpServletRequest request) throws UnsupportedEncodingException;
}
