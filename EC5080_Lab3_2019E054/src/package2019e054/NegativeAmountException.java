package package2019e054;
//6.Custom Exception Class for check negative amount
public class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

