package io.avaje.validation.adapter;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

/**
 *
 * Marks a type as a Constraint Adapter to be registered automatically.
 *
 * <p> A custom adapter registered using this annotation must have a public constructor accepting a ValidationContext instance, and must extend the AbstractConstraintAdapter class.
 *
 * <h3>Example:</h3>
 *
 * <pre>{@code
 * @ConstraintAdapter(SomeAnnotation.class)
 * public final class CustomAnnotationAdapter extends AbstractConstraintAdapter<Object> {
 *
 *   String value;
 *
 *   public CustomAnnotationAdapter(ValidationContext ctx, Set<Class<?>> groups, Map<String, Object> attributes) {
 *     //create a message object for error interpolation and set groups
 *      super(ctx.message(attributes), groups);
 *
 *      //use the attributes to extract the annotation values
 *      value = (String) attributes.get("value");
 *   }
 *
 *
 * 	 @Override
 *   public boolean isValid(Object value) {
 *
 *     var isValid = ...custom validation based on the attributes;
 *
 *     return isValid;
 * }
 *
 * }</pre>
 */
@Target(TYPE)
public @interface ConstraintAdapter {

  /** The Annotation this validator targets */
  Class<? extends Annotation> value();
}
