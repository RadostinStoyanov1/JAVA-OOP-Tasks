package P23DesignPatterns.DemoBuilder;

public class Main {
    public static void main(String[] args) {

        Address.Builder builder = Address.builder();

        builder.withName("Ivan");
        builder.withCity("Ruse");

        Address address = builder.build();

        Address address1 = Address.builder()
                .withCity("Sofia")
                .withName("Pesho")
                .withCountry("Bulgaria")
                .build();
    }
}
