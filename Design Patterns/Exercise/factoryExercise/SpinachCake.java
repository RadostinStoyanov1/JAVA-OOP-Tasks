package P24DesignPatterns_Exercise.factoryExercise;

public class SpinachCake extends Cake{
    public SpinachCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Spinach Cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Spinach Cake...");
    }

    @Override
    public void box() {
        System.out.printf("Boxing Spinach Cake with %d pieces\n", this.pieces);
        System.out.printf("Spinach Cake is ready. Your bill is %.2f\n", this.price);
    }
}
