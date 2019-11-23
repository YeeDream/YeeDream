/**
 * @Author DreamYee
 * @Create 2019/11/23  10:47
 */
public class ddd {
        public static void main(String args[]) {
            new Supper().get();
            new Sub().get();
        }
    }
class Supper{
    public int get()
    {
        System.out.println("Supper");
        return 5;
    }
}
 class Sub{
    public int get() {
        System.out.println("Sub");
        return new Integer("5");

    }
}
