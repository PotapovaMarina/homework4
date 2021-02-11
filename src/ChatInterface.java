import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatInterface extends JFrame {
    private List<String> history = new ArrayList<>();

    public ChatInterface() {
        this.setTitle("Chat");
        this.setBounds(450, 150, 600, 500);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setText(getHistory());
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(550, 400));
        JPanel messagePanel = new JPanel();
        //messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //messagePanel.setPreferredSize(new Dimension(560, 150));
        //messagePanel.setBackground(Color.white);
        JTextField messageText = new JTextField();
        messageText.setPreferredSize(new Dimension(450, 25));
        JButton sendButton = new JButton("Отправить");
        messageText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!messageText.getText().equals("")) {
                    saveHistory(messageText.getText());
                    chatArea.setText(getHistory());
                    messageText.setText("");
                }
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!messageText.getText().equals("")) {
                    saveHistory(messageText.getText());
                    chatArea.setText(getHistory());
                    messageText.setText("");
                }
            }
        });
        messagePanel.add(messageText);
        messagePanel.add(sendButton);
        this.add(scroll);
        this.add(messagePanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ChatInterface();
    }

    public void saveHistory(String chatMessage) {
        history.add(chatMessage + " " + LocalDateTime.now());
        }

    public String getHistory(){
        return history.stream().collect(Collectors.joining("\n"));
    }

}
