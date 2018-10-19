package Client;

import newChat.ClientRooms;
import newChat.MessageInUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ClientSocket {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 10000;

    private Scanner messageScanner;
    private BufferedReader messageBuffer1, messageBuffer2;
    private PrintWriter outPrintMes;

    private String inputConnsol = "";
    String nameChat = "";

    private String name = "";
    private String sms = "";
    private String chatName = "chat 1";
    private String inMes = "";
    private MessageInUser messageInUsers;

    ClientSocket(pPanel pPanel) {
        try {

            Socket clientSocket = new Socket(SERVER_HOST, SERVER_PORT);

            messageBuffer1 = new BufferedReader(new InputStreamReader(System.in));
            messageScanner = new Scanner(clientSocket.getInputStream());
            outPrintMes = new PrintWriter(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }


        pPanel.btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !pPanel.sendMessage.getText().trim().isEmpty() ) {
                    sms = pPanel.sendMessage.getText();
                    name = pPanel.login.getText();
                    messageInUsers = new MessageInUser(name,"0", sms,
                            chatName, System.currentTimeMillis(), false);
                    sendMsg(messageInUsers);
                    pPanel.sendMessage.grabFocus();
                }
            }
        });
        pPanel.sendMessage.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                pPanel.sendMessage.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        pPanel.comboBoxAllChatRoomName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pPanel.comboBoxAllChatRoomName = (JComboBox) e.getSource();
                String roomsName = (String) pPanel.comboBoxAllChatRoomName.getSelectedItem();
                if ( !roomsName.equals("") ){
                    chatName = roomsName;
                        pPanel.messageField.setText(roomsName + " - open");
                        sendMsg(new MessageInUser(null,null,
                                "downloadAllFromChat",chatName,
                                System.currentTimeMillis(),true));
                }
//                switch (roomsName){
//                    case "chat 1":
//                        chatName = "chat 1";
//                        pPanel.messageField.setText("chat 1 open");
//                        sendMsg(new MessageInUser(null,null,
//                                "downloadAllFromChat",chatName,
//                                System.currentTimeMillis(),true));
//                        break;
//                    case "chat 2":
//                        chatName = "chat 2";
//                        pPanel.messageField.setText("chat 2 open");
//                        sendMsg(new MessageInUser(null,null,
//                                "downloadAllFromChat",chatName,
//                                System.currentTimeMillis(),true));
//                        break;
//                    case "chat 3":
//                        chatName = "chat 3";
//                        pPanel.messageField.setText("chat 3 open");
//                        sendMsg(new MessageInUser(null,null,
//                                "downloadAllFromChat",chatName,
//                                System.currentTimeMillis(),true));
//                        break;
//                    default:
//                    break;
//                }
                System.out.println(chatName + " - chatName ");
            }

        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        inputConnsol = messageBuffer1.readLine();
                        sms = inputConnsol;
                        if (inputConnsol.equals("")) {
                        }
                        if ( inputConnsol.equals("end")){
                            outPrintMes.println("##session##end##");
                        }
                        else{
                            sendMsg(messageInUsers);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (messageScanner.hasNext()) {
                        inMes = messageScanner.nextLine();
                        pPanel.messageField.append( "\n" + inMes );
                    }
                }
            }
        }).start();
    }

    private void sendMsg(MessageInUser messageInUsers){
        outPrintMes.println(messageInUsers.toJson());
        outPrintMes.flush();
    }

//    private void createNewRoom(String nameRoom){
//        ClientRooms clientRooms = new ClientRooms(nameRoom);
//        System.out.println(clientRooms.toString() + " - C r e a t e N e w R o o m");
//        outPrintMes.println(clientRooms);
//        outPrintMes.flush();
//    }

}
