package example.avaje.coreValid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.avaje.validation.Validator;

class CoreValidBeanTest {

  Validator validator = Validator.builder().build();

  @Test
  void valid() {
    assertThat(validator.check(new CoreValidBean("x"))).isEmpty();
  }

  @Test
  void blankName() {
    var violations = validator.check(new CoreValidBean(" "));
    assertThat(violations).hasSize(1);
    assertThat(violations.iterator().next().path()).isEqualTo("name");
  }
}
