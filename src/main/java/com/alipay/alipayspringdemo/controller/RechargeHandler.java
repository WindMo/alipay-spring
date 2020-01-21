package com.alipay.alipayspringdemo.controller;

import com.alipay.alipayspringdemo.alipayService.AlipayConfig;
import com.alipay.alipayspringdemo.alipayService.AlipayService;
import com.alipay.alipayspringdemo.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;

/**
 * @author WindShadow
 * @verion 2020/1/6.
 */

@Controller
@RequestMapping("/recharge")
public class RechargeHandler {

    private static String RETURN_URL = "http://localhost:8080/recharge/return";
    private static String NOTIFY_URL = "http://localhost:8080/recharge/notify";

    private static AlipayConfig alipayConfig = new AlipayConfig();
    // 支付配置通知路径
    static {

        alipayConfig.setReturnUrl(RETURN_URL);
        alipayConfig.setNotifyUrl(NOTIFY_URL);
    }

    @Autowired
    RechargeService rechargeService;
    @Autowired
    AlipayService alipayService;

    @RequestMapping("/alipay")
    public void recharge(Double money,HttpSession session, HttpServletRequest request, HttpServletResponse response){

        String username = (String)session.getAttribute("username");
        String accountId = daoGetAccountId(username);
        rechargeService.rechargeByUserId(accountId,money,alipayConfig,request,response);
    }

    // 同步通知
    @RequestMapping("/return")
    public String dealReturnUrl(HttpSession session, HttpServletRequest request,Map<String,Object> map) throws UnsupportedEncodingException {

        System.out.println("同步通知=================");
        // 验签
        boolean signVerified = alipayService.rsaCheck(alipayConfig,request);

        //↓↓↓↓↓执行业务↓↓↓↓↓//
        String username = (String)session.getAttribute("username");
        if (signVerified){

            // 付款金额
            String totalAmount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            Double money = Double.valueOf(totalAmount);

            // 获取用户账户
            String accontId = daoGetAccountId(username);

            // 模拟充Q币
            System.out.println("---==↓↓↓↓↓==---");
            System.out.println("|为 ["+username+" ]充值："+money+"Q币");
            System.out.println("---==↑↑↑↑↑==---");
            map.put("username",username);
            map.put("accountId",accontId);
            map.put("money",money);

            return "success";
        }else {

            System.out.println("验签失败！");
            map.put("msg","验签失败！");
            return "fail";
        }
        //↑↑↑↑↑执行业务↑↑↑↑↑//
    }

    // 异步通知
    @RequestMapping("/notify")
    @ResponseBody
    public String dealNotifyUrl(HttpSession session, HttpServletRequest request,Map<String,Object> map) throws UnsupportedEncodingException{

        System.out.println("异步通知================");
        // 验签
        boolean signVerified = alipayService.rsaCheck(alipayConfig,request);

        //↓↓↓↓↓执行业务↓↓↓↓↓//
        /* 实际验证过程建议商户务必添加以下校验：
        1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
        4、验证app_id是否为该商户本身。
        */
        if(signVerified) {//验证成功

            //商户订单号
            String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易状态
            String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            if(tradeStatus.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            }else if (tradeStatus.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }


           return "success";

        }else {//验证失败

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
            return "fail";
        }

        //↑↑↑↑↑执行业务↑↑↑↑↑//
    }


    // 模拟从DAO层获取账户ID
    public String daoGetAccountId(String username){

        return String.valueOf(Objects.hashCode(username));
    }
}
