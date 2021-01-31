/**
 * 静态导入
 */
//import static com.prgers.Test.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println(age);
//        run();
    }

    /**
     * 初始化代码块
     * 编译器会将初始化代码块复制到每个构造方法的头部，每创建一个实例对象，就会执行一次初始化块
     */
    {

    }

    /**
     * 静态代码块
     * 每当一个类被初始化的时候执行静态初始化块，当类第一次被主动使用时，JVM就会对类进行初始化，只会初始化一次
     */
    static{

    }
}
