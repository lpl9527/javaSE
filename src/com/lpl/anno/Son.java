package com.lpl.anno;

/**
 * 子类，继承自父类Father，未标注任何注解，所以可继承父类的自定义注解People（自定义注解People标注
 *      了元注解@Inherited）
 *
 *     如果此处未声明注解，使用的就是父类上声明的自定义注解及注解中元数据。
 *     如果此处未声明注解元数据，使用的是自定义注解默认元数据
 */
@People(value = {@Game(value = "王者荣耀"), @Game(value = "LOL")}, name = "儿子", age = 23)
public class Son extends Father {

    /**
     * 子类未声明注解的情况下，也可以获取父类自定义注解（前提是父类自定义注解有@Inherited元注解）
     */
    public static void main(String[] args) {

        //获取Son的Class对象
        Class<Son> sonClass = Son.class;
        //获取继承自父类指定类型的public自定义注解
        People peopleAnnotation = sonClass.getAnnotation(People.class);
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
