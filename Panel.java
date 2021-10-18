import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    final int WIDTH = 800, HEIGHT = 500;
    final int n = 800;
    int[] a;
    Random random;
    Timer timer;

    Panel() {
        super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        a = new int[n];
        random = new Random();
        timer = new Timer(1,this);
        for(int i = 0; i < n; i++) {
            a[i] = random.nextInt(300) + 10;
        }
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int width = WIDTH / n;
        for(int i = 0; i < n; i++) {
            g2d.drawLine(i * width, 0, i * width, a[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outer:
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    repaint();
                    break outer;
                }
            }
        }
    }
}