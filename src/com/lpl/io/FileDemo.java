package com.lpl.io;

import java.io.File;

/**
 * 大多数程序要与外部设备进行数据交换，最常见的外部设备包含磁盘和网络。IO是指对这些设备的输入与输出。
 *  File是IO包中唯一代表磁盘文件本身的对象，File类定义了一些与平台无关的方法来操作文件。
 */
public class FileDemo {

    public static void main(String[] args) {
        String fileName = "G:" + File.separator + "Files";
        File file = new File(fileName);     //获取文件对象，而不是创建文件
        if (file.exists() && file.isDirectory()){   //判断路径指向的
            File[] files = file.listFiles();    //获取文件夹下所有文件、文件夹（仅该层目录）
            System.out.println("Files文件夹下所有文件-------------：");
            for (File f : files){
                System.out.println(f);
            }
            System.out.println("-------------------------------------");
            //获取文件夹下第一个文件的各种信息
            System.out.println("文件名称：" + files[0].getName());  //获取文件名、文件夹名称
            System.out.println("文件路径：" + files[0].getPath());  //获取路径
            System.out.println("文件绝对路径：" + files[0].getAbsolutePath());    //获取绝对路径
            System.out.println("父文件夹路径：" + files[0].getParent());  //获取父文件夹路径
            System.out.println(files[0].exists() ? "文件存在！" : "文件不存在！");     //判断文件是否存在
            System.out.println(files[0].canRead() ? "文件可读！" : "文件不可读！");    //判断文件是否可读
            System.out.println(files[0].canWrite() ? "文件可写！" : "文件不可写！");   //判断文件是否可写
            System.out.println(files[0].canExecute() ? "文件可执行！" : "文件不可执行！");   //判断文件是否可执行
            System.out.println(files[0].isFile() ? "是文件！" : "不是文件！");       //判断文件是不是文件
            System.out.println(files[0].isDirectory() ? "是文件夹！" : "不是文件夹！");    //判断文件是不是文件夹
            System.out.println(files[0].isAbsolute() ? "路径名是绝对路径！" : "路径名不是绝对路径！");     //判断文件路径名是不是绝对路径
            System.out.println("文件最后修改时间：" + files[0].lastModified());  //获取文件最后修改时间
            System.out.println("文件的大小：" + files[0].length() + "Bytes");     //获取文件字节数，如果是文件夹则为0
            System.out.println("文件的URI为：" + files[0].toURI());      //返回文件URI

            if (files[0].exists()){
                //files[0].delete();      //删除文件，删除的如果是文件夹并且文件夹下还有文件是无法删除的
                //files[0].deleteOnExit();    //虚拟机关闭时删除文件
            }

        }else{
            file.mkdir();   //创建文件夹
        }

    }
}
