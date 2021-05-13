package ecen_424_project;

import java.io.*;
import java.net.*;

public class server extends game {

    private final int port = 9999;

    public void startServer() throws Exception {
        
        System.out.println("\n---------------------------------------------------------\n");
        
        ServerSocket welcomeSocket = new ServerSocket(port);

        playerSocket = welcomeSocket.accept();

        InetAddress clientAddr = playerSocket.getInetAddress();

        socketInput = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        socketOutput = new DataOutputStream(playerSocket.getOutputStream());

        
        oppPlayer = new player(receive());

        send(thisPlayer.getName());
        
        System.out.println(oppPlayer.getName() + " has joined from " + clientAddr);
        
        getStats();
        
        setStats();

        playerSocket.close();
    }

    server(String playerName) throws Exception {
        thisPlayer = new player(playerName);
        startServer();
    }

}
