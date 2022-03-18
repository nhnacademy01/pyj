import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toMap;

public class StreamEx {
    public static void main(String[] args) throws IOException {
        StreamEx streamEx = new StreamEx();
//        streamEx.streamReadOnly();
//        streamEx.match();
//        streamEx.join(); // collect()
//        streamEx.streamCount();
//        streamEx.terminate();
//        streamEx.reduce();
//        streamEx.flatMap();
//        streamEx.test1();
//        streamEx.test2();
        streamEx.fileLine();
    }


    private void streamReadOnly() {
        List<String> strs = new ArrayList<>();
        strs.add("Welcome");
        strs.add("NHN");
        strs.add("Academy");

        List<String> sortedStrs = strs.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER) // comparator
                .collect(Collectors.toList());
        System.out.println("strs: " + strs);
        System.out.println("sortedStrs: " + sortedStrs);
        // 스트림으로 할 때는 읽기만해서 부수효과를 주지 않음(원본은 안변함)

        strs.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("After strs.sort: " + strs);
        // sort는 부수효과를 줌
    }

    private void streamDoItOnce() {

    }

    private void match() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");

        boolean anyMatch = strs.stream()
                .anyMatch((value) -> value.startsWith("NHN"));
        System.out.println(anyMatch);

        boolean allMatch = strs.stream()
                .allMatch((value) -> value.length() > 4);
        System.out.println(allMatch);
        // noneMatch
        boolean noneMatch = strs.stream()
                .allMatch(isEqual("Student"));
        System.out.println(noneMatch);
    }


    private void join() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // list
        List<String> list = strs.stream()
                .collect(Collectors.toList());
        // 리스트로
        System.out.println(list);
        // set
        Set<String> set = strs.stream()
                .collect(Collectors.toSet());
        // set으로
        //    .collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
        // map
        Map<String, Integer> map = strs.stream()
                .distinct() // 이것을 빼면 어떻게 될까?
                // map의 key는 중복이 안되기 때문에 distinct() 사용
                .collect(toMap(s -> s, s -> s.length())); // <문자열 자체 , 문자열 길이>
        //      .collect(toMap(Function.identity(), String::length));
        System.out.println(map);
        // joining
        String message = strs.stream()
                .distinct()
                .collect(Collectors.joining(" ", "", "!"));
        // 문자열로 joining 하는 중
        // 여러개의 문자열을 joining 하는 것도 가능
        //      .collect(Collectors.joining(" "));  // only delimiter
        System.out.println(message);
    }

    private void streamCount() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        // count
        long count = strs.stream()
                .count();
        System.out.println("count: " + count);
        // min
        String min = strs.stream()
                .min(Comparator.comparing(String::length))
                .orElse(null); // 값이 없으면 null 출력해라
        // 문자열 중 가장 짧은 애를 뽑는다
        System.out.println("min: " + min);
        // max
        String max = strs.stream()
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElseThrow(() -> new RuntimeException("Not exists max"));
        // 만약 값이 없으면 runtime exception 발생할거임
        System.out.println("max: " + max);
        // 알파벳 역순으로 ??? 뭐지
    }

    private void terminate() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // finaAny
        String anyLength3 = strs.stream()
                .filter(s -> s.length() == 3)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not found exception"));
        // 문자열이 3개인거 아무거나 찾아라
        // 병렬처리에서는 findAny가 더 좋다
        System.out.println("findAny: " + anyLength3);
        // findFirst
        String firstLength3 = strs.stream()
                .filter(s -> s.length() == 3)
                .findFirst()
                .orElse(null);
        // 첫번째꺼를 찾아줘줘        System.out.println("findFirst: " + firstLength3);
    }

    private void reduce() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy", "Academy");
        String concat = strs.stream()
                .distinct()
                .reduce((result, element) -> result + " " + element)
                .orElse("");
        // 누산연산 (연속 join에 가깝다)
        System.out.println("concat: " + concat);

        int specialStrLength = strs.stream()
                .filter(s -> s.length() > 3)
                .map(String::length)
                .reduce(0, Integer::sum);
        // "WelcomeAcademyAcademy".length = 21
        // 누산 연산
        System.out.println("specialStrLength: " + specialStrLength);

        int specialStrLength2 = strs.stream()
                .filter(s -> s.length() > 3)
                .mapToInt(String::length)
                .sum();

        // autoboxing unboxing은 연산이 커져서
        // 단순 계산일 때는 이렇게 사용하는게 낫다
        System.out.println("specialStrLength: " + specialStrLength);
    }

    private void flat() {
        List<String> strs = List.of("Welcome", "NHN", "Academy!", "Jordan.");
        strs.stream()
                .filter(s -> s.length() > 3)
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                .map(String::toLowerCase)
                .skip(1)
                .limit(3)
                .flatMapToInt(String::chars)
                //flatMapToInt 를 해서 j o r d a n 이런식으로 나올 수 있는 것
                .forEach(c -> System.out.println((char) c));
    }

    private void flatMap() {
        String[][] strs = new String[][]{
                {"Welcome", "NHN", "Academy!"},
                {"I", "AM", "GUNG-YEAH"},
                {"WHO", "IS", "DOING", "COL-LOK?"}
        };

        // Stream<List<String>> -flatMap -> Stream<String>
        // Stream<Stream<String>> -flatMap -> Stream<String>

        Stream.of(strs)
                // Stream은 해당 배열을 받아서 스트림으로 바꿔주는 것
                .peek(a -> System.out.println(Arrays.toString(a)))
                .flatMap(Stream::of)
                // flatMap 이차원 배열을 풀어서 펼치는 것
                .forEach(System.out::println);

        Stream.of(strs)
                // Stream은 해당 배열을 받아서 스트림으로 바꿔주는 것
                .peek(a -> System.out.println(Arrays.toString(a)))
                .map(Stream::of)
                .forEach(System.out::println);

    }

    private void test1() {
        /*
        문제
        아래 내용을 바탕으로 하나의 함수로 합성한 후 결과를 출력하세요.

        순번	서술	input	output
        1.	영어 문자열을 입력 받는다.	String
        2.	문자열을 대문자로 변환한다	String	String
        3.	문자열을 문자배열(char[])로 변환한다	String	char[]
        4.	문자들의 모든 아스키 코드 총 합을 구한다:	char[]	long
        4-1.	ㄴ 문자들를 아스키코드로 변환한다.	char[]	int[](IntStream)
        4-2.	ㄴ 아스키코드의 합을 구한다.	int[]	long
         */

        List<String> message = List.of("HELLO", "ZITO", "HI", "ZITO2");

        int sum = message.stream()
                .map(String::toUpperCase)
                .flatMapToInt((String::chars)) // 이 줄로 3~4.1 줄 한번에 한 것
                .peek(c -> System.out.print(c + " + ")) //한자씩 출력할 때
                .sum();

        System.out.println("sum = " + sum);


    }

    private void test2() {
        int sum = IntStream.rangeClosed(1, 100)
                .filter(num -> num % 2 != 0)
                .sum();

        System.out.println(sum);
    }

    private void concat() {
        List<String> strs1 = List.of("Jordan", "Dongmyo", "Manty");
        List<String> strs2 = List.of("Marco", "Coco", "Comtin");

        // 스트림 연결
        Stream.concat(strs1.stream(), strs2.stream())
                .forEach(System.out::println);
    }

    private void fileLine() throws IOException {
        Path path = Paths.get("C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\JAVA\\2022-03-18\\src");
        Stream<Path> fileStream = Files.list(path);

        // fileStream.flatMap(StreamEx.getLines::getLines()) // static 메서드인 경우 >{ClassName}::getLines()
        fileStream.flatMap(this::getLines) // static이 아닌 경우
                .forEach(System.out::println);
    }

    private Stream<String> getLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            return Stream.empty();
        }
    }


}
