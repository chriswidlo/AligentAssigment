package datetime.exception;

public class WrongDatesOrder extends RuntimeException{
    public WrongDatesOrder(String message) {
        super(message);
    }
}
