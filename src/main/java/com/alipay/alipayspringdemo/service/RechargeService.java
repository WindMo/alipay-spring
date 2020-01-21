package com.alipay.alipayspringdemo.service;

import com.alipay.alipayspringdemo.alipayService.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WindShadow
 * @verion 2020/1/11.
 */

public interface RechargeService {

    void rechargeByUserId(String accountId, Double money, AlipayConfig alipayConfig, HttpServletRequest request, HttpServletResponse response);
}
