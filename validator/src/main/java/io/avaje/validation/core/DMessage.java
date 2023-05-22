package io.avaje.validation.core;

import io.avaje.validation.adapter.ValidationContext;

import java.util.Map;

final class DMessage implements ValidationContext.Message {

  private final String template;
  private final Map<String, Object> attributes;

  // when true ... template includes ${validatedValue} the actual value, must be rendered at runtime
  boolean includesConstraintValue;
  DMessage(String template, Map<String, Object> attributes) {
    this.template = template;
    this.attributes = attributes;
  }

  @Override
  public String template() {
    return template;
  }

  @Override
  public Map<String, Object> attributes() {
    return attributes;
  }
}