import org.w3c.dom.ls.LSOutput;

/**
 * 嵌套类
 */
public class NestedClass {//顶级类、外部类

    private int num;

    public void run(InnerClass inner) {

        //外部类可以直接访问内部类实例的成员变量，方法(即使private修饰)
        System.out.println(inner.aaa);
        inner.show();
    }
    //静态嵌套类
    static class StaticNestedClass {

    }

    //非静态嵌套类（内部类）
    public class InnerClass {
        //内部类不能定义除编译时常量以外的任何static成员
        private static final int AGE = 10;
        private int aaa;

        public void show(){
            //内部类可以直接访问外部类中所有的成员(即使private修饰)
            System.out.println(num);
        }
    }
}
