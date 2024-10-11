import java.time.LocalDateTime;

public class Sms {
    String senderno;
    String recieverno;
    String Text;
    String messageid;
    LocalDateTime time;
    public Sms(String senderno, String recieverno, String text, String messageid, LocalDateTime time) {
        this.senderno = senderno;
        this.recieverno = recieverno;
        Text = text;
        this.messageid = messageid;
        this.time = time;
    }

    public String getSenderno() {
        return senderno;
    }

    public void setSenderno(String senderno) {
        this.senderno = senderno;
    }

    public String getRecieverno() {
        return recieverno;
    }

    public void setRecieverno(String recieverno) {
        this.recieverno = recieverno;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }
    @Override
    public String toString(){
        return String.format("senderno :%s    Recieverno:%s   MessageID:%s   Text:%s   Sent at:%s",senderno,recieverno,messageid,Text,LocalDateTime.now());
    }

}
