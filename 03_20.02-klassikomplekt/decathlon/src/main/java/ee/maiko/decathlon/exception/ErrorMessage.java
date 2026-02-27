package ee.maiko.decathlon.exception;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class ErrorMessage {
    private String message;
    private int status;
    private Date timestamp;
}