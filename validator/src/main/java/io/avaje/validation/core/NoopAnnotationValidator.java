package io.avaje.validation.core;

import io.avaje.validation.adapter.ValidationAdapter;
import io.avaje.validation.adapter.ValidationRequest;

final class NoopAnnotationValidator<T> implements ValidationAdapter<T> {
  public static final NoopAnnotationValidator INSTANCE = new NoopAnnotationValidator<>();

  private NoopAnnotationValidator() {}

  @Override
  public boolean validate(T type, ValidationRequest req, String propertyName) {
    // NOOP
    return true;
  }
}
