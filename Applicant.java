// Applicant.java
// Represents one student's data record.

public class Applicant {
    String name;
    int age;
    String geography;
    String ethnicity;
    double income;
    boolean legacy;
    boolean local;
    double gpa;
    int test;
    double extra;
    double essay;
    double rec;
    boolean firstGen;
    boolean disability;

    public Applicant(String name, int age, String geography, String ethnicity, double income,
                     boolean legacy, boolean local, double gpa, int test, double extra,
                     double essay, double rec, boolean firstGen, boolean disability) {
        this.name = name;
        this.age = age;
        this.geography = geography;
        this.ethnicity = ethnicity;
        this.income = income;
        this.legacy = legacy;
        this.local = local;
        this.gpa = gpa;
        this.test = test;
        this.extra = extra;
        this.essay = essay;
        this.rec = rec;
        this.firstGen = firstGen;
        this.disability = disability;
    }
}