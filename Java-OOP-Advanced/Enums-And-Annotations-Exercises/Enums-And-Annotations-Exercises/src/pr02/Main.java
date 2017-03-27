package pr02;

import pr02.enums.CardRanks;
import pr02.annotations.CustomCardAnnotation;
import pr02.enums.CardSuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();

        Annotation annotation;

        if (rank.equals("Rank")) {
            annotation = getAnnotationForClass(CardRanks.class);
        } else {
            annotation = getAnnotationForClass(CardSuits.class);
        }

        CustomCardAnnotation annotationForClass = (CustomCardAnnotation)annotation;

        System.out.printf("Type = %s, Description = %s%n",
                annotationForClass.type(),
                annotationForClass.description());
    }

    private static Annotation getAnnotationForClass(Class<?> currClass) {

        Annotation annotation = currClass.getAnnotation(CustomCardAnnotation.class);
        if (annotation != null) {
            return annotation;
        }

        return null;
    }
}
