package com.string.calculator;

import static com.string.calculator.OperatorSign.isSupportedOperator;
import static com.string.calculator.OperatorSign.valueOf;

// 원하는게 뭔가? -> 출력 3가지를 표현, 단 DTO 없이
// 간단한 방법이며, 절차지향 방식을 버려라...
// ENUM? -> 얘도 DTO인가..? => 고민해봐라...
// interface로..? 다형성 이용해서..?

public class Parsing {
  // DTO 안쓰고... 출력이 3가지 가능;; 어떻게 1개 이상의 출력..?;;
//  Result parse(Character c) {
//    if (isSupportedOperator(c)) { // 파싱
//      operatorSignStack.add(valueOf(c));
//    }
//
//    if (canAddNumberToCollection(c)) { // 파싱
//      numberStack.add(takeOutNumber());
//    }
//
//    if (zeroToNine(c)) { // 파싱
//      numberPiece.append(c);
//    }
//  }
}
