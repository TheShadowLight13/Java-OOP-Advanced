package pr10.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {

    String author();

    int revision();

    String description();

    String[] reviewers();
}
