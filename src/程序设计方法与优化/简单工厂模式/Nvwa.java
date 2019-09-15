package 程序设计方法与优化.简单工厂模式;

public class Nvwa {
    public static PersonFactory getpeople(String str){
           PersonFactory  people=null;
           if(str.equalsIgnoreCase("M")){
               people=new Men();
               System.out.println("出现了男人");
           }else if(str.equalsIgnoreCase("W")){
               people=new Women();
               System.out.println("出现了女人");
           }else if(str.equalsIgnoreCase("R")){
               people=new Robot();
               System.out.println("出现了机器人");
           }
           return people;
    }
}
