package Client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pPanel extends JPanel {

    JTextArea messageField;
//    JTextArea messageField;
    JTextField login;
    JTextField pass;
    JTextField sendMessage;
    JTextField adminNameUser;
    JTextField adminCommand;
    JComboBox comboBoxAllChatRoomName;

    Button btnLogin;
    Button btnSend;
    Button btnCreateNewChat;
    Button btnExecuteCommandAdmin;

    public pPanel(){

        setLayout(null);

        messageField = new JTextArea("");
        messageField.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(messageField);
        jScrollPane.setBounds(200,10,400,480);
        add(jScrollPane);

        sendMessage = new JTextField();
        sendMessage.setBounds(200,510,400,30);
        btnSend = new Button("Send");
        btnSend.setBounds(610,510,50,30);
        add(btnSend);
//        btnSend.addActionListener(lb.btnListenerSend);
        add(sendMessage);

        login = new JTextField("user 1");
        JLabel textLogin = new JLabel("login");
        textLogin.setBounds(10,5,50,20);
        add(textLogin);
        login.setBounds(10,25,70,30);
        add(login);

        pass = new JTextField();
        JLabel textPass = new JLabel("password");
        textPass.setBounds(85,5,80,20);
        add(textPass);
        pass.setBounds(85,25,70,30);
        add(pass);

        btnLogin = new Button("login");
        btnLogin.setBounds(50,70,70,20);
        add(btnLogin);
//        btnLogin.addActionListener(listenerButton.btnListenerLogin);

        adminNameUser = new JTextField();
        JLabel textAdminUserName = new JLabel("nick user:");
        textAdminUserName.setBounds(10,170,70,30);
        add(textAdminUserName);
        adminNameUser.setBounds(10,200,150,30);
        add(adminNameUser);

        adminCommand = new JTextField();
        JLabel textAdminCommand = new JLabel("command admin:");
        textAdminCommand.setBounds(10,230,100,30);
        add(textAdminCommand);
        adminCommand.setBounds(10,260,150,30);
        add(adminCommand);

        btnExecuteCommandAdmin = new Button("execute command");
        btnExecuteCommandAdmin.setBounds(20,300,120,20);
//        btnExecuteCommandAdmin.addActionListener(listenerButton.exComAd);
        add(btnExecuteCommandAdmin);

        String [] items = {"--Выберите чат--", "chat 1", "chat 2", "chat 3"};

        comboBoxAllChatRoomName = new JComboBox(items);
        comboBoxAllChatRoomName.setBounds(610,10,150,30);
//        comboBoxAllChatRoomName.addActionListener(listenerButton.comboBox);
        add( comboBoxAllChatRoomName );

        btnCreateNewChat = new Button("create new chat");
        btnCreateNewChat.setBounds(610,50,150,30);
//        btnCreateNewChat.addActionListener(listenerButton.btnListenerCreate);
        add(btnCreateNewChat);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setBackground(Color.LIGHT_GRAY);
        setBounds(10,10,765,545);


    }
}
