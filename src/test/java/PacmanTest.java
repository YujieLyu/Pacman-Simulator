import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yujie LYU
 */
public class PacmanTest {

    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static final String DEFAULT_REPORT = "0, 0, NORTH";
    private Pacman pacman;

    @Before
    public void setUp() {
        pacman = new Pacman();
        pacman.setGrid(new Grid(ROWS, COLUMNS));
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
    }

    @After
    public void tearDown() {
        pacman = null;
    }

    @Test
    public void place() {
        pacman.place(1, 1, "East");
        Assert.assertEquals("1, 1, EAST", pacman.toString());
    }

    @Test
    public void placeInvalidPosition() {
        pacman.place(COLUMNS, ROWS, "west");
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
    }

    @Test
    public void placeInvalidDirection() {
        pacman.place(1, 1, "southwest");
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
    }

    @Test
    public void move() {
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
        pacman.place(1, 1, "East");
        pacman.move();
        Assert.assertEquals("2, 1, EAST", pacman.toString());
    }

    @Test
    public void moveBeforePlacing() {
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
        pacman.move();
        Assert.assertEquals(DEFAULT_REPORT, pacman.toString());
    }

    @Test
    public void turnTo() {
        pacman.place(1, 1, "NORTH");
        String[] directions = new String[]{"WEST", "SOUTH", "EAST", "NORTH"};
        for (int i = 0; i < 4; i++) {
            pacman.turnTo(Pacman.LEFT);
            Assert.assertEquals(directions[i], pacman.getCurrentDirection());
        }
        Assert.assertEquals("NORTH", pacman.getCurrentDirection());
        directions = new String[]{"EAST", "SOUTH", "WEST", "NORTH"};
        for (int i = 0; i < 4; i++) {
            pacman.turnTo(Pacman.RIGHT);
            Assert.assertEquals(directions[i], pacman.getCurrentDirection());
        }
        Assert.assertEquals("NORTH", pacman.getCurrentDirection());
    }
}