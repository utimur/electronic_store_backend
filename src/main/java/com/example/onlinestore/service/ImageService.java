package com.example.onlinestore.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class ImageService {
    public static final String IMAGE_PATH = "C:\\Users\\tim\\Desktop\\online-store\\online-store\\src\\main\\resources\\static\\img\\";


    public static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedfile;
    }

    public static String saveFile(MultipartFile img) throws IOException {
        if(img != null) {
            String fileName = UUID.randomUUID().toString() + ".jpg";
            File convertFile = new File(IMAGE_PATH + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(img.getBytes());
            fout.close();
            return fileName;
        }
        return null;
    }
}
