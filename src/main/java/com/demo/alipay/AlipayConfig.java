package com.demo.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082600317078";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQhfKdaNptgn9MF8LCy7Kq3l/ggDcNvw977nITbHnc60Cpc9CuD3Q4adssH+D3ElcV623eQwlnJ27qMpa9cJiszmzcpIyY1aQjfLln+6OTq2An/8fQZ2PW0GDi/n08RMnLmHkY93LsXhwWyO76g6FMpxrMrrMdSplqSTCxbLkIgU4Ufp8Nt/h5fEwWqmBuVeHtdxktDzgMcREIMklFd3jkFEL8FUCNQOL25ItEHS+XoQAsN+E5FYoqZM0RVn2y8L0TON2Au1rmLL9bGdhOZ/JdD7lG4J+rVFjmj/iKo84yuMSttNIpZEOZ79jLMFULjsIfE/PUtLCJSyUs92ea5qeJAgMBAAECggEAdo1qd7WLeEmUItda7HAsH/5Kp96FSsFv8jmnWkehr5dLc7WNeTs0GxK6t3dvEz34MgLuHWTgUb4HPhZBkSTMGPU8V8Kjkrut6W5mqOXDSV9LgYRQZKRrQcutrocUNFw5LMnmjJRvsXWBlS8+2kEgD8EEOuMUCvMm5gkj6GdHYbF0vzEZAXdHDUBWS8w/0wJk6zYvsxNP/puo8Wt3xao6CADEcAfH9YhHkbG1iSNhi6dn3YzLquZFgLLMw/Yt9z3m8/RWi+Nh4f3fq6LxeyhSbytYA6g8FuT5RGN1XdwcxppU5Y54yfYtUc1iKoci53Qb+Nq1Bwtj7Ph2M2sRvMhoAQKBgQDDXd7J9FWbTNRfSs0SO6b8hLBbQWyrmKEHok1bR4sipectK78NcW8vTRFUW0k0+A2f/0HLXD66pILAqUcNG++S6a/96Dc5uDypjEAIsc7i4aEdV9C+GdRoVXHsGtR8KM3baErH+1jrYzZJmReVaCeQ+VYIW8HEGSzqLXwgJ8Sh5wKBgQC9YIBTo6spV+WfVDu571H7cJIx1peQBjH7URLApzV7L0R+HWIfneAKF5JECe2uNXnVykW8m2HbOR6hyKfjRNCQUyg2wbAaJPLR9ATy0hz1KSgsxtUQM3nEe/O3ZuN11dh+muJGtgya6ytK97DCxNE7mZiFN2xRp8EcUBXE0mYdDwKBgGO2QGRhAWRfJTFxsxLwQT021+/rh3RZVS7ZRpQlAr1vYXsrjbplv/KragHdCZMwW3viwwjxDs8h8d41R59IN9GK1hlIcQ9TmhqLC4+keMxRjnK0hETSWBfcLGXuF687AD5Qj4JcJbkWDPopWeEWpMMYjzF6632Tv9nR1z1uLqzXAoGAcQk+z62rppvOdZHDrLIKjzicKp9aDB+GienUdaXYqFSIX3aOcSy844k6Rt5ePlOxC0kW4wMkH8QyYoLwoxkaHGtmX3iw8ooHXgZ3RbDgk/0i+8caufbfwcXyrQ/+yQEBnmA4m9hiIb4pMzAxE7CC6z486ZcxUnP9MjcjJz4msUUCgYEAtjOjy6F/yDZZgvOuo/whQwm99ML2UQ3MrQl2dVm129sjWMCGevpMtYt/WbcB4ubAsUxwZU9jcFmuU8EQUfGWI7GQasjGE8/EDX2D44X//lz7KJSfdaMIwkWDTlsxBmqXCH/TrfZF5uog+2QVLB6w4SOTUCXjoC9YEeKmu5OiLfI=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4QSqYgTNqZ4bbJoS4MwOIZ8nC5oS1tXo2KbHNbqXXARnG6RQ4NyfCI9e1Y5QOUSdzzTEKDv5LvBKcjIPsD8MGHxou7wDcP4Cs3LEs8ZcBHwn3KkTyt+fDsfQNvf0cCjXnieWSk4OSEpyrp/g10uzAlGWmCF6gxSdf6slgA2x7IeJvaQLa1W8u204ie1FvzjXsDwAa1dDTO4ozM8MSOdv7uXe0GJBQErfVZQfV8WtZjKd3+lgBZYg91O+XI7nXC1HmewgLaC7d6WYFimCyo1SvXRtgGvZ4DSUqQfOrujUiIB+toNXRICjdABipn51Qr84KEGkZ2vSeInA5FOlkcrM4QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://bb2d59e4.ngrok.io/YingJiaProject/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//http://1d542e4c.ngrok.io/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp
	public static String return_url = "http://bb2d59e4.ngrok.io/YingJiaProject/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

