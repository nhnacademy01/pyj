import java.text.ChoiceFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ChoiceFormatEx {
    public static void main(String[] args) {
        ChoiceFormatEx choiceFormatEx = new ChoiceFormatEx();
//        choiceFormatEx.ChoiceFormat();

//        choiceFormatEx.DateFormat();

//        choiceFormatEx.JodaTime();

//        choiceFormatEx.MinusMinute();

//        choiceFormatEx.DateChangeToTime();

//        choiceFormatEx.ParsingAndFormatting();

//        choiceFormatEx.SimpleDateFormatEx();

        choiceFormatEx.SimpleDataFormatParsing();
    }

    private void ChoiceFormat() {
        double[] calendar = new double[]{1, 3, 6, 9, 12};

        String[] month = {"겨울 ", "봄", "여름", "가을", "겨울"};

        ChoiceFormat choiceFormat = new ChoiceFormat(calendar, month);

        for (int i = 1; i <= 12; i++) {
            System.out.printf("%d월의 계절은 %s%n", i, choiceFormat.format(i));
        }
    }

    private void DateFormat() {
        Date date = new Date();

        System.out.println("date: " + date);
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("date: " + date.getDate());
        System.out.println("dayOfWeek: " + date.getDay());
        System.out.println("hours: " + date.getHours());
        System.out.println("minutes: " + date.getMinutes());
        System.out.println("seconds: " + date.getSeconds());

        System.out.println("date.after(new Date()): " + date.after(new Date()));
        System.out.println("date.before(new Date()): " + date.before(new Date()));
        System.out.println("date.getTime(): " + date.getTime());
        System.out.println("date.compareTo(new Date()): " + date.compareTo(new Date())); // Comparable
    }

    private void JodaTime() {
        LocalDate nowDate = LocalDate.now();
        LocalDateTime nowDateTime = nowDate.atStartOfDay();
        LocalDateTime dt1 = nowDate.atTime(1, 2, 3);
        LocalDate dt2 = nowDate.plus(1, ChronoUnit.DAYS);
        // LocalDate dt3 = nowDate.plus(1, ChronoUnit.HOURS);   // 어떻게 될까요?

        System.out.println(nowDate);
        System.out.println(nowDateTime);
        System.out.println(dt1);
        System.out.println(dt2);
    }

    private void MinusMinute() {
        LocalDateTime dt = LocalDateTime.now();

        // 1초를 더하는 여러가지 방법
        LocalDateTime dt2 = dt.plus(1L, ChronoUnit.SECONDS);
        LocalDateTime dt3 = dt.plusSeconds(1L);
        LocalDateTime dt4 = dt.plus(Duration.ofSeconds(1));

        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);

        // 1초를 빼는 여러가지 방법
        System.out.println("1초를 빼는 여러가지 방법");
        System.out.println(dt);
        LocalDateTime dt5 = dt.minus(1L, ChronoUnit.SECONDS);
        System.out.println(dt5);

        LocalDateTime dt6 = dt.minusSeconds(1L);
        System.out.println(dt6);

        LocalDateTime dt7 = dt.minus(Duration.ofSeconds(1));
        System.out.println(dt7);

    }

    private void DateChangeToTime() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        LocalDateTime dt1 = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        OffsetDateTime odt1 = OffsetDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());

        System.out.println("date :" + date + " /date.timeZoneOffSet: " + date.getTimezoneOffset());
        System.out.println("Calendar: " + cal.getTime() + " /cal.getTimeZone: " + cal.getTimeZone().getID());
        System.out.println(dt1);
        System.out.println(odt1);
        System.out.println(zdt1);
    }

    private void ParsingAndFormatting() {
        String input = "1980-01-01 16:16:16";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(input, formatter);
        System.out.println(date);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String output = date.format(format);
        System.out.println(output);
    }

    private void SimpleDateFormatEx() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
        System.out.println(format.format(cal.getTime()));
    }

    private void SimpleDataFormatParsing() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String input = "1980-01-01 16:16:16";
        // 입력된 문자열이 패턴과 일치할 수 잇께
        // 양방향적으로 만족해야함
        try {
            Date date = format.parse(input);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
