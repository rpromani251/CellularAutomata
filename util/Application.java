package util;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Application extends JPanel {
    // Window Size:
    private final int FRAME_WIDTH  = 400;
    private final int FRAME_HEIGHT = 500;

    // Class Declarations
    private CellularMatrix cellMatrix;
    private Mouse mouse;
    private int currElement;

    // Constructor:
    public Application() {
        // Set Default Values:
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        // Create Instance of Cellular Matrix:
        cellMatrix = new CellularMatrix(FRAME_WIDTH, FRAME_HEIGHT);
        mouse = new Mouse();
    }

    // Setup
    public void Setup() {
        // Key Listener:
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1:
                        currElement = 1;
                        System.out.println("Current: Stone");
                        break;
                }
            }
        });
        // Mouse Button Listener:
        addMouseListener(new MouseAdapter() {
            // Mouse Button Down: Left -> Destroy, Right -> Place
            @Override
            public void mousePressed(MouseEvent e) {
                // Update Current Position Stored in Mouse
                mouse.UpdatePosition(e.getX(), e.getY());
                
                // Determine if Left or Right Mouse Button is Clicked
                if (!mouse.GetLeftButtonDown() && SwingUtilities.isLeftMouseButton(e)) {
                    mouse.SetLeftMouseButton(true);
                    cellMatrix.addCell(0, (int) mouse.GetPosition().x, (int) mouse.GetPosition().y);
                }

                if(!mouse.GetLeftButtonDown() && SwingUtilities.isRightMouseButton(e)) {
                    mouse.SetRightMouseButton(true);
                    cellMatrix.addCell(currElement, (int) mouse.GetPosition().x, (int) mouse.GetPosition().y);
                    System.out.println(cellMatrix.getCell((int) mouse.GetPosition().x, (int) mouse.GetPosition().y));
                }
            }

            // Mouse Button Up: Left -> Destroy, Right -> Place
            @Override
            public void mouseReleased(MouseEvent e) {
                // Determine if Left or Right Mouse Button is Released
                if (mouse.GetLeftButtonDown() && SwingUtilities.isLeftMouseButton(e)) {
                    mouse.SetLeftMouseButton(false);
                }

                if(mouse.GetLeftButtonDown() && SwingUtilities.isRightMouseButton(e)) {
                    mouse.SetRightMouseButton(false);
                }
            }
        });

        // Scroll Wheel Listener:
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Scroll Wheel Up/Away from User
                if (e.getWheelRotation() < 0) {
                    mouse.IncreaseCursorSize(10);
                }
                // Scroll Wheel Down/Away from User
                if (e.getWheelRotation() > 0) {
                    mouse.IncreaseCursorSize(-10);
                }
            }
        });
    }

    // Write current info to the mouse
    public void Input() {

    }

    // Take info from Mouse State -> Update Cell Matrix -> Update Cells -> Read and Repaint
    public void Update() {
        

        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        cellMatrix.draw(g, (int) mouse.GetPosition().x, (int) mouse.GetPosition().y);
    }
}
