package 程序设计方法与优化.RPG游戏;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//游戏运行类
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        //创建角色对象
        Role role = new Role();
        define_raceANDoccupation ro = new define_raceANDoccupation();
        Attribute att = new Attribute();
        do {

            role.Define();
            int race = ro.selectRace();
            ro.selectOccupation();
            //输出角色基本信息
            role.output();
            ro.outRaceANDOccupation();
            att.Initialize(ro.getOccupation());
            att.OutputArrtibute();

            //判断对创建的角色是否满意
            System.out.println("是否满意该角色？（Y/N）若不满意，则重新创建");
            String str = sc.next();
            if ("Y".equals(str) || "y".equals(str)) {
                break;
            }
        } while (flag);
        SaveInformation(role,ro,att);
        System.out.println("角色已成功保存！");
    }

    //将角色信息保存到文件中
    public static void SaveInformation(Role role,define_raceANDoccupation ro,Attribute att){
        try{
                //创建输出流对象
                FileWriter file=new FileWriter("C://Users//asus//Desktop//roles_information.txt",true);
                //字符缓冲输出流
                BufferedWriter bw=new BufferedWriter(file);
                bw.write("姓名\t\t\t\t"+role.getName());
                //输出换行
                bw.newLine();
                if(role.getGender()==0){
                   bw.write("性别\t\t\t\t"+"男");
                }else{
                    bw.write("性别\t\t\t\t"+"女");
                }
                bw.newLine();
                switch(ro.getRace()){
                    case 0:
                        bw.write("种族\t\t\t\t"+"人类");
                        break;
                    case 1:
                        bw.write("种族\t\t\t\t"+"精灵");
                        break;
                    case 2:
                        bw.write("种族\t\t\t\t"+"兽人");
                        break;
                    case 3:
                        bw.write("种族\t\t\t\t"+"矮人");
                        break;
                    case 4:
                        bw.write("种族\t\t\t\t"+"元素");
                        break;
                    default:
                        break;
                }
                bw.newLine();
                switch(ro.getOccupation()) {
                    case 0:
                        bw.write("职业\t\t\t\t" + "狂战士");
                        break;
                    case 1:
                        bw.write("职业\t\t\t\t" + "圣骑士");
                        break;
                    case 2:
                        bw.write("职业\t\t\t\t" + "刺客");
                        break;
                    case 3:
                        bw.write("职业\t\t\t\t" + "猎手");
                        break;
                    case 4:
                        bw.write("职业\t\t\t\t" + "祭司");
                        break;
                    case 5:
                        bw.write("职业\t\t\t\t" + "巫师");
                    default:
                        break;
                }
                bw.newLine();
                bw.write("力量\t\t\t\t"+att.getStrength());
                bw.newLine();
                bw.write("敏捷\t\t\t\t"+att.getAgility());
                bw.newLine();
                bw.write("体力\t\t\t\t"+att.getPower());
                bw.newLine();
                bw.write("智力\t\t\t\t"+att.getIntelligenge());
                bw.newLine();
                bw.write("智慧\t\t\t\t"+att.getWisdom());
                bw.newLine();
                bw.write("生命值\t\t\t\t"+att.getLP());
                bw.newLine();
                bw.write("魔力值\t\t\t\t"+att.getMP());
                //关闭文件
            bw.close();
        }catch(FileNotFoundException e){
                e.printStackTrace();
        }catch(IOException e){
                e.printStackTrace();
        }
    }
}
