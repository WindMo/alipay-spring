package com.alipay.alipayspringdemo.alipayService;

/**
 * @author WindShadow
 * @verion 2019/12/27.
 */

/*
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public String appId = "2016101200664806";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public String merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDNEThUxYBMr0WIH4mq2cQtiFuOZkloPTN9sEC1vbir1RZDK2RCe1Pa2FCmQYI+Y1qEo02N+nn0/Ca0xT2PhuMmiWewwW3ONMoO3l/a8wo0tVM4aw7inOWCa8uW2f4/FLIGSZjSZe+EZERi9eY5f435zGbP5IRMcJ+GHbfdWuQk4/x1DktqOfDTnWzU5eJL/b8ZGdbTEFo6M9HepD4KvF6f0jH8TouwAVfJkkNKLSZLm8Dcma/rscsQ4V1FxDOcq87USxOkK06wn/DOprv+IafreEswA+aRFOL6AvVCACpmUDj+W+ebBMU97Q4uTv0XZFgh+4MoGv3blt4if1ea/Tv3AgMBAAECggEAHzF8YSC92Gxc5kzt0whXGBoC21Fh3zJYD8lsvniCi9jZDxSdpqM96S84bWHPnw/b6AszM+KjBIoKlTrfl2KMUQNbu35g5poPFl3rNNH9fnEKnK1kUUJOgx1ElcjJLO1H+z7cuTx6R6g84tTG1X46qYHXLc5z9XC4Q11n54r440dpFlyNhi0hKT+pF9RP9bicm5V0JpG0xXa5iEt6nDYmbNmkh+MM7ZuNOO7Bi7IRHQTVGX6CBHooSMJ8e1CUL5HyEmYdRvAsH3eiry9rKNZuD87k4KbfKBP6CpI11p81N66SqF3i17ROyVcH+bevz6+m1MsgO/ovbZ2CgHb7s7/tQQKBgQDr4kKPa00oW4GCZ/m/GrjGnIX2RcPn9tJasfhSLn2CqMkT9qOlerfHoLycB7Lukp68lLVsyoySG7T7mUCMVikujWloRddlsrhwlozupT0pmo0UUypbhlfnGsnHz0si18wF2h0S/OCdbTnzuP4dt7STTb58MncT4TXf8VbRFinw1wKBgQDeji7IlfSh44F4RF0oqU6Q/ifF2DWveqFoaIE39PstV/lxY+WU93bXM9oIRAChL8IHEk7ypmRzqdXVxshvrN2k0DYWKymWrBhkFDKz1z8rstype4E8YvhM+tKNInUKQYI2tmzriNLDpewNeIjXLCK/tRcSb4fV8/x63f7KtH8J4QKBgQCkL9RmoaiOK8tkqtzi0UXGMRLpzbvEDUB0EqanBWcleDimJanYuCeN02sVLCK2/uVwnA4AUKgx1wlNi2mrhRmbJqE1DFAWoKTS8WfdgLSm7cW/XPgBxuwOl83Vv4ssEIsZk61jFxN9YJbS93Qh2UnesmGhbzsFYmAupXzpgoTk9wKBgCDh2xGx7kIZDiEJ4MXINh6AHrpBlrUFpmF5x1XQMWhiri1NuDcJVRq4w4cjHQCzwLQwxU9evErGlhyO0UCGxvy58rPVzsA/Tx9CSLd/nwrC042K/O5CJTOif4dwxuAsC6Qv0en+/jz//9+Bpp48HCo9BFqp9eTrtqskr6edgYOhAoGAUwZ0hMNKOwCHsIEnXsJ7fxsa2oyBcJ6fFLZ3iaiYF9MkuzgdGoNZJZx93X8G70NHQ0pFQQT/NhqDFPJHAzu/hbwEtSeE7pb8L2IiSIvtcgaDW9cogBO5cTQKy16PrrenEKW+6iNZd6ZcF+rxW0knEvQbyqe3EXby1Pa81axl/7I=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtlnf6QtdbE6IlXsktWj7DfH1EVSy8THx/+gr3mr3Yuz+ATwJtnLdbCLCTr9cgWWDPuDzyuneALJITaEZ8HSnsbM0CtLL+c6tR+mj8Y8sh6Kuw775PSc7BH/UUUFubjCG+0JB8O9Dnkj50kPoacinX6XbHCba49/ngPE7kKi9SysNeJc+ZmsKSE6rQe3Zs5XkK8WdxjqNc1lS7ThFGXWLFpwfahMOxi7NfIkBUpxV6LeejorqnA5i/GUg9bxDyzFMooTpaQRXPETAbSyxgqrfwnHFGMbr5iiREJdOuyM+3TBRncLS8d/s3TPU/hZ3eIXQ6pw2jVYGFR6exXeOWidWWQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public String notifyUrl = "http://localhost:8080/";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public String returnUrl = "http://localhost:8080/";

	// 签名方式
	public String signType = "RSA2";
	
	// 字符编码格式
	public String charset = "utf-8";
	
	// 支付宝网关
	public String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志路径
	public String logPath = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public void logResult(String sWord) {

//        System.out.println(sWord);
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(logPath + "alipay_log_" + System.currentTimeMillis()+".txt");
//            writer.write(sWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

	public AlipayConfig() {}

	public AlipayConfig(String app_id, String merchant_private_key, String alipay_public_key, String notify_url, String return_url, String sign_type, String charset, String gatewayUrl, String log_path) {
		this.appId = app_id;
		this.merchantPrivateKey = merchant_private_key;
		this.alipayPublicKey = alipay_public_key;
		this.notifyUrl = notify_url;
		this.returnUrl = return_url;
		this.signType = sign_type;
		this.charset = charset;
		this.gatewayUrl = gatewayUrl;
		this.logPath = log_path;
	}

	/**--------------------------------------------Get Set--------------------------------------------**/
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMerchantPrivateKey() {
		return merchantPrivateKey;
	}

	public void setMerchantPrivateKey(String merchantPrivateKey) {
		this.merchantPrivateKey = merchantPrivateKey;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getGatewayUrl() {
		return gatewayUrl;
	}

	public void setGatewayUrl(String gatewayUrl) {
		this.gatewayUrl = gatewayUrl;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
}

