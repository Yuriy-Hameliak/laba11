package lab11.strategy;

@FunctionalInterface
public interface MailCode {
    String generate(Client client);
}
