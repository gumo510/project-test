package com.intellif.types.utils;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class TrustAllCertsManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }

    public static void main(String[] args) throws Exception {
        // 创建一个信任所有证书的TrustManager
        TrustManager[] trustAllCerts = new TrustManager[]{new TrustAllCertsManager()};

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

        // 现在你可以使用HttpsURLConnection进行请求，而不会检查SSL证书
        // ... 这里添加你的请求代码
        // 现在可以安全地进行HTTPS请求，而不用担心证书验证
        URL myUrl = new URL("https://192.168.12.56:38089/fusionfsintellif202/fs01/20240703/023/20240703T105501_50899_61b0d9e65da40-f0.jpg");
        HttpsURLConnection connection = (HttpsURLConnection) myUrl.openConnection();
        // 添加请求头 反盗链
        connection.setRequestProperty("Referer", "https://swd.vesionbook.com:38065/");
        connection.connect();
        byte[] bytes = new byte[1024];
        try (InputStream inputStream = connection.getInputStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            outputStream.toByteArray();
        }

    }
}