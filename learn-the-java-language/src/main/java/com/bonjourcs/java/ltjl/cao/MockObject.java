package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: mock object
 * Date: 2018/3/29
 */
public class MockObject {

    /**
     * color of mock object
     */
    enum Color {
        BLUE,
        YELLOW,
        PINK,
        GREEN;
    }

    public MockObject(Color color, int length, int weight) {
        this.color = color;
        this.length = length;
        this.weight = weight;
    }

    /**
     * color of mock object
     */
    private Color color;

    /**
     * length of mock object
     */
    private int length;

    /**
     * weight of mock object
     */
    private int weight;

    @Override
    public String toString() {
        return "MockObject{" +
                "color=" + color +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
