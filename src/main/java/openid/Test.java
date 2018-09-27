package openid;



import net.sf.json.JSONObject;
import openid.util.GetTokenUtil;
import openid.util.QrCodeUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @version: V1.0
 * @author: fendo
 * @className: TestQR
 * @packageName: com.xxx
 * @description: 二维码测试类
 **/
public class Test{

//    public static void main(String[] args)
//    {
//        try {
//            String accessToken = GetTokenUtil.getAccessToken();
//            System.out.println(accessToken);
//            URL url = new URL("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+accessToken);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");// 提交模式
//            // 发送POST请求必须设置如下两行
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
//            // 发送请求参数
//            JSONObject paramJson = new JSONObject();
//            paramJson.put("path", "pages/home/index");
//            paramJson.put("width", 430);
//            printWriter.write(paramJson.toString());
//            // flush输出流的缓冲
//            printWriter.flush();
//            //开始获取数据
//            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
//            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//            //buff用于存放循环读取的临时数据
//            byte[] buff = new byte[100];
//            int rc = 0;
//            while ((rc = bis.read(buff, 0, 100)) > 0) {
//                swapStream.write(buff, 0, rc);
//            }
//            ByteArrayInputStream inputStream= new ByteArrayInputStream(swapStream.toByteArray());
//            BufferedImage image = ImageIO.read(inputStream);
//            /**裁剪原图  目前访问微信 微信返回的是 470*535 像素 170620*/
//            BufferedImage subImage = image.getSubimage(0, 0, image.getWidth(), (int) (image.getHeight() * 0.85));
//            //            System.out.println(QrCodeUtils.decodeQrcode(subImage));
//            BufferedImage inputbig = new BufferedImage(256, 256, BufferedImage.TYPE_INT_BGR);
//            Graphics2D g = (Graphics2D) inputbig.getGraphics();
//            g.drawImage(subImage, 0, 0,256,256,null); //画图
//            g.dispose();
//            inputbig.flush();
//            ImageIO.write(inputbig, "jpg", new File("C:\\Users\\Administrator\\Desktop\\1.png"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
