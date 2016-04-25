package Controller;

import Clasterization.Clusterization;
import View.MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Vladislav on 24.04.16.
 */
public class Controller {
    private MainFrame mainFrame;
    private BufferedImage image;

    public Controller() {
        this.mainFrame = new MainFrame();
        this.mainFrame.showFrame();

        this.loadImage("michael.jpg");
        proccessImage();
    }
    public void loadImage(String imageName) {
        this.image = null;
        try
        {
            image = ImageIO.read(new File(imageName));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        this.mainFrame.setImage(this.image);
    }
    public void proccessImage() {
        Clusterization clusterization = new Clusterization(this.image);
        clusterization.start();
        this.mainFrame.setImage(clusterization.gerResultImage());
    }
}
