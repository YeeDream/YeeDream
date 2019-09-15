package 程序设计方法与优化.RPG游戏;

import java.util.Random;
//角色属性
public class Attribute {
    private int strength;//力量
    private int agility;//敏捷
    private int power;//体力
    private int intelligenge;//智力
    private int wisdom;//智慧
    private int LP;//生命值
    private int MP;//魔法值

    //获取角色力量属性
    public int getStrength(){
        return strength;
    }
    //获取角色敏捷属性
    public int getAgility(){
        return agility;
    }
    //获取角色体力属性
    public int getPower(){
        return power;
    }
    //获取角色智力属性
    public int getIntelligenge(){
        return intelligenge;
    }
    //获取角色智慧属性
    public int getWisdom(){
        return wisdom;
    }
    //获取角色生命值属性
    public int getLP(){
        return LP;
    }
    //获取角色魔力值属性
    public int getMP(){
        return MP;
    }

    //生成角色属性
    public void autoattribute(int str,int agi,int pow,int intell,int wis){
        int sum=0;
        Random random=new Random();
        do{
            strength=random.nextInt(10)+str;
            agility=random.nextInt(10)+agi;
            power=random.nextInt(10)+pow;
            intelligenge=random.nextInt(10)+intell;
            wisdom=random.nextInt(10)+wis;
            sum=strength+agility+power+intelligenge+wisdom;
        }while(sum!=100);
            //生命值为体力的20倍
            LP=power*20;
            //法力值为智力与智慧之和的10倍
            MP=(intelligenge+wisdom)*10;
    }

    //初始化角色属性
    public void Initialize(int occupation){
        if(occupation==0){
            autoattribute(40,20,30,5,5);
        }
        if(occupation==1){
            autoattribute(25,15,30,20,10);
        }
        if(occupation==2){
            autoattribute(20,35,20,15,10);
        }
        if(occupation==3){
            autoattribute(15,40,15,10,20);
        }
        if(occupation==4){
            autoattribute(15,20,15,35,15);
        }
        if(occupation==5){
            autoattribute(10,20,10,20,40);
        }
    }


    //输出属性值
    public void OutputArrtibute(){
        System.out.println("===============================");
        System.out.println("力量\t\t\t\t"+this.strength);
        System.out.println("===============================");
        System.out.println("敏捷\t\t\t\t"+this.agility);
        System.out.println("===============================");
        System.out.println("体力\t\t\t\t"+this.power);
        System.out.println("===============================");
        System.out.println("智力\t\t\t\t"+this.intelligenge);
        System.out.println("===============================");
        System.out.println("智慧\t\t\t\t"+this.wisdom);
        System.out.println("===============================");
        System.out.println("生命值\t\t\t\t"+this.LP);
        System.out.println("===============================");
        System.out.println("魔力值\t\t\t\t"+this.MP);
    }

}
