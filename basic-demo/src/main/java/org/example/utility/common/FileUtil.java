package org.example.utility.common;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
public class FileUtil {
    private final static FileUtil o = new FileUtil();
    String saveFilePath = "FILEPATH";

    public static FileUtil get() {
        return o;
    }

    public FileUtil() {
    }

    /**
     * disk -> file 목록 불러오기
     * @IO
     **/
    public List<File> readFiles(String path){
        File file = new File(path);
        return Arrays.stream(Objects.requireNonNull(file.listFiles())).collect(Collectors.toList());
    }

    /**
     * file -> disk 저장 1
     * @NIO
     **/
    public void writeFileToDisk(File file) throws IOException {
        byte[] bytes = fileToByte(file);
        Files.write(Paths.get(saveFilePath+File.separator+file.getName()+"_SAVE"), bytes);
    }

    /**
     * file -> disk 저장 2
     * @IO
     **/
    public void writeToDiskByBufferedWriter(String string){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFilePath+File.separator+"_SAVE"))) {
            bw.write(string);
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * file -> disk 저장 3
     * @IO
     **/
    public void writeToDiskByBufferedOutputStream(String string){
        try (BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(saveFilePath+File.separator+"_SAVE"))){
            bo.write(stringToByteWithDecoding(string));
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * file -> disk 저장 4
     * @NIO
     **/
    public void writeToDiskByFileChannel(String string){
        try (FileChannel fc = new FileOutputStream(new File(saveFilePath+File.separator+"_SAVE")).getChannel()) {
            byte[] bytes = stringToByteWithDecoding(string);
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            fc.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File -> String
     * @IO
     **/
    public String fileToString(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    /**
     * File -> byte[]
     * @IO
     **/
    public byte[] fileToByte(File file) throws IOException {
        return FileUtils.readFileToByteArray(file);
    }

    /**
     * String -> byte[]
     **/
    public byte[] stringToByteWithDecoding(String fileStr){
        return Base64.getDecoder().decode(fileStr);
    }

    /**
     * byte[] -> String
     **/
    public String byteToStringWithEncoding(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }


}
