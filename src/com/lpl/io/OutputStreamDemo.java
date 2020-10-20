package com.lpl.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Java的流式IO（外部设备到内存、内存到外部设备）操作是建立在四个抽象类基础上的：InputStream、OutputStream
 *      、Reader、Writer。
 *      1）InputStream和OutputStream为字节流设计，一般用来处理字节或二进制对象。
 *      2）Reader和Writer为字符流设计，一般用来处理字符或字符串。
 *      两种方式操作文件时都按照以下方式进行：
 *          1.使用File类找到一个对象；
 *          2.通过File类的对象去实例化字节流或字符流的实现类；
 *          3.进行字节或字符的读写操作；
 *          4.关闭文件流；
 */
public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {
        /**
         * FileOutputStream应该是Java中最常见的字节输出流了，可向外部设备文件写入字节数据。
         * FileOutputStream的创建不依赖于文件是否存在，在创建对象时，会在打开输出文件之前就创建
         *  它，如果文件是只读文件，会抛出IOException异常。
         */
        File file = new File("G:" + File.separator + "Files/stream.txt");
        OutputStream out = new FileOutputStream(file);
        String str = "写入文件的字符串，覆盖还是追加？";       //要写入文件的字符串
        byte[] bytes = str.getBytes("UTF-8");//操作字节流，要将字符串转换为字节
        out.write(bytes);   //向文件中写入字节
        out.close();    //关闭资源
    }
}
