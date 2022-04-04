import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Study study = new Study();
        study.doItStudy();

        Mogakko mogakko = new Mogakko();
        Mogakko mogakko1 = (Mogakko) new Study();
        mogakko.doItStudy();

        // 다이나믹 메소드 디스패치
        // : 컴파일 할 때 말고 runtime시에 upcasting된
        //   자식 클래스의 오버라이딩 된 메소드 호출
        Study study1 = new Mogakko();
        study1.doItStudy();


//        mogakko.attack();

        System.out.println();

        // 더 나아가면
        ArrayList<Study> arrayList = new ArrayList<>();
        arrayList.add(study);
        arrayList.add(mogakko);
        arrayList.add(study1);

        for(Study s: arrayList){
            s.doItStudy();
        }

    }
}
