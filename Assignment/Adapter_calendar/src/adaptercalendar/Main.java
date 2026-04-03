package adaptercalendar;

public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        // set date
        date.setDay(10);
        date.setMonth(4);
        date.setYear(2026);

        System.out.println("Original date:");
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        // advance 5 days
        date.advanceDays(5);

        System.out.println("\nAfter advancing 5 days:");
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}