import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newWindow extends JFrame {
    public newWindow() {
        setTitle("Remi's Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 240, 620, 600);
        JPanel thePanel = new JPanel();
        add(thePanel);
        setLayout(null);

        JTextArea typeTextField = new JTextArea();
        typeTextField.setBounds(50, 400, 500, 100);
        add(typeTextField);


        JTextArea printTextField = new JTextArea();
        printTextField.setDisabledTextColor(Color.black);
        printTextField.disable();
        add(printTextField);


        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setBounds(430, 510, 120, 35);
        add(sendButton);
        setVisible(true);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = typeTextField.getText();
                String gt = printTextField.getText();
                String al = text + "\n" + gt;
                if (gt.isEmpty()) {
                    typeTextField.setText("You wrote : " + text);
                } else {
                    printTextField.setText("You wrote : " + al);

                }
            }
        });
    }

}
