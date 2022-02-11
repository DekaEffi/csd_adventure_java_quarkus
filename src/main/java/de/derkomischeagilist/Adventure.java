package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.*;

import java.util.Locale;

public class Adventure {

    private int counter;
    private Room currentRoom;
    private Room loo;
    private Room washroom;
    private Room hallway;
    private Room teamOffice;
    private String lastResponse;

    public Adventure() {
        loo = new Loo();
        washroom = new WashRoom();
        hallway = new Hallway();
        teamOffice = new TeamOffice();
        currentRoom = loo;
        counter = 0;
        lastResponse = "";
    }

    public String tell(String command) {
        String response = "";
        switch (command.toLowerCase()){
            case "look around":
                response = currentRoom.getDetailedDescription();
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            case "go through door":
                currentRoom = washroom;
                response = currentRoom.getDescription();
                break;
            case "use door to hallway":
                currentRoom = hallway;
                response = currentRoom.getDescription();
                break;
            case "use door to team office":
                currentRoom = teamOffice;
                response = currentRoom.getDescription();
                break;
            case "help":
                if (currentRoom.equals(washroom)) {
                    response = "Try to 'look around'. Might help.";
                }
                else if (currentRoom.equals(loo)) {
                    response = "Try to 'look around', 'look at magazines' (better get your gloves) or just 'go through door' to escape the smell.";
                }
                else {
                    response = "There is no help for you!";
                }
                break;
            default:
               return currentRoom.handleCommand(command);
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = currentRoom.getDescription();
        return currentRoom.getDescription();
    }
}
