import java.util.Objects;

public class ObjectsEx {
    public static void main(String[] args) {

        System.out.println("equals(\"Name\", \"Name\"): " + Objects.equals("Name", "Name"));
        System.out.println("equals(null, \"Name\"): " + Objects.equals(null, "Name"));
        System.out.println("equals(1L, \"Name\"): " + Objects.equals(1L, "Name"));

        String[] arr1 = new String[]{"NHN", "ACADEMY"};
        String[] arr2 = new String[]{"NHN", "ACADEMY"};
        String[] arr3 = new String[]{"NHN", null};
        System.out.println("deepEquals(arr1, arr2): " + Objects.deepEquals(arr1, arr2));
        System.out.println("deepEquals(arr1, arr3): " + Objects.deepEquals(arr1, arr3));

        System.out.println("hashCode(\"NHN\"): " + Objects.hashCode("NHN"));

        System.out.println("toString(new Exception()): " + Objects.toString(new Exception()));
        System.out.println("toString(null, \"default\"): " + Objects.toString(null, "default"));
        String NHN = "NHN", nhn = "nhn", ACADEMY = "ACADEMY";   // 대소문자 무시 비교
        System.out.println(Objects.compare(NHN, ACADEMY, String.CASE_INSENSITIVE_ORDER));
        System.out.println(Objects.compare(NHN, nhn, String.CASE_INSENSITIVE_ORDER));
        System.out.println(Objects.compare(ACADEMY, nhn, String.CASE_INSENSITIVE_ORDER));

        System.out.println("requireNonNull(\"NHN\")): " + Objects.requireNonNull("NHN"));
        // System.out.println("requireNonNull(null): " + Objects.requireNonNull(null, "invalid object !!!")); // 예외 발생
        System.out.println("isNull(null): " + Objects.isNull(null));
        System.out.println("isNull(true): " + Objects.isNull(true));

        System.out.println("nonNull(null): " + Objects.nonNull(null));
        System.out.println("nonNull(false): " + Objects.nonNull(false));
    }
}