package util;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Initialize JFrame and animationPanel instance
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create JFrame
                JFrame frame = new JFrame("Cellular Automata");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create instance of AnimationPanel and add it to the main frame, making it focusable
                Application app = new Application();
                frame.add(app);
                app.setFocusable(true);
                app.Setup();

                // Pack, make visible, and set unresizable the main frame
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);

                // Game Loop:
                while (true) {
                    app.Input();
                    app.Update();
                    frame.repaint();
                }
            }
        }); 
    }
}
