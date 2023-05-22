package io.avaje.validation.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.avaje.validation.constraints.Positive.List;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Repeatable(List.class)
@Documented
public @interface Positive {

  String message() default "{avaje.Positive.message}";

  Class<?>[] groups() default {};

  /**
   * Defines several {@link Positive} constraints on the same element.
   *
   * @see Positive
   */
  @Target({METHOD, FIELD})
  @Retention(RUNTIME)
  @Documented
  @interface List {

    Positive[] value();
  }
}