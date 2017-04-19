//        Write test cases that exercise both the green path and all exceptions in the main method of Main.
public class TextAppenderImpl implements TextAppender {
    private TextContainer[] list = new TextContainer[10];

    @Override
    public void open(String key) throws AlreadyExistsException {
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null && list[i].getKey().equals((key))) {
                throw new AlreadyExistsException("key already exists");
            }
        }
        TextContainer tc = new TextContainer(key);
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == null) {
                list[i] = tc;
                break;
            }
        }
    }

    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null && list[i].getKey().equals(key)) {
                list[i].append(text);
                return;
            }
        }
        throw new DoesNotExistException("Could not match the key " + key);
    }

    @Override
    public void flush(String key) throws DoesNotExistException {

        // look through the list, for a key match, if found, flush it.
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null && list[i].getKey().equals(key)) {
                list[i].flushed();
                return;
            }
        }
        throw new DoesNotExistException("Could not match the key " + key);
    }

    @Override
    public void close(String key) throws DoesNotExistException, NeedsFlushException {
        boolean found = false;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null && list[i].getKey().equals(key)) {
                found = true;
                if (!list[i].isFlushed()) {
                    throw new NeedsFlushException("Must flush first");
                }
            }
        }
        if (found == false) {
            throw new DoesNotExistException("Could not match the key " + key);
        }

    }
}