package com.string.calculator;

import com.string.calculator.calculate.OperationFactory;
import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

/**
 * 얘는 딱 인풋을 받으면 숫자들은 숫자 스택에, 연산자는 연산자스택에 넣어주는 역할만 하고싶은데 <-- 이것도 책임이 많은편인건가 내가 설계한 계산기 특성상 높은 우선순위의
 * 연산자가 있으면 연산을 해줘야 하는 상황....
 */
public class Run {

  private final NumberCollection numberCollection = new NumberCollection();
  private final OperatorCollection operatorCollection = new OperatorCollection();
  private final NumberPiece numberPiece = new NumberPiece();
  private final Calculator calculator;

  public Run() {
    this.calculator = new Calculator(new OperationFactory());
  }

  // input을 하나씩 쪼개고
  // 그 쪼갠것을 하나씩 스택에 넣고
  // 그러면서 계산
  public String calculate(String input) {
    Formula formula = new Formula(input);

    return calculator.execute(formula);
//    for (Character c : chars) {
//      execute(c);
//    }
//    checkLast();
//    return getResult();
  }

  private void checkLast() {
    if (numberPiece.hasNumber()) {
      numberCollection.add(numberPiece.getNumber());
    }

    if (existHighOperatorSign()) {
      addNumber();
    }
  }

  private String getResult() {
    numberCollection.reverse();
    operatorCollection.reverse();

    while (numberCollection.size() > 1) {
      addNumber();
    }

    return numberCollection.getOne();
  }

  private void execute(Character c) {
    if (existHighOperatorSign()) {
      addNumber();
    }

    if (OperatorSign.isSupportedOperator(c)) {
      operatorCollection.add(OperatorSign.valueOf(c));
    }

    if (canAddNumberToCollection(c)) {
      numberCollection.add(numberPiece.getNumber());
    }

    if (isNumberPiece(c)) {
      numberPiece.add(c);
    }
  }

  private boolean isNumberPiece(Character c) {
    return c >= '0' && c <= '9';
  }

  // TODO: 이런 상태가 변경되는 지점 -> 최상위로 -> 왜 상태를 위로 끌어올려야할까? -> 불변이면 그럴 필요 없지 않을까?
  private void addNumber() {
    String leftValue = numberCollection.getOne();
    String rightValue = numberCollection.getOne();
    OperatorSign operatorSign = operatorCollection.getOne();
    String result = calculator.one(leftValue, rightValue, operatorSign);
    numberCollection.add(result);
  }

  private boolean existHighOperatorSign() {
    if (operatorCollection.isEmpty()) {
      return false;
    }

    // 빠져야 하는 코드인데 현재 코드를 고치면 안됨...
    if (operatorCollection.size() >= numberCollection.size()) {
      return false;
    }

    OperatorSign lastOperator = operatorCollection.peek();
    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }

  private boolean canAddNumberToCollection(char c) {
    return c == ' ' && numberPiece.hasNumber();
  }


}
