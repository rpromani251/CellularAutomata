package util;

import java.awt.Graphics;

import Elements.Element;
import Elements.EmptyCell;
import Elements.Solid.Immovable.Stone;

public class CellularMatrix {
    private Element[][] matrix;

    public CellularMatrix(int width, int height) {
        matrix = new Element[width][height];
    }

    public void addCell(int eleID, int xPos, int yPos) {
        switch (eleID) {
            case 0:
            matrix[xPos][yPos] = new EmptyCell();
            case 1:
            matrix[xPos][yPos] = new Stone();

        }
    }

    public Element getCell(int xPos, int yPos) {
        return matrix[xPos][yPos];
    }

    public void draw(Graphics g, int xPos, int yPos) {
        for (Element[] row : matrix) {
            for (Element cell : row) {
                
            }
        }
    }
}
