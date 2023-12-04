package P24DesignPatterns_Exercise.singletonExercise;

public class Main {
    public static void main(String[] args) {

        HashCode instance1 = HashCode.getInstance("SoftUni");
        HashCode instance2 = HashCode.getInstance("Hello"); //instance2 has reference to instance1 and the record saved in instance1

        System.out.println(instance1.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());  //SoftUni hashCode will be printed
    }
}
