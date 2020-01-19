package com.alipay.alipayspringdemo.alipayService;

import java.io.UnsupportedEncodingException;

/**
 * @author WindShadow
 * @verion 2019/12/28.
 */

public class TradeInfo {

    //商户订单号，商户网站订单系统中唯一订单号，必填
    private String outTradeNo = null;
    //付款金额，必填
    private String totalAmount = null;
    //订单名称，必填
    private String subject = null;
    //商品描述，可空
    private String body = null;
    //超时时间，可空
    private String timeoutExpress;

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = deal(outTradeNo);
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = deal(totalAmount);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = deal(subject);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body =deal( body);
    }

    // 乱码处理
    private String deal(String str){

        try {
            return new String(str.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    // 返回交易上下文
    public String creatBizContent(){

        /**
         * 按官方的demo使用下划线的参数名（推测负责支付服务的后台不是用JAVA写的）,
         * 不知都修改了会不会影响二维码页面渲染或者后台接收数据啥的，暂时不修改
         */

        //请求参数可查阅【电脑网站支付的API文档-payByUserId.trade.page.pay-请求参数】章节
        String str = "{\"out_trade_no\":\""+ outTradeNo +"\","
                + "\"total_amount\":\""+ totalAmount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+timeoutExpress+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}";
        return str;
    }
}
