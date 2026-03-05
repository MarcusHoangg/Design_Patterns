package feedback;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(FeedbackMessage msg) {
        return msg.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void process(FeedbackMessage msg) {
        System.out.println("[Contact] Forwarding contact request from " + msg.getSenderEmail());
        System.out.println("[Contact] Message: " + msg.getContent());
        System.out.println("[Contact] Assigned to Customer Support.");
    }
}