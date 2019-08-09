package java课;

 class Student {
    //定义属性
    public String name;
    public int age;

    //有两个参数的构造方法
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void show(){
        System.out.println("该学生的姓名和年龄是：");
        System.out.print(name+"   ");
        System.out.print(age);
        System.out.println("");
    }

}
//子类
class Undergduate extends Student{
    public String degree;
    public Undergduate(String name,int age,String degree){
        super(name,age);         //继承基类
        this.degree=degree;
    }
    public void show(){
        System.out.println("该学生的姓名、年龄、学位是：");
        System.out.print(name+"  ");
        System.out.print(age+"  ");
        System.out.print(degree);
    }
}
public class 学生{
    public static void main(String[] args) {
        Student stu=new Student("张华",18);
        stu.show();
        Undergduate under=new Undergduate("李雷",16,"doctor");
        under.show();

    }
}