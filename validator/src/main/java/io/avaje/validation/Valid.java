package io.avaje.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks a type for validation adapter generation
 *
 * <p>Additionally Marks a property, method parameter or method return type for validation
 * cascading.
 *
 * <p>Constraints defined on the object and its properties are validated when the property, method
 * parameter or method return type is validated.
 *
 * <p>This behavior is applied recursively.
 *
 * <p>Unlike {@code jakarta.validation.Valid} / {@code javax.validation.Valid}, this annotation can
 * be placed on types to trigger validation adapter generation.
 */
@Retention(CLASS)
@Target({TYPE, TYPE_USE, FIELD})
public @interface Valid {

  /** Validation groups to use */
  Class<?>[] groups() default {};
}
