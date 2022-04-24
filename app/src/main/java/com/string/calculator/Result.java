package com.string.calculator;

import java.util.List;
import java.util.Stack;

// 1. 연산자
// 2. 숫자
// 3. X (다음 거)
public record Result(OperatorSign operatorSign, StringNumber stringNumber) {
}
