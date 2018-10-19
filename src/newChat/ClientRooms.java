package newChat;

import java.util.ArrayList;

public class ClientRooms {

    private String nameRoom = null;
    private String messagesInTheRoom = "";
    private ArrayList<String> allUserNameInThisRoom = new ArrayList<>();

    public ClientRooms(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public String getMessagesInTheRoom() {
        return messagesInTheRoom;
    }

    public ArrayList<String> getAllUserNameInThisRoom() {
        return allUserNameInThisRoom;
    }

    public void addInAllUsersNameInRoom(String userName) {
        allUserNameInThisRoom.add(userName);
//        System.out.println(allUserNameInThisRoom.toString() + " - R O O M S   all User Name In This Room");

    }
    public void addMessageInRoom (String messages) {
        messagesInTheRoom += "\n" + messages;
        System.out.println(messagesInTheRoom.toString() + " - R O O M S   M e s s a g e s");
    }


}
