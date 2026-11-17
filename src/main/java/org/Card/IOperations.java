package org.Card;

public interface IOperations {
    boolean cardLimitReached(double sum);
    boolean acceptPayment(double sum);
}
