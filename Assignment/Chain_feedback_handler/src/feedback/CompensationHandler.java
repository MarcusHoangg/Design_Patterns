package feedback;

public class CompensationHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(FeedbackMessage msg) {
        return msg.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void process(FeedbackMessage msg) {
        System.out.println("[Compensation] Reviewing claim from " + msg.getSenderEmail());

        // demo logic: approve if message contains "invoice" or "receipt"
        String c = msg.getContent().toLowerCase();
        if (c.contains("invoice") || c.contains("receipt")) {
            System.out.println("[Compensation] Approved. We'll contact you with next steps.");
        } else {
            System.out.println("[Compensation] Rejected. Missing proof (invoice/receipt).");
        }
    }
}