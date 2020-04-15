package fi.company;

import java.util.List;

public class ArtificialIntelligence {
    public static Weapon getWeapon() {
        var weapons = List.of(Weapon.PAPER, Weapon.ROCK, Weapon.SCISSORS);
        var random = (int) (Math.random() * weapons.size());
        return weapons.get(random);
    }
}
