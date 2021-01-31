public interface JiaJiao {

    //定义常量
    public static final int AGE = 10;
    int num = 1;

    /**
     * 抽象方法
     */
    void football(Child child);
    void basketball(Child  child);

    /**
     * 默认方法必须要实现
     */
    default void gongfu(Child child) {
        System.out.println("教" + child.getName() + "功夫");
    }

    /**
     * 定义静态方法
     */
    static void test(){
        System.out.println("哈哈哈");
    };

    /**
     * 不允许定义代码块
     */
//    {
//    }
}
