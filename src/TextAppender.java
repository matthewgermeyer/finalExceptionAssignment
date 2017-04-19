public interface TextAppender {
    void open(String key) throws AlreadyExistsException;
    void append(String key, String text) throws DoesNotExistException, CannotAppendException;
    void flush(String key) throws DoesNotExistException;
    void close(String key) throws DoesNotExistException, NeedsFlushException;
}
