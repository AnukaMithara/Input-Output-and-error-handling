package package2019e054;
//7.Custom Exception Class for check balance insufficient
public class BalanceInsufficientException extends Exception {
    public BalanceInsufficientException(String message) {
        super(message);
    }
}
