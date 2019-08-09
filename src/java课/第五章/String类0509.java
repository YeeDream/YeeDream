package java课.第五章;

public class String类0509 {
    public static void main(String[] args) {
        String str="HelloWorld";
        char [] charArray=str.toCharArray();
        int i;
        for( i=charArray.length-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }

    }

}
