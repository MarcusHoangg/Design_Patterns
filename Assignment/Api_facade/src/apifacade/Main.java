package apifacade;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            System.out.println("=== Chuck Norris API ===");

            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println("Joke: " + joke);

            System.out.println("\n=== Exchange Rate API ===");

            String base = facade.getAttributeValueFromJson(
                    "https://api.frankfurter.app/latest",
                    "base"
            );

            String date = facade.getAttributeValueFromJson(
                    "https://api.frankfurter.app/latest",
                    "date"
            );

            System.out.println("Base currency: " + base);
            System.out.println("Date: " + date);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}