public class HeaderException extends Exception {
    private String message;

    /**
     * Default constructor for Exception
     */
    public HeaderException() {

    }

    /**
     * Default constructor for Exception that takes in a message
     * 
     * @param messageIn
     */
    public HeaderException(String messageIn) {
        this.message = messageIn;
    }

    /**
     * Returns the message in the exception
     * 
     * @return String
     */
    public String getMessage() {
        return this.message;
    }

}
