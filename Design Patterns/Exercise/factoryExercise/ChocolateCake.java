package P24DesignPatterns_Exercise.factoryExercise;

public class ChocolateCake extends Cake{
    public ChocolateCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Chocolate Cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chocolate Cake...");
    }

    @Override
    public void box() {
        System.out.printf("Boxing Chocolate Cake with %d pieces\n", this.pieces);
        System.out.printf("Chocolate Cake is ready. Your bill is %.2f\n", this.price);
    }
}
