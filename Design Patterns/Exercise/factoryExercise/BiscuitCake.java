package P24DesignPatterns_Exercise.factoryExercise;

public class BiscuitCake extends Cake {
    public BiscuitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Biscuit Cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Biscuit Cake...");
    }

    @Override
    public void box() {
        System.out.printf("Boxing Biscuit Cake with %d pieces\n", this.pieces);
        System.out.printf("Biscuit Cake is ready. Your bill is %.2f\n", this.price);
    }
}
