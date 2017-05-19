package stockTicker;

import java.util.ArrayList;
import java.util.HashMap;

final public class Players {

    int playerCount = 1;
    
    int[] p1_temp = {0,0, 0};  //player infomation
    int[] p2_temp = {0,44, 0};
    int[] p3_temp = {0,0, 44};
    int[] p4_temp = {0,44, 44};
    
    public int[] p1 = {0, 0, 0};
    public int[] p2 = {0, 44, 0};
    public int[] p3 = {0, 0, 44};
    public int[] p4 = {0, 44, 44};
  
   

    HashMap<Integer, ArrayList> playerList = new HashMap<>();  //hashmap to store players
    
    public void update(){
       
        p1[1] = ((p1_temp[1]%45)+45)%45;
        p1[2] = ((p1_temp[2]%45)+45)%45;
         
        p2[1] = ((p2_temp[1]%45)+45)%45;
        p2[2] = ((p2_temp[2]%45)+45)%45;
        
        p3[1] = ((p3_temp[1]%45)+45)%45;
        p3[2] = ((p3_temp[2]%45)+45)%45;
        
        p4[1] = ((p4_temp[1]%45)+45)%45;
        p4[2] = ((p4_temp[2]%45)+45)%45;
        
    
    }

    public int assignPlayer() {  //assign players to sessions
        if (playerCount == 1) {
            return 1;
        }
        if (playerCount == 2) {
            return 2;
        }
        if (playerCount == 3) {
            return 3;
        }
        if (playerCount == 4) {
            return 4;
        }
        return 0;
    }

    public void updatePosition(int i, String key) {   //update the player positions according to the keystrokes
        int k = Integer.parseInt(key);
        if (i == 1) {
            switch (k) {
                case 37:
                    p1_temp[1] -= 1;
                    break;
                case 38:
                    p1_temp[2] -= 1;
                    break;

                case 39:
                    p1_temp[1] += 1;
                    break;
                case 40:
                    p1_temp[2] += 1;
                    break;

            }
        }

        if (i == 2) {
            switch (k) {
                case 37:
                    p2_temp[1] -= 1;
                    break;
                case 38:
                    p2_temp[2] -= 1;
                    break;

                case 39:
                    p2_temp[1]+= 1;
                    break;
                case 40:
                    p2_temp[2] += 1;
                    break;

            }
        }

        if (i == 3) {
            switch (k) {
                case 37:
                    p3_temp[1] -= 1;
                    break;
                case 38:
                    p3_temp[2] -= 1;
                    break;

                case 39:
                    p3_temp[1] += 1;
                    break;
                case 40:
                    p3_temp[2] += 1;
                    break;

            }
        }

        if (i == 4) {
            switch (k) {
                case 37:
                    p4_temp[1] -= 1;
                    break;
                case 38:
                    p4_temp[2] -= 1;
                    break;

                case 39:
                    p4_temp[1] += 1;
                    break;
                case 40:
                    p4_temp[2] += 1;
                    break;

            }
        }
    }

    public String get_position() {  //returning player details
        return "\"PLAYERS\": [[\"P1\"," + p1[0] + ", " + p1[1] + ", " + p1[2] + "], [\"P2\", " + p2[0] + ", " + p2[1] + ", " + p2[2] + "],[\"P3\", " + p3[0] + ", " + p3[1] + ", " + p3[2] + "],[\"P4\"," + p4[0] + ", " + p4[1] + ", " + p4[2] + "]]";
    }

}
