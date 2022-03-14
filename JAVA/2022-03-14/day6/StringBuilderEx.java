package day6;

public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder title = new StringBuilder();

        String[] source = new String[]{
                "welcome", "to", "nhn", "acacdemy.", "you",
                "are", "learining", "java", "now."
        };

        for (String str : source) {
            if (str.equals("nhn") || str.equals("java")) {
                title.append(str.toUpperCase().concat(" "));
            } else if (str.lastIndexOf(".") == str.length() - 1) {
                title.append(str.concat("\n"));
            } else {
                title.append(str.concat(" "));

            }
        }

        System.out.println(title);


    }

}
