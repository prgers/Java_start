public class Child {
    private String name;
    private JiaJiao jiaJiao;

    public String getName() {
        return name;
    }

    public Child(String name) {
        this.name = name;
    }

    public void setJiaJiao(JiaJiao jiaJiao) {
        this.jiaJiao = jiaJiao;
    }

    public void study() {
        jiaJiao.football(this);
        jiaJiao.basketball(this);
        jiaJiao.gongfu(this);
    }
}
