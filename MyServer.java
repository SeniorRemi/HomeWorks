

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {



    private static final Integer PORT = 8888;
    private static final String ADDR = "127.0.0.1";


    private AuthenticationService authenticationService;
    private List<ClientHandler> handlerList;

    public MyServer() {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            authenticationService = new AuthenticationServiceImpl();
            authenticationService.start();
            handlerList = new ArrayList<>();
            while (true) {
                System.out.println("Server is waiting for connection....");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            authenticationService.stop();
        }
    }

    public synchronized boolean nickIsBusy(String nickName) {
        return handlerList
                .stream().
                anyMatch(clientHandler -> clientHandler.getNickName().equalsIgnoreCase(nickName));
    }

    public synchronized void sendMassageToClients(String massage) {
        handlerList.forEach(clientHandler -> clientHandler.sendMassage(massage));
    }


    public synchronized void subscribe(ClientHandler clientHandler) {
        handlerList.add(clientHandler);
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        handlerList.remove(clientHandler);
    }

    public AuthenticationService getAuthenticationService() {
        return this.authenticationService;
    }

    public synchronized void privBroadcastMessage(String message, String privName, String otpravitel) {
        for (ClientHandler cl : handlerList) {
            if (cl.getNickName().equals(privName)) {
                for (ClientHandler cl1 : handlerList) {
                    if (cl1.getNickName().equals(otpravitel)) {
                        cl.sendMassage(message);
                        cl1.sendMassage("Вы отправили личное сообщение для " + privName);
                        return;
                    }
                }
            }
        }
        for (ClientHandler cl : handlerList) {
            System.out.println("Пользователь не найден.");
            if (cl.getNickName().equals(otpravitel)) {
                cl.sendMassage("Такого пользователя не существует.");
                return;
            }
        }
    }

    public void privBroadcastMessage(String s) {
    }
}