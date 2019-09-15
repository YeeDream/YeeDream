package 程序设计方法与优化.RPG游戏;
import java.util.Scanner;

//角色的种族及职业
public class define_raceANDoccupation {
    private int race;//种族
    private int occupation;//职业
    private String[] races={"人类","精灵","兽人","矮人","元素"};
    private String[] occupations={"狂战士","圣骑士","刺客","猎手","祭司","巫师"};

    //获取角色种族信息
    public int getRace(){
        return this.race;
    }

    //获取角色职业信息
    public int getOccupation(){
        return this.occupation;
    }

    //设置角色种族
    public void setRace(){
        this.race=race;
    }

    //选择角色种族
    public int selectRace(){
        while(true){
            System.out.println("请输入您要选择的角色的种族:（0.人类  1.精灵  2.兽人   3.矮人  4.元素）");
            Scanner in=new Scanner(System.in);
            this.race=in.nextInt();
            if(race>=0&&race<=4){
                break;
            }else{
                System.out.println("请在0-4数字中选择角色种族！");
            }
        }
        return race;
    }

    //选择角色职业
    public int selectOccupation(){
        switch (race){
            case 0:
                while(true){
                    System.out.println("请选择您要选择的职业：（0.狂战士  1.圣骑士  2.刺客   3.猎手   4.祭司   5.巫师）");
                    Scanner in=new Scanner(System.in);
                    this.occupation=in.nextInt();
                    if(occupation>=0&&occupation<=5){
                        break;
                    }else{
                        System.out.println("请在0-5数字中选择角色职业！");
                    }
                }
                break;
            case 1:
                while(true){
                    System.out.println("请选择您要选择的职业：(2.刺客   3.猎手   4.祭司   5.巫师)");
                    Scanner in=new Scanner(System.in);
                    this.occupation=in.nextInt();
                    if(occupation>=2&&occupation<=5){
                        break;
                    }else{
                        System.out.println("请在2-5数字中选择角色职业！");
                    }
                }
                break;
            case 2:
                while(true){
                    System.out.println("请选择您要选择的职业：(0.狂战士  3.猎手  4.祭司)");
                    Scanner in=new Scanner(System.in);
                    this.occupation=in.nextInt();
                    if(occupation==0||occupation==3||occupation==4){
                        break;
                    }else{
                        System.out.println("请在0,3,4数字中选择角色职业！");
                    }
                }
                break;
            case 3:
                while(true){
                    System.out.println("请选择您要选择的职业：(0.狂战士  1.圣骑士  4.祭司)");
                    Scanner in=new Scanner(System.in);
                    this.occupation=in.nextInt();
                    if(occupation==0||occupation==1||occupation==4){
                        break;
                    }else{
                        System.out.println("请在0,1,4数字中选择角色职业！");
                    }
                }
                break;
            case 4:
                while(true){
                    System.out.println("请选择您要选择的职业：(4.祭司   5.巫师)");
                    Scanner in=new Scanner(System.in);
                    this.occupation=in.nextInt();
                    if(occupation==4||occupation==5){
                        break;
                    }else{
                        System.out.println("请在4,5数字中选择角色职业！");
                    }

                }
                break;
            default:
                break;
        }
        return occupation;
    }

    //输出种族及职业信息
    public void outRaceANDOccupation(){
        System.out.println("===============================");
        System.out.println("种族\t\t\t\t"+races[this.race]);
        System.out.println("===============================");
        System.out.println("职业\t\t\t\t"+occupations[this.occupation]);
    }
}
