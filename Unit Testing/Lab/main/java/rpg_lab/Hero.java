package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private List<Weapon> inventory;

    public Hero(String name, Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.inventory = new ArrayList<>();
        this.inventory.add(axe);
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public List<Weapon> getWeapon() {
        return this.inventory;
    }

    public void attack(Target target) {
        this.inventory.stream().findFirst().orElseThrow(() -> new IllegalStateException("No weapon")).attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
