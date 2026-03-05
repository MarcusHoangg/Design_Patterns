package feedback;

public class DevSuggestionHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(FeedbackMessage msg) {
        return msg.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void process(FeedbackMessage msg) {
        System.out.println("[DevSuggestion] Logged suggestion from " + msg.getSenderEmail());

        // demo prioritization
        String c = msg.getContent().toLowerCase();
        if (c.contains("security") || c.contains("crash") || c.contains("bug")) {
            System.out.println("[DevSuggestion] Priority: HIGH");
        } else {
            System.out.println("[DevSuggestion] Priority: NORMAL");
        }

        System.out.println("[DevSuggestion] Suggestion: " + msg.getContent());
    }
}