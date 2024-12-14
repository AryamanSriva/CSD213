import java.util.Scanner;

interface Game {
    String start(char input);
}

class FlightSimple implements Game {
    private int speed;
    private int height;
    private int maxKeyStrokes;

    public FlightSimple(int maxKeyStrokes) {
        this.speed = 0;
        this.height = 0;
        this.maxKeyStrokes = maxKeyStrokes;
    }

    @Override
    public String start(char input) {
        maxKeyStrokes--;

        if (input == 'R') {
            speed++;
        } else if (input == 'L') {
            speed--;
            if (speed <= 0 && height > 0) {
                return "Lost";
            } else if (speed == 0 && height == 0) {
                return "Win";
            }
        } else if (input == 'U') {
            if (speed > 2) {
                height++;
            }

        } else if (input == 'D') {
            height--;
            if (height < 0 && speed > 0) {
                return "Lost";
            } else if (height == 0 && speed == 0) {
                return "Win";
            }
        }
        if (maxKeyStrokes <= 0) {
            return "Game Over";
        }

        return "None";
    }
}

class RandomWalk implements Game {
    private int maxKeyStrokes;
    private int row;
    private int colm;

    public RandomWalk(int maxKeyStrokes) {
        this.maxKeyStrokes = maxKeyStrokes;
        this.row = 10;
        this.colm = 10;
    }

    @Override
    public String start(char input) {
        maxKeyStrokes--;

        if (input == 'U') {
            row--;
            if (row == 0) {
                return "Win";
            }
        } else if (input == 'L') {
            if (colm > 0) {
                colm--;
            }
        } else if (input == 'R') {
            colm++;
            if (colm == 19) {
                return "Lost";
            }
        } else if (input == 'D') {
            row++;
            if (row == 19) {
                return "Lost";
            }
        }
        if (maxKeyStrokes <= 0) {
            return "Game Over";
        }

        return "None";
    }
}

public class GameConsole {
    private Scanner sc;
    private Game game;

    public GameConsole() {
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String currGame = sc.next();
            if (currGame.equalsIgnoreCase("end")) {
                break;
            }
            int maxKeyStrokes = sc.nextInt();
            if (currGame.equalsIgnoreCase("flightsimple")) {
                game = new FlightSimple(maxKeyStrokes);
            } else {
                game = new RandomWalk(maxKeyStrokes);
            }

            String actions = sc.next();  // Read the whole string

            // Loop through each character in the string
            for (char action : actions.toCharArray()) {
                String result = game.start(action);
                if (result.equalsIgnoreCase("win")) {
                    System.out.println(game.getClass().getSimpleName() + ": Win");
                    break;
                } else if (result.equalsIgnoreCase("lost")) {
                    System.out.println(game.getClass().getSimpleName() + ": Lost");
                    break;
                } else if (result.equalsIgnoreCase("game over")) {
                    System.out.println(game.getClass().getSimpleName() + ": GameOver");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameConsole console = new GameConsole();
        console.start();
    }
}
