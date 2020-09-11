package com.vue.demo.api;

import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadApi {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "src/main/resources/static/uploadFile/";

    @RequestMapping(value = "/uploadFile",consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload";

        Map<String, String> map = new HashMap<>();

        File file = new File(UPLOAD_PATH_PREFIX);

        if (!file.isDirectory()) {
            file.mkdirs();
        }

        if (multipartFile.isEmpty()) {
            map.put("message", "上传错误");
            return map;
        }
        String fileName = multipartFile.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        File file1 = new File(file.getAbsolutePath() + File.separator + fileName);

        multipartFile.transferTo(file1);

        map.put("message", "上传成功");
        map.put("path", file1.getPath());
        return map;
    }
}
