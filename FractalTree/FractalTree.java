import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FractalTree extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	static JSlider slider = new JSlider(1,8);
    static JSlider slider2 = new JSlider(10,180);
    static JLabel dispIteration;
    static int lineCount=255;
    static int slideVal=4;
    static int slideVal2=10;
    public FractalTree()
    {
        super();
        slider.addChangeListener(this);
        slider2.addChangeListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.green);
        drawTree(g, 900, 900, 180, Math.toRadians(-90),Math.toRadians(slideVal2), slideVal);
    }

    public static void calculate(){
        dispIteration.setText("Iteration Count: "+slideVal+" Number of lines: "+lineCount);
    }

    private void drawTree(Graphics g, int x1, int y1, double l, double t, double dt, double iterations) {
        if (iterations > 0) {
            //Graphics2D g2 = (Graphics2D)g;
            //g2.setStroke(new BasicStroke((float) (iterations-iterations/4)));
            int x2 = x1 + (int) (l * Math.cos(t));
            int y2 = y1 + (int) (l * Math.sin(t));
            g.drawLine(x1, y1, x2, y2);
            drawTree(g, x2, y2, l -l/4, t + dt,Math.toRadians(slideVal2), iterations - .5);
            drawTree(g, x2, y2, l-l /4, t - dt,Math.toRadians(slideVal2), iterations - .5);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        slideVal2=slider2.getValue();
        slideVal=slider.getValue();
        lineCount = (int)(Math.pow(2,slideVal*2))-1;
        calculate();
        repaint();
    }

    public static void main(String[] args) {
        JFrame t = new JFrame("Some swaggy fractal shit");
        FractalTree tree = new FractalTree();
        dispIteration = new JLabel("Iteration Count: 4");
        dispIteration.setForeground(Color.white);
        slider.setValue(slideVal);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider2.setValue(slideVal2);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        tree.add(dispIteration);
        tree.add(slider);
        tree.add(slider2);
        t.add(tree);
        t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        t.setResizable(false);
        t.setSize(1800, 1000);
        t.setVisible(true);
    }
}