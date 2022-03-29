package com.string.calculator;

import java.util.List;

record Formula(List<Character> list) {
  Formula(String stringFormula) {
    this(stringFormula.chars()
      .mapToObj(c -> (char) c)
      .toList());
  }
}
