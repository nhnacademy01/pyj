public class Mogakko extends Study implements Takable, Attackablt{
    // Mogakko 클래스는 Study 클래스를 상속받았다

    // 메소드 오버라이딩
    public void doItStudy(){
        // 부모에 있는 메소드를 자식에서 다시 재정의 하는 것
        System.out.println("모각코 공부합시다");
    }

    @Override
    public void attack() {
        toString();
    }
}
