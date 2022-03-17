//import java.lang.annotation.Inherited;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import static java.lang.annotation.ElementType.TYPE;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//// @Legacy 존재하지 않지만 존재한다고 인식
//public class Child extends Parent {
//    public static void main(String[] args) {
//        System.out.println("Parent has @Legacy?: " + hasLegacy(Parent.class));
//        System.out.println("Child has @Legacy?: " + hasLegacy(Child.class));
//
//        System.out.println("Parent has @Hobby?: " + hasHobby(Parent.class));
//        System.out.println("Child has @Hobby?: " + hasHobby(Child.class));
//    }
//    // ...
//}
//
//@Inherited
//@Target(TYPE)
//@Retention(RUNTIME)
//@interface Legacy {
//}
//
//@Target(TYPE)
//@Retention(RUNTIME)
//@interface Hobby {
//}
//
//@Hobby
//@Legacy
//class Parent {
//}