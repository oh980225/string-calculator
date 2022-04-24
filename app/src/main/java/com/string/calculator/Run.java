package com.string.calculator;

import com.string.calculator.operation.OperationFactory;

import java.util.List;
import java.util.Stack;

import static com.string.calculator.OperatorSign.isSupportedOperator;
import static com.string.calculator.OperatorSign.valueOf;
import static java.util.Collections.reverse;

/**
 * 얘는 딱 인풋을 받으면 숫자들은 숫자 스택에, 연산자는 연산자스택에 넣어주는 역할만 하고싶은데 <-- 이것도 책임이 많은편인건가 내가 설계한 계산기 특성상 높은 우선순위의
 * 연산자가 있으면 연산을 해줘야 하는 상황....
 */

// [FLOW]
// 1. 입력을 char로 다 나눠준다.
// 2. 나눈 char을 공백을 기준으로 숫자 스택과 연산자 스택에 나눠서 넣어준다.
// 3. 이때 우선순위 연산자가 있고, 숫자 스택의 사이즈가 연산자 스택의 사이즈보다 크다면 미리 숫자 2개와 연산자 1개로
//    연산을 진행하고 그 결과를 숫자 스택에 넣어준다.
// 4. 숫자 스택과 연산자 스택을 모두 뒤집으며 연산하고 최종 결과를 반환한다.

// 상태가 변하는 걸 위로 올리니 책임을 어떻게 나눠야할지 모르겠다...
// 상태와 관련된 책임을 나누는 순간 depth가 추가된다...

public class Run {
  // 상태 관련
  private final Stack<StringNumber> numberStack = new Stack<>();
  private final Stack<OperatorSign> operatorSignStack = new Stack<>();
  private final StringBuilder numberPiece = new StringBuilder();

  // 의존
  private final PreCalculateCondition preCalculateCondition =
    new AllPreCalculateCondition(numberStack, operatorSignStack);
  private final Calculator calculator = new Calculator(new OperationFactory());

  public String calculate(String input) {
    List<Character> chars = input.chars()
      .mapToObj(c -> (char) c)
      .toList();

    for (Character c : chars) {
      execute(c);
    }

    checkLast();
    return getResult();
  }

  private void checkLast() {
    if (!numberPiece.isEmpty()) {
      numberStack.add(takeOutNumber());
    }

    if (preCalculateCondition.check()) {
      addNumber();
    }
  }

  private StringNumber takeOutNumber() {
    var number = new StringNumber(numberPiece.toString());
    numberPiece.setLength(0);
    return number;
  }

  private String getResult() {
    reverse(numberStack);
    reverse(operatorSignStack);

    while (numberStack.size() > 1) {
      addNumber();
    }

    return numberStack.pop().value();
  }

  private void execute(Character c) {
    if (preCalculateCondition.check()) {
      addNumber();
    }

    if (isSupportedOperator(c)) {
      operatorSignStack.add(valueOf(c));
    }

    if (canAddNumberToCollection(c)) {
      numberStack.add(takeOutNumber());
    }

    if (zeroToNine(c)) {
      numberPiece.append(c);
    }
  }

  private boolean zeroToNine(Character c) {
    return '0' <= c && c <= '9';
  }

  private void addNumber() {
    StringNumber left = numberStack.pop();
    StringNumber right = numberStack.pop();
    OperatorSign operatorSign = operatorSignStack.pop();
    StringNumber result = calculator.execute(new Binomial(left, right, operatorSign));
    numberStack.add(result);
  }

  private boolean canAddNumberToCollection(char c) {
    return c == ' ' && !numberPiece.isEmpty();
  }
}
