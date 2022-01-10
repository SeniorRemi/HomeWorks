public interface AuthenticationService {
    void start();
    void stop();

    String getNickNameLoginPassword(String login, String password);



}