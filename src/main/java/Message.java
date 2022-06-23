public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getStringCommand() {
        return "M:" + content;
    }
}
