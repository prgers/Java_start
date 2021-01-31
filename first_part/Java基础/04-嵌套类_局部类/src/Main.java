public class Main {
    public static void main(String[] args) {

        NestedClass nestedClass = new NestedClass();

        //必须先创建外部类实例，然后再用外部类实例创建内部类实例
        NestedClass.StaticNestedClass staticNestedClass =  new NestedClass.StaticNestedClass();
    }
}
