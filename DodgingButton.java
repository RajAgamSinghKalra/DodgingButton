import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DodgingButton extends JFrame {
    private JButton closeButton;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    public DodgingButton() {
        super("Dodging Close Button Game");
        setUndecorated(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        closeButton = new JButton("Close");
        closeButton.setBounds(100, 100, 90, 30);
        add(closeButton);
        closeButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                moveButton();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void moveButton() {
        int newX = (int) (Math.random() * (getWidth() - closeButton.getWidth()));
        int newY = (int) (Math.random() * (getHeight() - closeButton.getHeight()));
        closeButton.setLocation(newX, newY);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DodgingButton();
            }
        });
    }
}
