package Clasterization;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Vladislav on 24.04.16.
 */
public class Clusterization {
    private BufferedImage image;
    private ArrayList<Cluster> clusters;

    public Clusterization(BufferedImage image) {
        this.image = image;
        this.clusters = new ArrayList<>();
    }
    public void start() {
        int clustersNumbers = 8;
        for (int currentCluster = 0; currentCluster < clustersNumbers; currentCluster++) {
            int randomX = (int) (Math.random() * (image.getWidth() - 1));
            int randomY = (int) (Math.random() * (image.getHeight() - 1));
            this.clusters.add(new Cluster(this.image.getRGB(randomX, randomY)));
        }
        for (int x = 0; x < this.image.getWidth(); x++)
            for (int y = 0; y < this.image.getHeight(); y++) {
                int minimalDifference = Integer.MAX_VALUE;
                int maximalDifference;
                int betterCluster = 0;
                for (Cluster currentCluser: this.clusters) {
                    maximalDifference = currentCluser.different(this.image.getRGB(x,y));
                    if (maximalDifference < minimalDifference) {
                        minimalDifference = maximalDifference;
                        betterCluster = this.clusters.indexOf(currentCluser);
                    }
                }
                clusters.get(betterCluster).addPixel(this.image.getRGB(x,y));
                int color = clusters.get(betterCluster).getRGB();
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = (color) & 0xff;
//                Color pixelColor = Color.);
                this.image.setRGB(x,y,color);
            }
    }
    public BufferedImage gerResultImage() {
        return this.image;
    }
}
