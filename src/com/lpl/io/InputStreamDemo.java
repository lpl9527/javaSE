package com.lpl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节输入流，读取外部设备中文件的字节数据到内存中
 */
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("G:Files/stream.txt");     //要读取的文件
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];    //读取的字节存放的数组
        int i = 0;
        i = in.read(bytes);     //读取字节到字节数组中，并返回实际读取的字节数
        System.out.println(i);
        String str = new String(bytes, 0, i);   //将字节数组转化为字符串
        System.out.println(str);
    }
}
