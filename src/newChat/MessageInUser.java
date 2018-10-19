package newChat;

import com.google.gson.Gson;

public class MessageInUser {

    String nameUser;
    String passUser;
    String message;
    String roomName;
    long timeMessage;
    boolean isServiceMessage;


    public MessageInUser(String nameUser, String passUser, String message, String roomName, long timeMessage, boolean isServiceMessage) {
        this.nameUser = nameUser;
        this.passUser = passUser;
        this.message = message;
        this.roomName = roomName;
        this.timeMessage = timeMessage;
        this.isServiceMessage = isServiceMessage;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }


}
