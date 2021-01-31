public class FirstMain {
    public static void main(String[] args) {

        /**
         * str1是指向的一个字符串ABC
         * str2是指向的一个空字符串
         * str3是一个空指针， 没有指向任何人
         */
        String str1 = "ABC";
        String str2 = "";
        String str3 = null;


        /**
         * 变量的初始化
         * 任何变量在使用之前都必须要先初始化(赋值)
         * 局部变量：需要程序员手动初始化
         * 非局部变量(实例变量，类变量): 编译器会自动给未初始化的变量设置一个初始值
         */

//        int age;
//        System.out.println(age);

        int age = 10;
        System.out.println(age);

        /**
         * >> 和 >>>的区别
         * >>  (有符号右移): 最左用符号为补齐
         * >>> (无符号右移): 最左用0补齐
         *
         * 负数的符号为1
         * 整数的符号为0
         */
        System.out.println(Integer.toBinaryString(-128));       //11111111111111111111111110000000
        System.out.println(Integer.toBinaryString(-128 >> 2));  //11111111111111111111111111100000
        System.out.println(Integer.toBinaryString(-128 >>> 2)); //00111111111111111111111111100000


        /**
         *  && || 和 & | 的区别
         *  & | 相对于 && || 没有短路功能
         *
         *  什么叫短路功能
         *  只要第一个条件不满足，就不会去调用第二个条件
         */

//        boolean result1 = true && getBoolean(); //打印getBoolean
//        boolean result2 = false && getBoolean(); //不打印getBoolean
//        boolean result3 = true || getBoolean(); //不打印getBoolean
//        boolean result4 = false || getBoolean(); //打印getBoolean

//        boolean result5 = false & getBoolean(); //打印getBoolean
//        boolean result6 = true & getBoolean(); //打印getBoolean
//        boolean result7 = true | getBoolean(); //打印getBoolean
        boolean result8 = false | getBoolean(); //打印getBoolean

        /**
         * 官方推荐定义数组方式： int[] array
         * 不推荐使用 int array[]
         */
        int[] array = new int[4];
        array[0] = 1;

        /**
         * 可变参数必须是方法的最后一个参数
         */
        System.out.println(sum(1, 2, 3));

    }

    public static int sum(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }


    public static boolean getBoolean() {
        System.out.println("getBoolean");
        return true;
    }
}
