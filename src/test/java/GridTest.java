import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yujie LYU
 */
public class GridTest {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(ROWS, COLUMNS);
    }

    @Test
    public void isOutside() {
        Assert.assertTrue(grid.isOutside(ROWS, COLUMNS));
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                Assert.assertFalse(grid.isOutside(x, y));
            }
        }
    }
}