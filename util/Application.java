package util;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.function.BiConsumer;

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
        // Create a BiConsumer that takes x and y coordinates and adds a cell at those coordinates
        BiConsumer<Integer, Integer> addCellAtPosition = (x, y) -> {
            cellMatrix.addCell(currElement, x, y);
        };
        
        // Key Listener:
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_0:
                        currElement = 0;
                        System.out.println("Current: EmptyCell");
                        break;
                    case KeyEvent.VK_1:
                        currElement = 1;
                        System.out.println("Current: Stone");
                        break;
                    case KeyEvent.VK_2:
                        currElement = 2;
                        System.out.println("Current: Water");
                }
            }
        });
        // Mouse Button Listener:
        addMouseListener(new MouseAdapter() {
            // Mouse Button Down: Left -> Destroy, Right -> Place
            @Override
            public void mousePressed(MouseEvent e) {
                
                // Determine if Left or Right Mouse Button is Clicked
                if (!mouse.GetLeftButtonDown() && SwingUtilities.isLeftMouseButton(e)) {
                    mouse.SetLeftMouseButton(true);
                    // Update Current Position Stored in Mouse
                    mouse.UpdatePosition(e.getX(), e.getY());
                }

                if(!mouse.GetLeftButtonDown() && SwingUtilities.isRightMouseButton(e)) {
                    mouse.SetRightMouseButton(true);
                    // Update Current Position Stored in Mouse
                    mouse.UpdatePosition(e.getX(), e.getY());
                }
            }

            // Mouse Button Up: Left -> Destroy, Right -> Place
            @Override
            public void mouseReleased(MouseEvent e) {
                // Determine if Left or Right Mouse Button is Released
                if (mouse.GetLeftButtonDown() && SwingUtilities.isLeftMouseButton(e)) {
                    mouse.SetLeftMouseButton(false);
                    // Update Current Position Stored in Mouse
                    mouse.UpdatePosition(e.getX(), e.getY());
                    Vec2.iterateAndApplyMethodBetweenTwoPoints(mouse.GetPosition(), mouse.GetPreviousPosition(), 
                        (x, y) -> addCellAtPosition.accept(x, y)
                        // addCellAtPosition.accept((int) mouse.GetPosition().x, (int) mouse.GetPosition().y); // Use the current iteration's x and y
                );
                }

                if(mouse.GetRightButtonDown() && SwingUtilities.isRightMouseButton(e)) {
                    mouse.SetRightMouseButton(false);
                    
                    // Update Current Position Stored in Mouse
                    mouse.UpdatePosition(e.getX(), e.getY());
                    Vec2.iterateAndApplyMethodBetweenTwoPoints(mouse.GetPosition(), mouse.GetPreviousPosition(), 
                        (x, y) -> addCellAtPosition.accept(x, y)
                );
                }
            }
        });

        // Mouse Motion Listener:
        addMouseMotionListener(new MouseMotionAdapter() {
            // Update current mouse position
            @Override
            public void mouseDragged(MouseEvent e) {
                // Update current mouse position
                mouse.UpdatePosition(e.getX(), e.getY());

                // Place a cell at the current mouse position
                if (mouse.GetRightButtonDown()) {
                    Vec2.iterateAndApplyMethodBetweenTwoPoints(mouse.GetPosition(), mouse.GetPreviousPosition(), 
                        (x, y) -> addCellAtPosition.accept(x, y)
                );
                }
            }
        });

        // Scroll Wheel Listener:
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Scroll Wheel Up/Away from User
                if (e.getWheelRotation() < 0) {
                    mouse.IncreaseCursorSize(1);
                }
                // Scroll Wheel Down/Away from User
                if (e.getWheelRotation() > 0) {
                    mouse.IncreaseCursorSize(-1);
                }
            }
        });
    }

    // Write current info to the mouse
    public void Input() {

    }

    // Take info from Mouse State -> Update Cell Matrix -> Update Cells -> Read and Repaint
    public void Update() {
        cellMatrix.Update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // System.out.println("paint component called");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        cellMatrix.draw(g);
    }
}
