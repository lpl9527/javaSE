package com.lpl;

/**
 *  思路：
 *      超出了Integer相加的范围，所以不能直接转换类型相加。
 *      按照正常的加数逻辑，从个位开始相加，若超过10进1位，相应的后一位就应该加1，当前位减10。
 *      所以需要将两个需要相加的字符串进行反转，然后再将位数补齐（用0补齐），逐位相加后得到结果再进行反转。
 *      也可以不进行反转，反向操作。
 */
public class BigStringNumberAdd {
    /**
     * 两个很大的字符串是数字相加
     * @param strNum1  字符串数字1
     * @param strNum2  字符串数字2
     */
    public static String bigStringNUmberAdd(String strNum1, String strNum2){
        //由于要进行频繁的字符串拼接，所以使用StringBuffer
        StringBuffer str1 = new StringBuffer(strNum1).reverse();  //将字符串数字1反转
        StringBuffer str2 = new StringBuffer(strNum2).reverse();  //将字符串数字2反转
        StringBuffer result = new StringBuffer("");

        System.out.println("str1 ==== " + str1);
        System.out.println("str2 ==== " + str2);
        //将字符串进行补齐
        competion(str1, str2);
        System.out.println("str1 ==== " + str1);
        System.out.println("str2 ==== " + str2);

        int overflow = 0;   //上一位溢出的值
        int num;    //位数相加的值

        for (int i=0; i<str1.length(); i++){
            //位数相加，再加上进位，注意：这里字符相加减是ASCII码相加减
            num  = str1.charAt(i) - '0' + str2.charAt(i) - '0' + overflow;
            if (num >= 10){ //如果有进位
                overflow = 1;   //进位为1
                num -= 10;      //位数和减10
            }else{
                overflow = 0;
            }
            result.append(num);
        }
        //如果最后一位相加仍有进位，则位数加1，值为1
        if (overflow == 1){
            result.append(1);
        }
        //最后别忘记反转
        return result.reverse().toString();
    }

    /**
     * 将两个字符串数字用0补齐
     * @param str1
     * @param str2
     */
    public static void competion(StringBuffer str1, StringBuffer str2){
        //获取两个字符串的长度
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 < len2){   //如果字符串1长度小于字符串2，补全字符串1
            int len = len2 - len1;  //求出相差的位数
            //遍历追加补全
            while (len-- > 0){
                str1.append('0');
            }
        }else{
            int len = len1 - len2;
            //遍历追加补全
            while(len-- > 0){
                str2.append('0');
            }
        }
    }

    public static void main(String[] args) {

        String str1 = "43125462134174114132323477877";
        String str2 = "1312231";
        String sum = bigStringNUmberAdd(str1, str2);
        System.out.println("两个大数相加的结果为：" + sum);
    }

}
