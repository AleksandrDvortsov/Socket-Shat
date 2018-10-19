package newChat;

import Client.ClientWindow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    static final int PORT = 15000;
    ArrayList<HandlerClients> arrHandlerClients = new ArrayList<>();
    HashMap<String,ClientRooms> hmRooms = new HashMap<String, ClientRooms>();
    ClientRooms clientRooms;

    public Server() {

        clientRooms = new ClientRooms("chat 1");
        hmRooms.put("chat 1",clientRooms);
        clientRooms = new ClientRooms("chat 2");
        hmRooms.put("chat 2",clientRooms);
        clientRooms = new ClientRooms("chat 3");
        hmRooms.put("chat 3",clientRooms);

        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                HandlerClients client = new HandlerClients(clientSocket,this);
                arrHandlerClients.add(client);
                System.out.println(client.clientSocket + " - clientSocket");
                new Thread(client).start();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void sendMessageToAllClients(String message, MessageInUser messageInUsers){

//        System.out.println(hmRooms.size() + " - H a s h M a p  S I Z E");
        hmRooms.get(messageInUsers.roomName).addMessageInRoom(message);
        hmRooms.get(messageInUsers.roomName).addInAllUsersNameInRoom(messageInUsers.nameUser);

        for ( HandlerClients hc : arrHandlerClients){
            if ( hc.nameRoom.equals(messageInUsers.roomName)){
//                if (hc.clientSocket == clientSocket){
//                    continue;
//                }
                hc.sendMessage(message);
            }
        }
    }

    public void sendConnectionMesssage(ClientRooms clientRooms,Socket clientSocket) {
        for ( HandlerClients hc : arrHandlerClients){
            if ( hc.clientSocket == clientSocket)
            hc.sendMessage(clientRooms.getMessagesInTheRoom());
        }
    }

    public void createRooms(String chatName) {
        hmRooms.put(chatName, new ClientRooms(chatName));
    }

}
