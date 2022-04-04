package day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Pp {
    public static void main(String[] args) throws IOException {
        Pp pp = new Pp();
        pp.store();
        pp.load();
    }
    private void load() throws IOException {
        FileInputStream input = new FileInputStream("card.properties");
        Properties card = new Properties();
        card.load(input);
        System.out.println(card);
        System.out.println(card.getProperty("name"));
        System.out.println(card.getProperty("mobile"));
    }
    private void store() throws IOException {
        Properties card = new Properties();
        card.setProperty("name", "이경환");
        card.setProperty("company", "NHN");
        card.setProperty("org", "Dooray");
        card.setProperty("tel", "031-8038-1234");

        System.out.println(card);
        FileOutputStream out = new FileOutputStream("card.properties");
        card.store(out, "card store");
    }
}
