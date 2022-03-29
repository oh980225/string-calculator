package com.string.calculator;

public class NumberPiece {

  private final StringBuilder stringBuilder = new StringBuilder();

  public void add(Character numberPiece) {
    stringBuilder.append(numberPiece);
  }

  public String getNumber() {
    String number = stringBuilder.toString();
    // TODO: 이런 상태가 변경되는 지점 -> 최상위로
    stringBuilder.setLength(0);
    return number;
  }

  public boolean hasNumber() {
    return !stringBuilder.isEmpty();
  }

  public int size() {
    return stringBuilder.length();
  }


}
