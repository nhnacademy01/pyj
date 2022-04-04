import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {

    public static void main(String[] args) throws IOException {
        PropertiesEx propertiesEx = new PropertiesEx();
        propertiesEx.propertiesTest();
        propertiesEx.readProperties();
    }

    private void propertiesTest() throws IOException {
        Properties card = new Properties();
        card.setProperty("name", "Comtin");
        card.setProperty("company", "NHN");
        card.setProperty("org", "Dooray");
        card.setProperty("tel", "031-8038-1234");

        System.out.println(card);

        FileOutputStream out = new FileOutputStream("card.properties");
        card.store(out, "Card");
    }

    private void readProperties() throws IOException{
        FileInputStream input = new FileInputStream("card.properties");
        Properties card = new Properties();
        card.load(input);

        System.out.println(card);
        System.out.println(card.getProperty("name"));
        System.out.println(card.getProperty("mobile"));
    }

}
