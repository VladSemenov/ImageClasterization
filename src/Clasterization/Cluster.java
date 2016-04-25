package Clasterization;

/**
 * Created by Vladislav on 24.04.16.
 */
public class Cluster {
    private int red = 0;
    private int green;
    private int blue;
    private int redComponents;
    private int greenComponents;
    private int blueComponents;
    private int pixelsCount;

    public Cluster(int color) {
        this.pixelsCount = 0;
        addPixel(color);
        }
    public void addPixel(int color) {
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color >> 0 & 0xff;

        this.redComponents += red;
        this.greenComponents += green;
        this.blueComponents += blue;
        this.pixelsCount++;

        this.red = this.redComponents / this.pixelsCount;
        this.green = this.greenComponents / this.pixelsCount;
        this.blue = this.blueComponents / this.pixelsCount;
    }
    public int different(int color) {
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color >> 0 & 0xff;
        int redDifference = Math.abs(this.red - red);
        int greenDifference = Math.abs(this.green - green);
        int blueDifference = Math.abs(this.blue - blue);
        return (redDifference + greenDifference + blueDifference) / 3;
    }
    public int getRGB() {
        int red = this.redComponents / this.pixelsCount;
        int green = this.greenComponents / this.pixelsCount;
        int blue = this.blueComponents / this.pixelsCount;

        return 0xff000000 | red << 16 | green << 8 | blue;
    }
}
