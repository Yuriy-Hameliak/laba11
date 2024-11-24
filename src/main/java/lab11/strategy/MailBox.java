package lab11.strategy;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.ArrayList;

public class MailBox {
    private final ArrayList<MailInfo> infos = new ArrayList<>();
    private final ArrayList<Client> users = new ArrayList<>();
    private final MailSender mailSender;

    public MailBox(MailjetClient client) {
        this.mailSender = new MailSender(client);
    }

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void addClient(Client user) {
        users.add(user);
    }

    public void sendAll() {
        for (Client user : users) {
            for (MailInfo info : infos) {
                try {
                    mailSender.send(user, info);
                } catch (MailjetException | MailjetSocketTimeoutException ex) {
                    System.out.println("Mail not sent to: " + user.getEmail());
                    ex.printStackTrace();
                }
            }
        }
    }
}
