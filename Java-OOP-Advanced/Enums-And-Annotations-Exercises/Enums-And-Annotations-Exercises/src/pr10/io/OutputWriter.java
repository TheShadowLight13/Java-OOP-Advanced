package pr10.io;

import pr10.models.weapons.Weapon;

public class OutputWriter {

    public static void printWeaponOnNewLine(Weapon weapon) {
        System.out.println(weapon);
    }

    public static void printWeaponWithItemLevelOnNewLine(Weapon weapon) {
        System.out.printf("%s (Item Level: %.1f)%n", weapon, weapon.getItemLevel());
    }

    public static void printReviewersOnNewLine(String[] reviewers) {
        System.out.printf("Reviewers: %s%n", String.join(", ", reviewers));
    }

    public static void printDescriptionOnNewLine(String description) {
        System.out.printf("Class description: %s%n", description);
    }

    public static void printRevisionOnNewLine(int revision) {
        System.out.printf("Revision: %s%n", revision);
    }

    public static void printAuthorOnNewLine(String author) {
        System.out.printf("Author: %s%n", author);
    }

    public static void printMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void displayException(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }
}
