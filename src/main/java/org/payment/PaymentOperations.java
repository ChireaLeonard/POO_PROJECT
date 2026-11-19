package org.payment;

public interface PaymentOperations {
    boolean validate();
    double calculateTotal();
}
