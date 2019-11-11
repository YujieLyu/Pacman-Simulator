/**
 * The grid class
 *
 * @author Yujie LYU
 */
public class Grid {
    private final int rows;
    private final int columns;

    /**
     * The grid
     *
     * @param rows    the rows of the grid
     * @param columns the columns of the grid
     */
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * @return the rows of the grid
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the columns of the grid
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Checks if the specified position is outside of the grid
     *
     * @param x the column
     * @param y the row
     * @return {@code true} if the specified coordinate is outside.
     */
    public boolean isOutside(int x, int y) {
        return x < 0 || x >= getColumns() || y < 0 || y >= getRows();
    }

}
