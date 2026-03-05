package feedback;

public class Main {
    public static void main(String[] args) {

        // build chain: Compensation -> Contact -> DevSuggestion -> General
        FeedbackHandler h1 = new CompensationHandler();
        FeedbackHandler h2 = new ContactRequestHandler();
        FeedbackHandler h3 = new DevSuggestionHandler();
        FeedbackHandler h4 = new GeneralFeedbackHandler();

        h1.setNext(h2).setNext(h3).setNext(h4);

        FeedbackMessage[] messages = new FeedbackMessage[] {
                new FeedbackMessage(
                        MessageType.COMPENSATION_CLAIM,
                        "I want compensation. Here is my invoice #12345.",
                        "alice@gmail.com"
                ),
                new FeedbackMessage(
                        MessageType.COMPENSATION_CLAIM,
                        "My package arrived damaged. Please refund me.",
                        "bob@gmail.com"
                ),
                new FeedbackMessage(
                        MessageType.CONTACT_REQUEST,
                        "Can someone call me tomorrow afternoon?",
                        "marcus@school.com"
                ),
                new FeedbackMessage(
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "Please add dark mode. Also improve performance.",
                        "devfan@demo.com"
                ),
                new FeedbackMessage(
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "The app has a crash bug on login (security issue).",
                        "tester@demo.com"
                ),
                new FeedbackMessage(
                        MessageType.GENERAL_FEEDBACK,
                        "Overall great service, keep it up!",
                        "happy@demo.com"
                )
        };

        for (FeedbackMessage msg : messages) {
            System.out.println("\n--- New message ---");
            System.out.println(msg);
            h1.handle(msg);
        }
    }
}