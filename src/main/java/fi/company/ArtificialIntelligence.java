package fi.company;

import java.util.List;

public class ArtificialIntelligence {
    public static Weapon getWeapon() {
        List<Weapon> weapons = List.of(Weapon.PAPER, Weapon.ROCK, Weapon.SCISSORS);
        int random = (int) (Math.random() * weapons.size());
        return weapons.get(random);
    }
}
