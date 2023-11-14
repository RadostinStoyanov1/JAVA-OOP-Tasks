package P11Polymorphism.P02Shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * radius * radius);
    }
}
