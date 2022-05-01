package com.string.calculator;

import static com.string.calculator.OperatorSign.isSupportedOperator;
import static com.string.calculator.Result.*;

// 원하는게 뭔가? -> 출력 3가지를 표현, 단 DTO 없이
// 간단한 방법이며, 절차지향 방식을 버려라...
// ENUM? -> 얘도 DTO인가..? => 고민해봐라...
// interface로..? 다형성 이용해서..?
// 1. Enum을 사용하는 방법

public class Parser {
  //   DTO 안쓰고... 출력이 3가지 가능;; 어떻게 1개 이상의 출력..?;;
  Result parse(Character c) {
    if (isSupportedOperator(c)) { // 파싱
      return OPERATOR;
    }

    if (c == ' ') { // 파싱
      return NUMBER;
    }

    if('0' <= c && c <= '9') {
      return CONTINUE;
    }

    throw new IllegalArgumentException("Illegal Input!");
  }
}
