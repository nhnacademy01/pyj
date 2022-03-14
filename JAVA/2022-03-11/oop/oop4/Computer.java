package oop.oop4;

import jdk.swing.interop.SwingInterOpUtils;

public class Computer {

    public static void main(String[] args) {
        Cd cd = new Cd("CD1");
        Dvd dvd = new Dvd("DVD1");
        Computer computer = new Computer();

        computer.play(cd);
        computer.play(dvd);
    }

    DvdDrive dvdDrive = new DvdDrive(); // 인스턴스화 된 dvdDrive
    // 합성 (컴퓨터는 dvd Drive를 가지고 있다)

    void play(Dvd dvd) {
        dvdDrive.play(dvd); // 위임
    }

    void play(Cd cd) {
        dvdDrive.play(cd);
    }
}

class DvdDrive extends CdDrive { // 상속
    void play(Dvd dvd) {
        System.out.println(dvd.dvdName+"플레이");
    }
}

class CdDrive {
    void play(Cd cd) {
        System.out.println(cd.cdName+"플레이");
    }
}

class Cd{
    String cdName;

    public Cd(String cdName){
        this.cdName = cdName;
    }
}

class Dvd{
    String dvdName;

    public Dvd(String dvdName){
        this.dvdName = dvdName;
    }
}
