package com.string.calculator;

import com.string.calculator.calculate.OperationFactory;
import com.string.calculator.collection.NumberCollection;
import com.string.calculator.collection.OperatorCollection;

import java.util.List;

import static com.string.calculator.CalculatePolicy.moreNumbersThanOperator;
import static com.string.calculator.OperatorSign.isSupportedOperator;

/**
 * 얘는 딱 인풋을 받으면 숫자들은 숫자 스택에, 연산자는 연산자스택에 넣어주는 역할만 하고싶은데 <-- 이것도 책임이 많은편인건가 내가 설계한 계산기 특성상 높은 우선순위의
 * 연산자가 있으면 연산을 해줘야 하는 상황....
 */
public class Run {
  // TODO: 메서드가 자기가 있어야할 곳에 있게 하자!
  public String calculate(String input) {
    var formula = new Formula(input);

    return formula.result();
  }
}
