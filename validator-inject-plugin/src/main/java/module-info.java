module io.avaje.validation.plugin {

  requires transitive io.avaje.validation;
  requires transitive io.avaje.inject;

  provides io.avaje.inject.spi.Plugin with io.avaje.validation.inject.spi.DefaultValidatorProvider;
}
