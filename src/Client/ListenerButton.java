package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButton {

    public ActionButtonLogin btnListenerLogin = new ActionButtonLogin();
    public ActionButtonSend btnListenerSend = new ActionButtonSend();
    public ActionButtonCreate btnListenerCreate = new ActionButtonCreate();
    public ActionComboBox comboBox = new ActionComboBox();
    public ActionExecuteCommandAdmin exComAd = new ActionExecuteCommandAdmin();


    class ActionButtonLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" login click ");
        }
    }
    class ActionButtonSend implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            btnListenerSend.

            System.out.println(" Send click ");
        }
    }
    class ActionButtonCreate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" Create click ");
        }
    }
    class ActionComboBox implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" Combobox click ");
        }
    }
    class ActionExecuteCommandAdmin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" Execute Command Admin click ");
        }
    }


}
