package oop.oop11;

public class OuterClass {
    String outerField = "외부 멤버 변수";
    static String staticOuterField = "외부 클래스 변수";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            // outer class의 인스턴스의 변수에 접근할 수 있따
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // System.out.println(outerField); // 컴파일 오류
            // 이 부분이 핵심
            //
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        // inner class를 생성하려면 outer class의 객체가 있어야한다
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);
    }
}