

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String nickName;


    public ClientHandler(MyServer myServer, Socket socket) {
        try {


            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {


                    authentication();
                    receiveMassage();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    closeConnection();
                }

            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // проверка аунтификации
    public void authentication() throws Exception {
        while (true) {
            String massage = dis.readUTF();
            if (massage.startsWith("/start")) {
                String[] arr = massage.split("-", 3);
                if (arr.length != 3) {
                    throw new IllegalArgumentException();
                }

                final String nick = myServer.
                        getAuthenticationService().
                        getNickNameLoginPassword(arr[1].trim(), arr[2].trim());
                if (nick != null) {
                    if (!myServer.nickIsBusy(nick)) {
                        sendMassage("/start " + nick);
                        this.nickName = nick;
                        myServer.sendMassageToClients(nickName + " Connected to the chat!");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMassage("Nick used from another!");
                    }
                } else {
                    sendMassage("Wrong login or password!");
                }

            }

        }

    }

    public void sendMassage(String massage) {
        try {
            dos.writeUTF(massage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void receiveMassage() throws IOException {
        while (true) {
            String massage = dis.readUTF();
            if (massage.startsWith("/finish")) {
                myServer.sendMassageToClients(nickName + " Went out from chat");
                return;
            }
            myServer.sendMassageToClients(nickName + ": - " + massage);

        }
    }

        public String getNickName () {
            return nickName;
        }
        private void closeConnection() {
        myServer.unSubscribe(this);
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static final String PRIVATE_MESSAGE = "/w";
    public static final String END_COMMAND = " /end";
    private void readMessage () throws IOException {

        while (true) {

            String[] privMessToken;
            String privName = null;
            String token = "";

            String messageFromClient = dis.readUTF();

            if (messageFromClient.startsWith(PRIVATE_MESSAGE)) {
                privMessToken = messageFromClient.split("\\s+");
                token = privMessToken[0];
                privName = privMessToken[1];
                System.out.println(privName);
            }

            if (token.equals(PRIVATE_MESSAGE)) {
                myServer.privBroadcastMessage("Private message from " + nickName + ": " + messageFromClient, privName, nickName);
            } else {
                System.out.println("Message from " + nickName + " : " + messageFromClient);
                myServer.privBroadcastMessage(nickName + " " + messageFromClient);
            }

            if (messageFromClient.equals(END_COMMAND)) {
                break;
            }
        }
    }
    }