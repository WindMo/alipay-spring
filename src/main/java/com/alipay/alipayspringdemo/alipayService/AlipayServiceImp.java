package com.alipay.alipayspringdemo.alipayService;

import com.alipay.api.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author WindShadow
 * @verion 2019/12/27.
 */

@Service
public class AlipayServiceImp implements AlipayService {

    @Override
    public boolean pay(AlipayConfig alipayConfig, TradeInfo tradeInfo, HttpServletRequest request, HttpServletResponse response) {

        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.gatewayUrl, alipayConfig.appId, alipayConfig.merchantPrivateKey, "json", alipayConfig.charset, alipayConfig.alipayPublicKey, alipayConfig.signType);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(alipayConfig.returnUrl);
        alipayRequest.setNotifyUrl(alipayConfig.notifyUrl);
        alipayRequest.setBizContent(tradeInfo.creatBizContent());

        // 请求并加载二维码
        try {

            String result = alipayClient.pageExecute(alipayRequest).getBody();
            PrintWriter out = response.getWriter();
            out.write(result);
            out.flush();
            out.close();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            ///alipayConfig.logResult(e.getErrMsg());
            System.out.println("跳转支付失败!");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            ///alipayConfig.logResult(e.getErrMsg());
            System.out.println("输出页面失败！");
            return false;
        }
        return true;
    }

    // 支付宝验签
    @Override
    public boolean rsaCheck(AlipayConfig alipayConfig, HttpServletRequest request) throws UnsupportedEncodingException {

        //获取支付宝提交过来反馈信息，同步通知为GET异步为POST
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.alipayPublicKey, alipayConfig.charset, alipayConfig.signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return signVerified;
    }
}
