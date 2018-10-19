package Client;

import javax.swing.*;

public class ClientWindow extends JFrame {

    public ClientWindow(){

        setLayout(null);
        setBounds(10,10,800,600);
        setTitle("Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        ListenerButton listenerButton = new ListenerButton();

        pPanel pPanel = new pPanel();
        ClientSocket controlerClient = new ClientSocket(pPanel);
        add( pPanel);

        setVisible(true);
    }

}
