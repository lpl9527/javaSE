package com.lpl.anno;

/**
 * 父类，标注了自定义注解People
 */
@People(value = {@Game(value = "王者荣耀"), @Game(value = "部落冲突")},
        name = "父亲", age = 50)      //自定义注解提供元数据
public class Father {

    public static void main(String[] args) {

        //获取Father的Class对象
        Class<Father> fatherClass = Father.class;
        //获取指定类型的public自定义注解
        People peopleAnnotation = fatherClass.getAnnotation(People.class);
        //获取注解属性
        String name = peopleAnnotation.name();
        int age = peopleAnnotation.age();
        System.out.println("姓名：" + name + "，年龄：" + age + "，喜欢的游戏：");
        //获取注解数组类型的注解属性
        Game[] games = peopleAnnotation.value();
        for (int i=0; i<games.length; i++){
            String gameName = games[i].value();
            System.out.print(gameName + " ");
        }
    }
}
