package oop.oop3;

public class Shape {
    public static void main(String[] args) {
        Square square = new Square(1, 1, 20);
        System.out.println("squre 넓이 : "+square.getArea());
        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("rectangle 넓이 : "+rectangle.getArea());
        Triangle triangle = new Triangle(10, 10);
        System.out.println("triangle 넓이 : "+triangle.getArea());
        Circle circle = new Circle(5);
        System.out.println("circle 넓이 : "+circle.getArea());
    }
}

class Square extends Shape {
    Point position; // 정사각형의 위치
    int width;  // 정사각형의 변의 길이

    public Square(int x, int y, int width) {
        this.position = new Point(x, y);
        this.width = width;
    }

    public int getArea() {
        return width * width;
    }
}

class Point {
    int x;  // X좌표
    int y;  // Y좌표

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle extends Shape {
    Point position; // 정사각형의 위치
    int width;  // 정사각형의 변의 길이
    int heigth;

    public Rectangle(int x, int y) {
        this.position = new Point(x, y);
        this.width = x;
        this.heigth = y;
    }

    public int getArea() {
        return width * heigth;
    }

}

class Triangle extends Shape {
    Point position; // 정사각형의 위치
    int width;  // 정사각형의 변의 길이
    int heigth;

    public Triangle(int x, int y) {
        this.width = x;
        this.heigth = y;
    }

    public int getArea() {
        return (width * heigth) / 2;
    }

}

class Circle extends Shape {
    Point position;
    int width;

    public Circle(int x) {
        this.width = x;
    }

    public int getArea() {
        return (int) ((width * width) / 3.14);
    }

}


