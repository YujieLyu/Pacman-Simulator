import java.util.Arrays;

/**
 * @author Yujie LYU
 */
public class Pacman {

    // Directions
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final String[] DIRECTIONS = new String[]{"NORTH", "EAST", "SOUTH", "WEST"};

    // The pace of pacman
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    private static final int PACE = 1;

    private boolean canMove = false;
    private int currX;
    private int currY;
    // the index of the current direction in "DIRECTIONS"
    private int currDirection;
    private Grid grid;

    /**
     * @return the current x of the pacman
     */
    public int getCurrentX() {
        return currX;
    }

    /**
     * @return the current y of the pacman
     */
    public int getCurrentY() {
        return currY;
    }

    /**
     * @return the current direction of the pacman
     */
    public String getCurrentDirection() {
        return DIRECTIONS[currDirection];
    }

    /**
     * Places the pacman in a new position
     *
     * @param nextX         the new x
     * @param nextY         the new y
     * @param nextDirection the new direction
     */
    public void place(int nextX, int nextY, String nextDirection) {
        // checks if the new position is valid.
        if (grid == null || grid.isOutside(nextX, nextY)) {
            return;
        }
        int nextDir = Arrays.asList(DIRECTIONS).indexOf(nextDirection.toUpperCase());
        if (nextDir < 0) {
            return;
        }
        currX = nextX;
        currY = nextY;
        currDirection = nextDir;
        canMove = true;
    }

    /**
     * Takes a step forward in the current direction
     */
    public void move() {
        if (!canMove) {
            return;
        }
        int moveX = currDirection == EAST ? PACE : currDirection == WEST ? -PACE : 0;
        int moveY = currDirection == NORTH ? PACE : currDirection == SOUTH ? -PACE : 0;
        if (grid == null || grid.isOutside(currX + moveX, currY + moveY)) {
            return;
        }
        currX += moveX;
        currY += moveY;
    }

    /**
     * Rotates the pacman to {@link Pacman#LEFT} or {@link Pacman#RIGHT}
     *
     * @param direction can be {@link Pacman#LEFT} or {@link Pacman#RIGHT}
     */
    public void turnTo(int direction) {
        if (!canMove || (direction != LEFT && direction != RIGHT)) {
            return;
        }
        // Rotates the current direction in the finite field of "DIRECTIONS"
        currDirection = (currDirection + direction + 4) % 4;
    }

    /**
     * Announces the X,Y and direction of the pacman
     */
    public void report() {
        if (!canMove) {
            return;
        }
        System.out.println(this);
    }

    /**
     * Sets the grid that the pacman placed
     *
     * @param grid
     */
    public void setGrid(Grid grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid Grid");
        }
        this.grid = grid;
    }

    @Override
    public String toString() {
        return getCurrentX() + ", " + getCurrentY() + ", " + getCurrentDirection();
    }
}
