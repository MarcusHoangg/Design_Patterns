package feedback;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(FeedbackMessage msg) {
        return msg.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void process(FeedbackMessage msg) {
        System.out.println("[GeneralFeedback] Thank you, " + msg.getSenderEmail() + "!");
        System.out.println("[GeneralFeedback] We appreciate your feedback.");
        System.out.println("[GeneralFeedback] Content: " + msg.getContent());
    }
}