package P03WorkingWithAbstraction.P03StudentSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[]args) {
        if ("Create".equals(args[0])) {
            this.createStudent(Arrays.stream(args).toArray(String[]::new));
        }
        else if ("Show".equals(args[0])) {
            this.show(args[1]);
        }
    }

    public void createStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade =Double.parseDouble(args[3]);
        if (!repo.containsKey(name))
        {
            var student = new Student(name, age, grade);
            repo.put(name,student);
        }
    }

    public void show(String name) {
        if (repo.containsKey(name))
        {
            var student = repo.get(name);
            System.out.println(student);
        }
    }
}
