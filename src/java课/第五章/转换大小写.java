package java课.第五章;

public class 转换大小写 {
    public static void main(String[] args) {
        String str="HelloWorld";
        int i;
        for( i=str.length()-1;i>=0;i--){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                System.out.print(str.valueOf(str.toLowerCase())+"\n");
            }else if (str.charAt(i)>='a'&&str.charAt(i)<='z'){
                System.out.print(str.toUpperCase());
            }
           // System.out.print(str.charAt(i)+",");
        }
        }

}
