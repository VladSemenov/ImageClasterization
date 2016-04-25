package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Vladislav on 24.04.16.
 */
public class MainFrame extends JFrame {
    private JLabel imageLabel;

    public MainFrame() {
        super.setTitle("Image clasterization");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        this.imageLabel = new JLabel();
        this.imageLabel.setHorizontalAlignment(JLabel.CENTER);
        this.imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(this.imageLabel, BorderLayout.CENTER);
    }
    public void showFrame() {
        setVisible(true);
    }
    public void setImage(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);
        this.imageLabel.setIcon(imageIcon);
    }
}
