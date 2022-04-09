package com.string.calculator.collection;

import java.util.Stack;

public class NumberStack {

  private Stack<String> stack = new Stack<>();

  String getOne() {
    return stack.pop();
  }

  void add(String number) {
    stack.add(number);
  }

  int size() {
    return stack.size();
  }

  void reverse() {
    Stack<String> temp = new Stack<>();

    while (!stack.isEmpty()) {
      String pop = stack.pop();
      temp.add(pop);
    }
    stack = temp;
  }

}
