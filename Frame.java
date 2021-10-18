import javax.swing.*;

public class Frame extends JFrame {
    Panel panel;

    Frame() {
        super("Sorting Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel = new Panel();
        this.add(panel);

        this.pack();
        this.setVisible(true);
    }
}