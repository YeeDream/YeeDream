package java课;

interface Shape{
    double area(double givenValue);
}
class Square implements Shape {
    public double area(double Length) {
        return Length * Length;
    }
}
    class Circle implements Shape {
        public double area(double r) {
            return Math.PI * r * r;
        }
    }

    public class S {
        public static void main(String[] args) {
            Shape square=new Square();
            Shape circle=new Circle();
            System.out.println(square.area(2));
            System.out.println(circle.area(3));


        }
    }
