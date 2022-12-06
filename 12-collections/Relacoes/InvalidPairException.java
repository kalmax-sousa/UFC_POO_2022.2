class InvalidPairException extends Exception {
    InvalidPairException() {
        super();
    }
    InvalidPairException(String msg) {
        super(msg);
    }
    InvalidPairException(String msg, Throwable obj) {
        super(msg, obj);
    }
    InvalidPairException(Throwable obj) {
        super(obj);
    }
}