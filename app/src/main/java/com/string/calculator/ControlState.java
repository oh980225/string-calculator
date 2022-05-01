package com.string.calculator;

public interface ControlState {
  void pushOperator(OperatorSign operatorSign);

  void pushNumber(StringNumber stringNumber);

  void pushNumberPiece(char c);

  StringNumber takeOutNumber();

  boolean isPresentNumberPiece();
}