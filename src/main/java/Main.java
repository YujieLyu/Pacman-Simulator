import java.io.*;

/**
 * @author Yujie LYU
 */
public class Main {

    // Commands
    public static final String PLACE = "PLACE";
    public static final String MOVE = "MOVE";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String REPORT = "REPORT";
    public static final String EXIT = "EXIT";

    public static final int COLUMNS = 5;
    public static final int ROWS = 5;

    public static void main(String[] args) throws IOException {
        Grid grid = new Grid(ROWS, COLUMNS);
        Pacman pacman = new Pacman();
        pacman.setGrid(grid);
        BufferedReader reader = getReader(args.length > 0 ? args[0] : null);
        boolean exit = false;
        String line;
        System.out.println("Please enter your commands: ");
        while (!exit && (line = reader.readLine()) != null) {
            try {
                String[] cmds = line.split("[ \t,]+");
                String cmd = cmds.length > 0 ? cmds[0].toUpperCase() : "";
                switch (cmd) {
                    case PLACE:
                        if (cmds.length < 4) {
                            break;
                        }
                        int nextX = Integer.parseInt(cmds[1]);
                        int nextY = Integer.parseInt(cmds[2]);
                        String nextDirection = cmds[3];
                        pacman.place(nextX, nextY, nextDirection);
                        break;
                    case MOVE:
                        pacman.move();
                        break;
                    case LEFT:
                        pacman.turnTo(Pacman.LEFT);
                        break;
                    case RIGHT:
                        pacman.turnTo(Pacman.RIGHT);
                        break;
                    case REPORT:
                        pacman.report();
                        break;
                    case EXIT:
                        exit = true;
                        break;
                    default:
                        usage();
                }
                if (!exit) {
                    System.out.println("Please continue...");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid positions");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static BufferedReader getReader(String filename) throws FileNotFoundException {
        Reader reader = filename == null ? new InputStreamReader(System.in) : new FileReader(filename);
        return new BufferedReader(reader);
    }

    private static void usage() {
        System.err.println("Usage: ");
        System.err.println("Pacman Simulator: [<command file>]");
        System.err.println("optional <command file>: the input of command sequence.");
        System.err.println("Available commands: ");
        System.err.println("- PLACE x,y,DIRECTION");
        System.err.println("  -- DIRECTION: <NORTH,SOUTH, EAST or WEST>");
        System.err.println("- MOVE");
        System.err.println("- LEFT");
        System.err.println("- RIGHT");
        System.err.println("- REPORT");
        System.err.println("- EXIT");
    }
}
