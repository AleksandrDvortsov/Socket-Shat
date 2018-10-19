package newChat;

import com.google.gson.Gson;

public class User {

    int id;
    String name;
    String nameRoom;
    String pass;
    String mesage;

    public User(int id, String name, String nameRoom, String pass,  String sms) {
        this.id = id;
        this.name = name;
        this.nameRoom = nameRoom;
        this.pass = pass;
        this.mesage = sms;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }


}
