package openid.controller;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import openid.util.AesCbuUtil;
import openid.util.HttpRequest;

@Controller
@RequestMapping("/wxlogin")
public class UserController {
    @RequestMapping(params = "getuserinfo")
    @ResponseBody
//    获取用户的openID
    public Map getuserinfo(String encryptedData, String iv, String code) {
        Map map = new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wxe08feaf00231abb8";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "e84f0e379ff75d5aed3b35c4a98d56ea";
        // 授权（必填）
        String grant_type = "authorization_code";
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // 解析相应内容（转换成json对象）
        JSONObject json = new JSONObject(sr);
        // 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        try {
            String result = AesCbuUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = new JSONObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                // 解密unionId & openId;
                if (!userInfoJSON.isNull("unionId")) {
                    userInfo.put("unionId", userInfoJSON.get("unionId"));
                }
                map.put("userInfo", userInfo);
            } else {
                map.put("status", 0);
                map.put("msg", "解密失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
