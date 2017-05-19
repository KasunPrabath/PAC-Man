package stockTicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Kasun Prabath This class has the details about all the Dots It can
 * generate Dots randomly
 */
public final class Board {

    int count = 0;
    final Random rand = new Random();
    HashMap<Integer, ArrayList<String>> dot_list = new HashMap<>();

    public Board() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < 12; i++) {
            generate_dot();
        }
    }

    public void generate_dot() {   //generate random positioned dots
        ArrayList<String> dot = new ArrayList<>();
        int x = rand.nextInt(44);
        int y = rand.nextInt(44);
        int color = count % 3;

        switch (color) {
            case 0:
                dot.add(0, "R");
                dot.add(1, Integer.toString(x));
                dot.add(2, Integer.toString(y));
                break;
            case 1:
                dot.add(0, "G");
                dot.add(1, Integer.toString(x));
                dot.add(2, Integer.toString(y));
                break;
            case 2:
                dot.add(0, "B");
                dot.add(1, Integer.toString(x));
                dot.add(2, Integer.toString(y));
                break;
        }
        dot_list.put(count, dot);
        count++;
    }

    public String get_position() {
        return "\"DOTS\": [[\"" + dot_list.get(0).get(0) + "\", " + Integer.parseInt(dot_list.get(0).get(1)) + ", " + Integer.parseInt(dot_list.get(0).get(2)) + "],[\"" + dot_list.get(1).get(0) + "\", " + Integer.parseInt(dot_list.get(1).get(1)) + ", " + Integer.parseInt(dot_list.get(1).get(2)) + "],[\"" + dot_list.get(2).get(0) + "\", " + Integer.parseInt(dot_list.get(2).get(1)) + ", " + Integer.parseInt(dot_list.get(2).get(2)) + "],[\"" + dot_list.get(3).get(0) + "\", " + Integer.parseInt(dot_list.get(3).get(1)) + ", " + Integer.parseInt(dot_list.get(3).get(2)) + "],[\"" + dot_list.get(4).get(0) + "\", " + Integer.parseInt(dot_list.get(4).get(1)) + ", " + Integer.parseInt(dot_list.get(4).get(2)) + "],[\"" + dot_list.get(5).get(0) + "\", " + Integer.parseInt(dot_list.get(5).get(1)) + ", " + Integer.parseInt(dot_list.get(5).get(2)) + "],[\"" + dot_list.get(6).get(0) + "\", " + Integer.parseInt(dot_list.get(6).get(1)) + ", " + Integer.parseInt(dot_list.get(6).get(2)) + "],[\"" + dot_list.get(7).get(0) + "\", " + Integer.parseInt(dot_list.get(7).get(1)) + ", " + Integer.parseInt(dot_list.get(7).get(2)) + "],[\"" + dot_list.get(8).get(0) + "\", " + Integer.parseInt(dot_list.get(8).get(1)) + ", " + Integer.parseInt(dot_list.get(8).get(2)) + "],[\"" + dot_list.get(9).get(0) + "\", " + Integer.parseInt(dot_list.get(9).get(1)) + ", " + Integer.parseInt(dot_list.get(9).get(2)) + "],[\"" + dot_list.get(10).get(0) + "\", " + Integer.parseInt(dot_list.get(10).get(1)) + ", " + Integer.parseInt(dot_list.get(10).get(2)) + "],[\"" + dot_list.get(11).get(0) + "\", " + Integer.parseInt(dot_list.get(11).get(1)) + ", " + Integer.parseInt(dot_list.get(11).get(2)) + "]]";
    }
}

//        String position = "\"DOTS\": [[\"B\", 5, 6],[\"G\", 23, 12],[\"R\", 34, 7],[\"B\", 25, 8],[\"G\", 28, 1],[\"R\", 42, 17],[\"B\", 15, 36],[\"G\", 22, 22],[\"R\", 5, 37],[\"B\", 25, 28],[\"G\", 9, 39],[\"R\", 10, 21]]";

