package P09InterfacesAndAbstraction.P03SayHello;

public class Bulgarian implements Person{

    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
