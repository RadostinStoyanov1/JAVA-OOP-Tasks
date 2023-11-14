package P11Polymorphism.P02Shapes;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter((2 * height) + (2 * width));
    }

    @Override
    protected void calculateArea() {
        setArea(height * width);
    }


}
