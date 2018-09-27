package openid.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件
 *
 */
@Controller
@MultipartConfig
@RequestMapping("/upload")
public class Upload{
    String filename = null;

    @RequestMapping("/file")
    @ResponseBody
    public String test(MultipartFile file, HttpServletRequest request) throws IOException {
        //获取上传文件的目录
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = file.getOriginalFilename();
        //        获取后缀名
        String str = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
        filename = UUID.randomUUID().toString() + str;
        File dir = new File(path, filename);

        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(dir);
        System.out.println(dir);
        System.out.println(filename);
        return filename + dir;
    }
}
