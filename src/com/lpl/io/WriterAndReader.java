package com.lpl.io;

import java.io.*;

/**
 * 字节流不能直接操作Unicode字符，字节流一次只能操纵一个字节，Unicode有两个字节。
 * Java默认字符集是GBK
 */
public class WriterAndReader {

    public static void main(String[] args) throws IOException {

        File file = new File("G:Files/writer.txt");
        //写文件操纵
        Writer out = new FileWriter(file);
        String str = "字符输出字符串！";
        out.write(str);     //将字符串输出
        out.close();

        //读文件操作
        Reader in = new FileReader(file);
        char[] chars = new char[1024];      //开辟一个空间来存储一个文件读进来的字符数据
        int i = 0;
        i = in.read(chars);     //将文件中的字符数据读入字符数组中，同时返回读入的字符个数
        in.close();

        if(-1 == i){
            System.out.println("文件中无数据！");
        }else{
            System.out.println(new String(chars, 0, i));
        }


    }


}
