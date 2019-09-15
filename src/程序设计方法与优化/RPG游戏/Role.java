package 程序设计方法与优化.RPG游戏;
import java.util.Scanner;
public class Role {
    //定义角色的性别、姓名
    private String name;  //姓名
    private int gender; //性别

    //获取姓名
    public String getName() {
        return name;
    }

    //设置姓名
    public void setName(String name) {
        this.name = name;
    }

    //获取性别
    public int getGender() {
        return gender;
    }

    //设置性别
    public void setGender(int gender) {
        this.gender = gender;
    }

    //获取到角色的姓名跟性别
    public int  Define(){
        System.out.println("请输入您游戏角色的姓名：");
        Scanner in=new Scanner(System.in);
        this.name=in.next();
        while(true){
            System.out.println("请选择角色的性别：（0.男    1.女）");
            this.gender=in.nextInt();
            if(gender==0||gender==1){
                break;
            }else{
                System.out.println("请选择0或1来选择性别！");
            }
        }
        return gender;
    }

    //输出角色的姓名跟性别
    public void output(){
        System.out.println("===============================");
        System.out.println("姓名\t\t\t\t"+this.name);
        System.out.println("===============================");
        if(this.gender==0){
            System.out.println("性别\t\t\t\t"+"男");
        }else{
            System.out.println("性别\t\t\t\t"+"女");
        }
    }
}

