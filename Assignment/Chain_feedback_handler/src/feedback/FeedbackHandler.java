package feedback;

public abstract class FeedbackHandler {
    protected FeedbackHandler next;

    public FeedbackHandler setNext(FeedbackHandler next) {
        this.next = next;
        return next;
    }

    public void handle(FeedbackMessage msg) {
        if (canHandle(msg)) {
            process(msg);
        } else if (next != null) {
            next.handle(msg);
        } else {
            System.out.println("[NoHandler] No handler found for: " + msg.getType());
        }
    }

    protected abstract boolean canHandle(FeedbackMessage msg);
    protected abstract void process(FeedbackMessage msg);
}