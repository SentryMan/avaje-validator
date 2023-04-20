package io.avaje.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;

import io.avaje.validation.core.DefaultBootstrap;
import io.avaje.validation.spi.Bootstrap;

public interface Validator {

  static Builder builder() {
    final Iterator<Bootstrap> bootstrapService = ServiceLoader.load(Bootstrap.class).iterator();
    if (bootstrapService.hasNext()) {
      return bootstrapService.next().builder();
    }
    return DefaultBootstrap.builder();
  }

  Set<ConstraintViolation> validate(Object any);

  Set<ConstraintViolation> validate(Collection<Object> any);

  <T> ValidationAdapter<T> adapter(Class<T> cls);

  <T> ValidationAdapter<T> adapter(Type type);

  <T> AnnotationValidationAdapter<T> annotationAdapter(Class<? extends Annotation> cls);

  /** Build the Validator instance adding ValidationAdapter, Factory or AdapterBuilder. */
  interface Builder {

    /** Add a ValidationAdapter to use for the given type. */
    <T> Builder add(Type type, ValidationAdapter<T> jsonAdapter);

    /** Add a AnnotationValidationAdapter to use for the given type. */
    <T> Builder add(Class<Annotation> type, AnnotationValidationAdapter<T> jsonAdapter);

    /** Add a AdapterBuilder which provides a ValidationAdapter to use for the given type. */
    Builder add(Type type, AdapterBuilder builder);

    /** Add a Component which can provide multiple JsonAdapters and or configuration. */
    Builder add(ValidatorComponent component);

    /** Add a ValidationAdapter.Factory which provides JsonAdapters to use. */
    Builder add(ValidationAdapter.Factory factory);

    /** Add a ValidationAdapter.Factory which provides JsonAdapters to use. */
    Builder add(AnnotationValidationAdapter.Factory factory);

    /**
     * Build and return the Validator instance with all the given adapters and factories registered.
     */
    Validator build();
  }

  /** Function to build a ValidationAdapter that needs Validator. */
  @FunctionalInterface
  interface AdapterBuilder {

    /** Create a ValidationAdapter given the Validator instance. */
    ValidationAdapter<?> build(Validator jsonb);
  }

  /** Components register JsonAdapters Validator.Builder */
  @FunctionalInterface
  interface GeneratedComponent extends ValidatorComponent {

    /** Register JsonAdapters with the Builder. */
    @Override
    void register(Builder builder);
  }
}
