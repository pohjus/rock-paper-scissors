package fi.company.util;

import fi.company.data.Shape;

import java.util.List;

/**
 * Class for calculating computer's choice.
 *
 * @author Jussi Pohjolainen
 */
public class ArtificialIntelligence {

    /**
     * Calculates random computer choice.
     *
     * @return Shape which is random, either rock, paper, scissors.
     */
    public static Shape getWeapon() {
        var weapons = List.of(Shape.PAPER, Shape.ROCK, Shape.SCISSORS);
        var random = (int) (Math.random() * weapons.size());
        return weapons.get(random);
    }
}
