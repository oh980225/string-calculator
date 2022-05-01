package com.string.calculator;

import static com.string.calculator.OperatorSign.isSupportedOperator;
import static com.string.calculator.OperatorSign.valueOf;

// 원하는게 뭔가? -> 출력 3가지를 표현, 단 DTO 없이
// 간단한 방법이며, 절차지향 방식을 버려라...
// ENUM? -> 얘도 DTO인가..? => 고민해봐라...
// interface로..? 다형성 이용해서..?

// 1. Enum을 사용하는 방법(Enum으로 리턴) -> numberPiece값이 조건에 필요,
// 그렇다고 numberPiece를 포함하게 하면 외부에서 Enum만으로 numberPiece내 문자를 받아오기 힘듬.
// 그리고 이것도 따지고 보면 DTO 아닌가..?

// 2. 다형성을 이용하는 방법 -> 결국 Run쪽에서 Result를 확인하는 과정을 위해 Enum같은 것이 필요할 듯
// 아니면 다운 캐스팅이 필요...

// 3. 결과를 나타내는 Enum과 파싱된 문자열을 가진 객체 리턴하는 방법 -> 이것도 완전 DTO

// 4. 상호 의존성이 생겨 서로 매우 밀접한 관계가 되겠지만.. 서로 호출하도록 한다.
// -> Interface를 사용해서 의존관계를 역전시키고 상호 의존성을 끊어보았따...

public class Parser {

  private final ControlState controlState;

  public Parser(ControlState controlState) {
    this.controlState = controlState;
  }

  //   DTO 안쓰고... 출력이 3가지 가능;; 어떻게 1개 이상의 출력..?;;
  void parse(Character c) { // stack들만 넘겨주면 또 상태가 변하는 지점이 숨게 된다..
    if (isSupportedOperator(c)) { // 파싱
      controlState.pushOperator(valueOf(c));
      return;
    }

    if (c == ' ' && controlState.isPresentNumberPiece()) { // 파싱
      controlState.pushNumber(controlState.takeOutNumber());
      return;
    }

    if ('0' <= c && c <= '9') {
      controlState.pushNumberPiece(c);
    }
  }
}
