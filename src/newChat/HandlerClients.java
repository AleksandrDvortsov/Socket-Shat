package newChat;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HandlerClients implements Runnable {

    Socket clientSocket;
    private Server server;
    private PrintWriter outPrintMes;
    private Scanner messageScanner;
    private MessageInUser messageInUsers;
    String nameRoom = "";


    public HandlerClients( Socket clientSocket, Server server) throws IOException {
        this.clientSocket = clientSocket;
        this.server = server;
        outPrintMes = new PrintWriter(clientSocket.getOutputStream());
        messageScanner = new Scanner(clientSocket.getInputStream());
    }

    @Override
    public void run() {

        while (true) {
            if (messageScanner.hasNext()) {
                System.out.println(messageScanner.nextLine() + " - messageScanner");
                System.out.println("-------------------------------------------------------------------");
                String clientMessage = messageScanner.nextLine();
                messageInUsers = new Gson().fromJson(clientMessage,MessageInUser.class);
                controler(messageInUsers);
            }
        }
    }

    public void sendMessage(String sms) {
        outPrintMes.println(sms);
        outPrintMes.flush();
    }

    public void controler(MessageInUser messageInUsers ){
        if ( !messageInUsers.isServiceMessage ){
            if ( server.hmRooms.size() == 0) {
                server.createRooms("chat 1");
                server.createRooms("chat 2");
                server.createRooms("chat 3");
            }
            nameRoom = messageInUsers.roomName;
            server.sendMessageToAllClients(messageInUsers.nameUser
                    + ": " + messageInUsers.message, messageInUsers);
        }
        if ( messageInUsers.message.equals("downloadAllFromChat")) {
          downloadAllMessageFromChat();
        }
    }

    private void downloadAllMessageFromChat(){
        if ( messageInUsers.isServiceMessage ){
            for (String key : server.hmRooms.keySet()) {
                if( messageInUsers.roomName.equals(key)){
                    ClientRooms clientRooms = server.hmRooms.get(key);
                    server.sendConnectionMesssage(clientRooms,clientSocket);
                    return;
                }
            }
        }
    }
}
