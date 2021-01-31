public abstract class Shape {

    //定义成员变量
    protected double area;
    protected double girth;

    //定义构造方法
    public Shape() {

    }

    //定义代码块
    {
        System.out.println("你好");
    }

    public double getArea() {
        return area;
    }

    public double getGirth() {
        return girth;
    }

    //定义方法
    public void show() {
        calculate();
        System.out.println(area + "_" + girth);
    }

    //定义抽象方法
    protected abstract void calculate();
}
