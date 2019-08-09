package java课;

interface Cycle{
   boolean move();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    private int moves=0;
    private static final int MOVES=3;
    public boolean move(){
        System.out.println("Unicycle move"+moves);
        return ++moves !=MOVES;
    }
}

class UnicycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move() {
        System.out.println("Bicycle move" + moves);
        return ++moves != MOVES;
    }
}

class BicycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Bicycle();
    }
}

class Tricycle implements Cycle{
    private int moves = 0;
    private static final int MOVES = 5;
    public boolean move() {
        System.out.println("Tricycle move" + moves);
        return ++moves != MOVES;
    }
}

class TricycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}

public class 交通工具 {
    public static void playCycle(CycleFactory factory){
        Cycle c=factory.getCycle();
        while(c.move())
            ;
    }
    public static void main(String[] args) {
        playCycle(new UnicycleFactory());
        playCycle(new BicycleFactory());
        playCycle(new TricycleFactory());
    }
}
