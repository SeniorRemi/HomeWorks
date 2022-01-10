import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EhoServer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server waiting for connection... ");
            socket = serverSocket.accept(); //Мы ждем подключения. [БЛОКИРУЕМСЯ]
            System.out.println("Client connected ");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Thread messageFromServer = new Thread(() -> {

                while (true) {
                    System.out.println("Write the message for client: ");
                    String message = sc.nextLine();
                    if (message.equals("/end")) {
                        break;
                    }
                    try {
                        dataOutputStream.writeUTF("Server's message: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
            messageFromServer.setDaemon(true);
            messageFromServer.start();

            while (true) {
                String message = dataInputStream.readUTF();
                //poison pill
                if (message.equals("/end")) {
                    dataOutputStream.writeUTF(message);
                    break;
                }

                System.out.println("Client sent " + message);
                dataOutputStream.writeUTF("Echo: " + message);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}