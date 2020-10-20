package com.lpl.anno;

import java.lang.reflect.Method;

/**
 * 转账业务类
 */
public class TransferService {

    /**
     * 转账金额限制
     */
    @TransferMoneyLimit(maxMoney = 12000)   //指定转账限额为12000
    public static void transferMoney(double money){
        String processResult = processTransferMoney(money);
        System.out.println(processResult);
    }

    /**
     * 处理转账金额
     */
    private static String processTransferMoney(double money) {

        try{
            //1.获取当前业务类的Class对象
            Class<TransferService> transferServiceClass = TransferService.class;
            //2.获取转账方法对象
            Method transferMoneyMethod = transferServiceClass.getDeclaredMethod("transferMoney", double.class);
            //3.判断方法上是否有指定类型注解
            boolean annotationPresent = transferMoneyMethod.isAnnotationPresent(TransferMoneyLimit.class);
            if (annotationPresent){
                //4.获取注解对象
                TransferMoneyLimit transferMoneyLimitAnnotation = transferMoneyMethod.getAnnotation(TransferMoneyLimit.class);
                //5.获取注解属性数据
                double maxMoney = transferMoneyLimitAnnotation.maxMoney();
                if (money > maxMoney){  //如果大于转账限额
                    return "转账金额大于限额，转账失败！";
                }else{
                    return "转账金额为：" + money + "，转账成功！";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "转账发生异常！";
    }

    public static void main(String[] args) {
        transferMoney(15000);
    }
}
