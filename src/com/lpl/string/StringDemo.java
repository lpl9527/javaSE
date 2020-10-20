package com.lpl.string;

/**
 * Stirng变量细节
 */
public class StringDemo {
    public static void main(String[] args) {

        /**
         * 1.String与new String()的区别
         *      首先，栈区存放对象的引用和基本类型，堆区存对象。==比较的是地址，equals()比较的是对象内容。
         */
        /**
         * String str = "abc";实现过程:
         *      可能创建一个对象可能不创建。首先栈区创建str引用，然后在String池（独立于堆和栈而存在，存储不可变量）中寻找其指向的内容为
         *      "abc"的对象，如果String池中没有，则创建一个放入String池，然后str指向String池中此对象；如果
         *      String池中有，则直接将str指向String池中"abc"对象。如果后来又定义了字符串变量str2 = "abc",则
         *      直接将str2指向String池中已经存在的"abc"对象，不再重新创建对象。所有的字符串都会在编译之后驻留。
         */
        String str1 = "abc";    //str1在编译的时候已经确认为String常量池中的对象
        String str2 = "abc";
        String str3 = "ab" + "c";
        System.err.println("str1 == str2 : " + (str1 == str2));      //均返回true，str1、str2、str3均指向String常量池中同一个引用。
        System.err.println("str1 == str3 : " + (str1 == str3));      //返回true

        String str4 = "ab";
        String str5 = str4 + "c";   //str5在编译的时候不能确认，故str5是一个引用变量引用放在堆区的对象。创建过程：先创建一个StringBuffer
                                    // 对象，然后执行append()方法追加，最后转成String类型。
        System.err.println("str1 == str5 : " + (str1 == str5));    //内存地址不同，返回false
        /**
         * String str = new String("abc");实现过程：
         *      至少创建一个对象，也可能创建2个。直接在堆中创建一个对象，如果这个字符串"abc"在String池中不存在，则也会在String池中创建一
         *      个String对象"abc"。如果后来又有String str2 = new String("abc")，str2不会指向之前的对象，而
         *      是重新在堆中创建一个对象并指向它，此时String池中已经有此对象，不再进行创建。
         */
        String str6 = new String("abc");
        String str7 = new String("abc");
        System.err.println("str6.equals(str7) : " + str6.equals(str7));     //比较的是对象的值，返回true
        System.err.println("str6 == str7 : " + (str6 == str7));       //比较的是对象的引用，返回false

    }
}
