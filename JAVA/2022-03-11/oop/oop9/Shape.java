package oop.oop9;

public abstract class Shape {
    private Point position;
    public Shape(Point position) {
        this.position = position;
    }

    public Point getPosition() { return position; } // 구현된 메서드
    public abstract int getArea();  // 추상 메서드

    static void printShape(Shape shape) { // 다형 메소드이다
        System.out.println("position: " + shape.position);
        System.out.println("area: " + shape.getArea()); // 동적 바인딩
        // squre에서 구현한 get Area가 호출됨
    }

    public static void main(String[] args) {
        Point position = new Point(0,0);
//        Shape s1 = new Square(position, 10);    // 정삼각형
//        // 부모 객체로 선언했는데 실제 생성한건 자식이네 ?
//        Shape s2 = new Triangle(position, 10, 20);  // 삼각형
//        Shape s3 = new Rectangle(position, 10, 20); // 직사각형

//        printShape(s1);
//        printShape(s2);
//        printShape(s3);

        Shape[] shapes = new Shape[]{
                new Square(position, 10),
                new Triangle(position, 10,20),
                new Rectangle(position, 10,20)};

        for(Shape s: shapes){
            printShape(s);
        }


    }
}

class Point {
    int x;  // X좌표
    int y;  // Y좌표

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x= "+x +" y="+ y ;
    }
}

class Square extends Shape {
    final int width;
    public Square(Point position, int width) {
        super(position);
        this.width = width;
    }
    @Override
    public int getArea() {
        return width * width;
    }
    public int getWidth() { return width; }
}

class Triangle extends Shape{
    final int width;
    final int height;

    public Triangle(Point position, int width, int height){
        super(position);
        this.width = width;
        this.height = height;

    }
    @Override
    public int getArea() {
        return (width*height)/2;
    }
}

class Rectangle extends Shape{
    final int width;
    final int height;

    public Rectangle(Point position, int width, int height){
        super(position);
        this.width = width;
        this.height = height;

    }
    @Override
    public int getArea() {
        return (width*height);
    }

}