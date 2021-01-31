public class Teacher implements JiaJiao{

    @Override
    public void football(Child child) {
        System.out.println("教" + child.getName() + "踢足球");
    }

    @Override
    public void basketball(Child child) {
        System.out.println("教" + child.getName() + "打足球");
    }
}
