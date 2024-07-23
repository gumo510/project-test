package com.intellif.types.utils;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;

public class FIleTest {
    public static void main(String[] args) throws Exception {
        readImageBytes("https://192.168.12.56:38089/fusionfsintellif202/fs01/20240703/023/20240703T105501_50899_61b0d9e65da40-f0.jpg");
        System.out.println("******");
    }

    public static byte[] readImageBytes(String url) throws Exception {

//        disableSslVerification();
        URL urlObj = new URL(url);
        byte[] bytes = new byte[1024];
        URLConnection urlConnection = urlObj.openConnection();
        urlConnection.setConnectTimeout(30000);
        urlConnection.setReadTimeout(60000);
        // 添加请求头 反盗链
        urlConnection.setRequestProperty("Referer", "https://swd.vesionbook.com:38065/");
        try (InputStream inputStream = urlConnection.getInputStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            return outputStream.toByteArray();
        }
    }

    static {
        // 创建忽略SSL验证代码只会被执行一次
        disableSslVerification();
    }

    public static void disableSslVerification() {
        // 创建一个信任所有证书的TrustManager
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };


        try {
            // 初始化SSLContext
            SSLContext sc = SSLContext.getInstance("TLSv1.3");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            // 设置SSLContext到HttpsURLConnection
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // 创建一个HostnameVerifier，它不做任何检查
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true; // 不检查主机名
                }
            };

            // 安装所有主机名验证器
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
