package ecen_424_project;

import java.util.Scanner;

public class launcher {

    Scanner sc = new Scanner(System.in);

    public void hostGame() {
        System.out.println("Enter your name:");
        String playerName = sc.next();

        try {
            server gameServer = new server(playerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void joinGame() {
        System.out.println("Enter your name:");
        String playerName = sc.next();
        System.out.println("Enter server address: ");
        
        String serverAddr = sc.next();
        System.out.println("Enter server port: ");
        int serverPort = Integer.parseInt(sc.next());

        System.out.println("Joining " + serverAddr + ":" + serverPort + "...");
        try {
            client gameClient = new client(serverAddr, serverPort, playerName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        System.out.print("Welcome! ");
        while (true) {
            System.out.println("Would you like to (h)ost a game or (j)oin a game?");
            String userInput = sc.next().toLowerCase();
            if (userInput.equals("h") || userInput.equals("host")) {
                hostGame();
                break;
            } else if (userInput.equals("j") || userInput.equals("join")) {
                joinGame();
                break;
            } else {
                System.out.print("Invalid input. ");
            }
        }
    }

    public static void main(String[] args) {
        launcher main = new launcher();
        main.run();
    }

}
