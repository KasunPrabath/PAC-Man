package stockTicker;

/**
 *
 * @author Kasun Prabath
 * This class has the all the logic of the Game except boundary checking  
 */

public class Game_Logic {

    Players players;
    Board board;
    int food_count = 0;
    
    public Game_Logic(Players players, Board board) {  //constructor
        this.players = players;
        this.board = board;
    }
    
    public void Check_status(){
        
        for (int i = 0; i < 12; i++) {
            if (Integer.parseInt(board.dot_list.get(i).get(1)) == -1 && Integer.parseInt(board.dot_list.get(i).get(2)) == -1) {
                food_count++;
            }
        }
        
        if(food_count == 12){
//           board.dot_list.get(0).add(1, "999");
        }
    }

    public void check_Logic() {

        //checking the player eating the foods
        for (int i = 0; i < 12; i++) {
            if (players.p1[1] == Integer.parseInt(board.dot_list.get(i).get(1)) && players.p1[2] == Integer.parseInt(board.dot_list.get(i).get(2))) {
                if ("R".equals(board.dot_list.get(i).get(0))) {
                    players.p1[0]++;     
                }
                if ("G".equals(board.dot_list.get(i).get(0))) {
                    players.p1[0] += 2;     
                }
                if ("B".equals(board.dot_list.get(i).get(0))) {
                    players.p1[0] += 3;     
                }
                board.dot_list.get(i).add(1, "-1");
                board.dot_list.get(i).add(2, "-1");
            }
            if (players.p2[1] == Integer.parseInt(board.dot_list.get(i).get(1)) && players.p2[2] == Integer.parseInt(board.dot_list.get(i).get(2))) {
                
                if ("R".equals(board.dot_list.get(i).get(0))) {
                    players.p2[0]++;     
                }
                if ("G".equals(board.dot_list.get(i).get(0))) {
                    players.p2[0] += 2;     
                }
                if ("B".equals(board.dot_list.get(i).get(0))) {
                    players.p2[0] += 3;     
                }
                
                board.dot_list.get(i).add(1, "-1");
                board.dot_list.get(i).add(2, "-1");
            }

            if (players.p3[1] == Integer.parseInt(board.dot_list.get(i).get(1)) && players.p3[2] == Integer.parseInt(board.dot_list.get(i).get(2))) {
                
                if ("R".equals(board.dot_list.get(i).get(0))) {
                    players.p3[0]++;     
                }
                if ("G".equals(board.dot_list.get(i).get(0))) {
                    players.p3[0] += 2;     
                }
                if ("B".equals(board.dot_list.get(i).get(0))) {
                    players.p3[0] += 3;     
                }
                
                board.dot_list.get(i).add(1, "-1");
                board.dot_list.get(i).add(2, "-1");
            }
            if (players.p4[1] == Integer.parseInt(board.dot_list.get(i).get(1)) && players.p4[2] == Integer.parseInt(board.dot_list.get(i).get(2))) {
                
                if ("R".equals(board.dot_list.get(i).get(0))) {
                    players.p4[0]++;     
                }
                if ("G".equals(board.dot_list.get(i).get(0))) {
                    players.p4[0] += 2;     
                }
                if ("B".equals(board.dot_list.get(i).get(0))) {
                    players.p4[0] += 3;     
                }
                
                board.dot_list.get(i).add(1, "-1");
                board.dot_list.get(i).add(2, "-1");
            }
        }

        //Checking the player collisions
        
        if (players.p1[1] == players.p2[1] && players.p1[2] == players.p2[2]) {
            players.p1[0] -= 1;
            players.p2[0] -= 1;

            players.p1_temp[1] = 0;
            players.p1_temp[2] = 0;

            players.p2_temp[1] = 44;
            players.p2_temp[2] = 0;

        }

        if (players.p1[1] == players.p3[1] && players.p1[2] == players.p3[2]) {
            players.p1[0] -= 1;
            players.p3[0] -= 1;

            players.p1_temp[1] = 0;
            players.p1_temp[2] = 0;

            players.p3_temp[1] = 0;
            players.p3_temp[2] = 44;

        }

        if (players.p1[1] == players.p4[1] && players.p1[2] == players.p4[2]) {
            players.p1[0] -= 1;
            players.p4[0] -= 1;

            players.p1_temp[1] = 0;
            players.p1_temp[2] = 0;

            players.p4_temp[1] = 44;
            players.p4_temp[2] = 44;

        }

        if (players.p2[1] == players.p3[1] && players.p2[2] == players.p3[2]) {

            players.p2[0] -= 1;
            players.p3[0] -= 1;

            players.p2_temp[1] = 44;
            players.p2_temp[2] = 0;
            
            players.p3_temp[1] = 0;
            players.p3_temp[2] = 44;

        }

        if (players.p3[1] == players.p4[1] && players.p3[2] == players.p4[2]) {
            players.p3[0] -= 1;
            players.p4[0] -= 1;

            players.p3_temp[1] = 0;
            players.p3_temp[2] = 44;

            players.p4_temp[1] = 44;
            players.p4_temp[2] = 44;

        }

        if (players.p2[1] == players.p4[1] && players.p2[2] == players.p4[2]) {
            players.p2[0] -= 1;
            players.p4[0] -= 1;

            players.p2_temp[1] = 44;
            players.p2_temp[2] = 0;

            players.p4_temp[1] = 44;
            players.p4_temp[2] = 44;

        }
    }
}
