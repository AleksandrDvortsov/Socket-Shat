package newChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class consoleClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 10000;

    public Socket clientSocket;
    public Scanner messageScanner;
    public BufferedReader messageBuffer1, messageBuffer2;
    public PrintWriter outPrintMes;

    String inputConnsol = "";
    String nameChat = "";

    String name = "";
    String sms = "";
    String chatName = "";

    public consoleClient()  {
        try {

            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);

            if (name.equals("")) {
                messageBuffer2 = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("name: ");
                name = messageBuffer2.readLine();

                System.out.println("chat: ");
                chatName = messageBuffer2.readLine();
//                nameChat = messageBuffer2.readLine() + ": ";
            }
//            System.out.println("your message: ");
            messageBuffer1 = new BufferedReader(new InputStreamReader(System.in));
            messageScanner = new Scanner(clientSocket.getInputStream());
            outPrintMes = new PrintWriter(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

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
                            sendMsg();
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
                        String inMes = messageScanner.nextLine();
                        System.out.println(inMes + " inMEss");
                    }
                }
            }
        }).start();
    }

    private void sendMsg() throws IOException {
        MessageInUser messageInUsers = new MessageInUser(name,"0", sms, chatName, System.currentTimeMillis(), false);
        outPrintMes.println(messageInUsers.toJson());
        outPrintMes.flush();
    }
}
