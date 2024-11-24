package lab11.strategy;


import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Properties;
import lab11.strategy.Client;
import lombok.Data;
@Data
public class MailSender {
        private final MailjetClient client;

        public MailSender(MailjetClient client) {
        this.client = client;
        }

        public void send(Client user, MailInfo mailInfo) throws MailjetException, MailjetSocketTimeoutException{
        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "yurora.pn@ucu.edu.ua")
                                        .put("Name", "Yura"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", user.getEmail())
                                                .put("Name", user.getName())))
                                .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
                                .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
                                .put(Emailv31.Message.HTMLPART, mailInfo.generate())
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));

        MailjetResponse response = client.post(request);

        System.out.println(response.getStatus());
        System.out.println(response.getData());
        }
}