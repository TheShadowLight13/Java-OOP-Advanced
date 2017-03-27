package pr10.annotations.annotationsInfo;

import pr10.annotations.CustomAnnotation;
import pr10.models.weapons.Weapon;

public class CustomAnnotationInfo {

    private static final Class<?> targetClass = Weapon.class;

    public static String getAuthor() {
        return targetClass.getAnnotation(CustomAnnotation.class).author();
    }

    public static int getRevision() {
        return targetClass.getAnnotation(CustomAnnotation.class).revision();
    }

    public static String getDescription() {
        return targetClass.getAnnotation(CustomAnnotation.class).description();
    }

    public static String[] getReviewers() {
        return targetClass.getAnnotation(CustomAnnotation.class).reviewers();
    }
}
