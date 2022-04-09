package com.string.calculator.collection;

import java.util.Stack;

public class NumberCollection {

  private Stack<String> numberStack = new Stack<>();

  String getOne() {
    return numberStack.pop();
  }

  void add(String number) {
    numberStack.add(number);
  }

  int size() {
    return numberStack.size();
  }

  void reverse() {
    Stack<String> temp = new Stack<>();

    while (!numberStack.isEmpty()) {
      String pop = numberStack.pop();
      temp.add(pop);
    }
    numberStack = temp;
  }

}
