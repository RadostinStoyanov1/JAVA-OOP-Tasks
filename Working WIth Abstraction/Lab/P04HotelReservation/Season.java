package P03WorkingWithAbstraction.P04HotelReservation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Season {
    Autumn(1), Spring(2), Winter(3), Summer(4);

    private int multiplier;
    private static final Map<String, Season> VALUES = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(v -> VALUES.putIfAbsent(v.name(), v));
    }

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public Season getByName(String name) {
        Season season = VALUES.get(name);
        if (season == null) {
            return Spring;
        }
        return season;
    }

}
