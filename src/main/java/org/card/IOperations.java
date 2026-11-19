package org.card;

public interface IOperations {
    boolean cardLimitReached(double sum);
    boolean acceptPayment(double sum);
}
