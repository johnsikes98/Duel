package ecen_424_project;

import java.io.*;
import java.net.*;

public class client extends game {

    private String serverAddr;
    private int serverPort;

    public void joinGame() throws Exception {
        
        System.out.println("\n---------------------------------------------------------\n");
        
        playerSocket = new Socket(serverAddr, serverPort);

        socketInput = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        socketOutput = new DataOutputStream(playerSocket.getOutputStream());
        
        send(thisPlayer.getName());
        
        oppPlayer = new player(receive());
        
        System.out.println("Joined " + oppPlayer.getName() + "'s server");
        
        setStats();
        
        getStats();
        
        playerSocket.close();
    }

    client(String addr, int port, String playerName) throws Exception {
        serverAddr = addr;
        serverPort = port;
        thisPlayer = new player(playerName);
        joinGame();
    }
}
