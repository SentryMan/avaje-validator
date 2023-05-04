package io.avaje.validation.generator.models.valid;

import java.util.List;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotEmpty;

import io.avaje.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Valid
public class TestClass {

  @NotNull
  @NotBlank(message = "blankLmao")
  private String alias;

  @Nullable private String s;

  private int i;

  private Integer integer;

  private char ch;

  private Character chara;

  @NotEmpty
  private List<String> list;

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  @Negative(message = "message")
  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  public char getCh() {
    return ch;
  }

  public void setCh(char ch) {
    this.ch = ch;
  }

  public Character getChara() {
    return chara;
  }

  public void setChara(Character chara) {
    this.chara = chara;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }
}