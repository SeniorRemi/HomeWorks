import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



    public class EchoClient2 extends JFrame {
        private final int SERVER_PORT = 8888;
        private final String SERVER_ADDR = "127.0.0.1";


        private JTextField msgInputField;
        private JTextArea chatArea;
        private Socket socket;

        private DataInputStream dis;
        private DataOutputStream dos;

        public EchoClient2() {
            try {
                openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            prepareGUI();
        }

        public void openConnection() throws IOException {
            String SERVER_ADDR = "127.0.0.1";
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(() -> {

                try {
                    while (true) {
                        String massage = dis.readUTF();
                        if (massage.startsWith("/start")) {
                            chatArea.append(massage + "/n");
                            break;
                        }
                        chatArea.append(massage + "/n");
                    }
                    while (true) {
                        String strFromServer = dis.readUTF();
                        if (strFromServer.equalsIgnoreCase("/finish")) {
                            closeConnection();
                            break;
                        }

                        chatArea.append(strFromServer + "\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, " Server connection error ");
                }

            });
            thread.setDaemon(true);
            thread.start();
        }

        public void closeConnection() {
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

        public void sendMessage() {
            String mgs = msgInputField.getText();
            if (mgs != null && !mgs.trim().isEmpty()) {
                try {
                    dos.writeUTF(msgInputField.getText());
                    msgInputField.setText("");
                    msgInputField.grabFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error sending message ");
                }
            }
        }

        public void prepareGUI() {
            // Параметры окна
            setBounds(600, 300, 500, 500);
            setTitle("Client");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // Текстовое поле для вывода сообщений
            chatArea = new JTextArea();
            chatArea.setEditable(false);
            chatArea.setLineWrap(true);
            add(new JScrollPane(chatArea), BorderLayout.CENTER);

            // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
            JPanel bottomPanel = new JPanel(new BorderLayout());
            JButton btnSendMsg = new JButton("Send");
            bottomPanel.add(btnSendMsg, BorderLayout.EAST);
            msgInputField = new JTextField();
            add(bottomPanel, BorderLayout.SOUTH);
            bottomPanel.add(msgInputField, BorderLayout.CENTER);
            btnSendMsg.addActionListener(new ActionListener() {





                @Override
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            });
            msgInputField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            });

            // Настраиваем действие на закрытие окна
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    try {
                        dos.writeUTF("/Finish");
                        closeConnection();
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                }
            });

            setVisible(true);
        }

        public static void main(String[] args) {
            try {
                new EchoClient();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private static class EchoClient {
        }
    }