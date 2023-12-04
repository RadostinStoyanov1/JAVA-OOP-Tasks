package P24DesignPatterns_Exercise.factoryExercise;

public class WhiteCake extends Cake {
    public WhiteCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing White Cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking White Cake...");
    }

    @Override
    public void box() {
        System.out.printf("Boxing White Cake with %d pieces\n", this.pieces);
        System.out.printf("White Cake is ready. Your bill is %.2f\n", this.price);
    }
}
