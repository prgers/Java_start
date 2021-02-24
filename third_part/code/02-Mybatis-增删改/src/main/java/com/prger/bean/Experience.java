package com.prger.bean;

public class Experience extends BaseBean {

    private String job;
    private String intro;
    private Company company;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "job='" + job + '\'' +
                ", intro='" + intro + '\'' +
                ", company=" + company +
                ", id=" + getId() +
                ", createdTime=" + getCreatedTime() +
                '}';
    }
}
