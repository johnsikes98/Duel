package ecen_424_project;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class game {

    Socket playerSocket;

    BufferedReader socketInput;
    DataOutputStream socketOutput;

    player thisPlayer;
    player oppPlayer;

    /*---------------------------------------------------
    
    
    Game funcionality here
    
    
    ---------------------------------------------------*/
    public void setStats() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter weapon choice:");
        System.out.println("(1) Sword: Damage 3, speed 7");
        System.out.println("(2) Axe:   Damage 5, speed 5");
        System.out.println("(3) Spear: Damage 7, speed 3");

        int input = sc.nextInt();

        if (input == 1) {
            thisPlayer.weapon = new weapon("Sword", 3, 7);
        } else if (input == 2) {
            thisPlayer.weapon = new weapon("Axe", 5, 7);
        } else if (input == 3) {
            thisPlayer.weapon = new weapon("Spear", 7, 3);
        }

        System.out.println("\nEnter defense choice:");
        System.out.println("(1) Shield:    Hitpoints 75, speed -25%");
        System.out.println("(2) Armor:     Hitpoints 150, speed -75%");
        System.out.println("(3) Chainmail: Hitpoints 100, speed -50%");

        input = sc.nextInt();

        if (input == 1) {
            thisPlayer.defense = new defense("Shield", 75, 0.75);
        } else if (input == 2) {
            thisPlayer.defense = new defense("Srmor", 150, 0.25);
        } else if (input == 3) {
            thisPlayer.defense = new defense("Chainmail", 100, 0.5);
        }

        System.out.println("\nEnter perk choice:");
        System.out.println("(1) Strength:     Damage +50%, speed +10%, hitpoints +25%");
        System.out.println("(2) Coordination: Damage +25%, speed +50%, hitpoints +10%");
        System.out.println("(3) Reflexes:     Damage +10%, speed +25%, hitpoints +50%");

        input = sc.nextInt();

        if (input == 1) {
            thisPlayer.perk = new perk( "Strenth", 1.5, 1.1, 1.25);
        } else if (input == 2) {
            thisPlayer.perk = new perk("Coordination", 1.25, 1.5, 1.1);
        } else if (input == 3) {
            thisPlayer.perk = new perk("Reflexes", 1.1, 1.25, 1.5);
        }

        send(thisPlayer.weapon.toString() + "," + thisPlayer.defense.toString() + "," + thisPlayer.perk.toString());

    }

    public void getStats() {
        String input = receive();
        
        
        String inputArray[] = input.split(",");
        
        oppPlayer.weapon = new weapon(inputArray[1], Double.parseDouble(inputArray[3]), Double.parseDouble(inputArray[5]));
        
        oppPlayer.defense = new defense(inputArray[7], Double.parseDouble(inputArray[9]), Double.parseDouble(inputArray[11]));
        
        oppPlayer.perk = new perk(inputArray[13], Double.parseDouble(inputArray[15]), Double.parseDouble(inputArray[17]), Double.parseDouble(inputArray[19]));
        
        System.out.println("\nOpposing Player Stats:\n" + oppPlayer.toString());
    }

    public String receive() {
        String received = "";
        try {
            received = socketInput.readLine();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return received;
    }

    public void send(String data) {
        try {
            socketOutput.writeBytes(data + '\n');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
