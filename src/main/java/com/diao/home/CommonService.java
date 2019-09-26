package com.diao.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

/**
 * CommonService
 */
@Service
public class CommonService {

    @Value("${path.upload}")
    private String fileDir;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 批量保存文件
     * 
     * @param files 文件
     * @param isPic 是否为图片
     * @return
     */
    public List<String> batchSaveFiles(List<MultipartFile> files, boolean isPic) {
        List<String> fileNameList = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String originfileName = file.getOriginalFilename();
                String extName = originfileName.substring(originfileName.indexOf("."));
                String fileName = String.valueOf(System.currentTimeMillis()) + extName;
                String fileFullPath = fileDir + fileName;
                FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(fileFullPath));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fileInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
                fileOutputStream.close();
                fileInputStream.close();
                logger.info("[存储文件] {}", fileFullPath);

                if (isPic) {
                    Thumbnails.of(fileFullPath).size(640, 480).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
                }

                fileNameList.add(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileNameList;
    }
}