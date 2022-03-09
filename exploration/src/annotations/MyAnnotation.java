package annotations;

import java.lang.annotation.Repeatable;

@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String name();
    int age() default 100;
}
