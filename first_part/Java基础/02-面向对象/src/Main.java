import com.prgers.model.GoodStudent;
import com.prgers.model.Person;

public class Main {

    public static void main(String[] args) {

        /**
         * 三个字段在堆空间的存储顺序为
         * name no salary
         */
        GoodStudent student = new GoodStudent();
        student.name = "张三";
        student.no = 1;
        student.salary = 1000;
        System.out.println(student);
    }
}
