//package P06Encapsulation_Exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateString(name, "A name should not be empty.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = players.removeIf(e -> e.getName().equals(name));
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.00);
    }
}
