package util;

// Non-local imports
import java.awt.Graphics;
import java.util.Arrays;

// Local imports
import Elements.Element;
import Elements.EmptyCell;
import Elements.Liquid.Water;
import Elements.Solid.Immovable.ImmovableSolid;
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
            case 2:
                matrix[x][y] = new Water(x, y);
                break;
        }
    }

    public Element getCell(int x, int y) {
        return matrix[x][y];
    }

    // public void Update() {
    //     for (Element[] row : matrix) {
    //         for (Element cell : row) {
    //             if (cell.isFreeFalling && (getBelowCell(cell) instanceof EmptyCell && canDropBelow(cell))) {
    //                 matrix[cell.getX()][cell.getY()-1] = cell;
    //             }
    //         }
    //     }
    // }

    public void Update() {
        for (int y = matrix[0].length - 2; y >= 0; y--) { // Start from second-to-last row
            for (int x = 0; x < matrix.length; x++) {
                Element cell = matrix[x][y];
                if (cell.isFreeFalling) {
                    Element belowCell = getBelowCell(cell);
                    if (belowCell instanceof EmptyCell && canDropBelow(cell)) {
                        // Move the cell down
                        matrix[x][y + 1] = cell;
                        matrix[x][y] = new EmptyCell(x, y); // Clear original position
                    }
                }
            }
        }
    }


    public void draw(Graphics g) {
        for (Element[] row : matrix) {
            for (Element cell : row) {
                cell.draw(g);
            }
        }
    }

    public boolean canDropBelow(Element cell) {
        return getBelowCell(cell) instanceof ImmovableSolid || Vec2.isWithinBounds(new Vec2(400, 500), getBelowCell(cell).GetPosition());
    }

    public Element getBelowCell(Element cell) {
        return matrix[cell.getX()][cell.getY()-1];
    }
}
