package util;

// Non-local imports
import java.awt.Graphics;
import java.util.Arrays;

// Local imports
import Elements.Element;
import Elements.EmptyCell;
import Elements.Solid.Immovable.Stone;

public class CellularMatrix {
    private Element[][] matrix;

    public CellularMatrix(int width, int height) {
        matrix = new Element[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = new EmptyCell(i, j);
            }
        }
    }

    public void addCell(int eleID, int x, int y) {
        switch (eleID) {
            case 0:
                matrix[x][y] = new EmptyCell(x, y);
                break;
            case 1:
                matrix[x][y] = new Stone(x, y);
                break;

        }
    }

    public Element getCell(int x, int y) {
        return matrix[x][y];
    }

    public void draw(Graphics g) {
        for (Element[] row : matrix) {
            for (Element cell : row) {
                cell.draw(g);
            }
        }
    }
}
