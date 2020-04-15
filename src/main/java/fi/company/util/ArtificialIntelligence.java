package fi.company.util;

import fi.company.data.Shape;

import java.util.List;

public class ArtificialIntelligence {
    public static Shape getWeapon() {
        var weapons = List.of(Shape.PAPER, Shape.ROCK, Shape.SCISSORS);
        var random = (int) (Math.random() * weapons.size());
        return weapons.get(random);
    }
}
