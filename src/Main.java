
public class Main {

    public static void main(String[] args) {
        //Constructor for tai.  TextAppenderImpl
        TextAppenderImpl tai = new TextAppenderImpl();


        //Trying open
        try {
            System.out.println("opening one..");
            tai.open("one");
            System.out.println("we opened one");
        } catch (AlreadyExistsException e) {
            System.out.println("something has gone wrong");
        }
        try {
            System.out.println("opening one.. again");
            tai.open("one");
            System.out.println("We shouldnt see this..its already open.");
        } catch (AlreadyExistsException e) {
            System.out.println("exception.. one opened twice.  this is good");
        }

        //Trying append to one, which exists.
        try {
            System.out.println("Appending to 'one' ");
            tai.append("one", "I love soccer");
            System.out.println("seems like it worked");
        } catch (DoesNotExistException e) {
            System.out.println("bad! Could not append to One");
        } catch (CannotAppendException e) {
            System.out.println("bad things!! Could not append to ONe");
        }

        //Trying appending to garbage, which does not exist.
        try {
            System.out.println("Appending to 'garbage' ");
            tai.append("garbage", "I love soccer");
            System.out.println("ERROR - appended to garbage");
        } catch (DoesNotExistException e) {
            System.out.println("Caught the fact that garbage doesnt exist");
        } catch (CannotAppendException e) {
            System.out.println("bad things!! Could not append to garbage");
        }

        //Trying close.
        try {
            System.out.println("trying to close 'one' ");
            tai.close("one");
            System.out.println("ERROR - one exists should get NEEDFLUSHEXCEPTION");
        } catch (DoesNotExistException e) {
            System.out.println("ERROR - one exists, wHat?!");
        } catch (NeedsFlushException e) {
            System.out.println("Good - but need to flush still");
        }

        //Flush
        try {
            System.out.println("trying to flush 'one' ");
            tai.flush("one");
            System.out.println("Seems like it worked..");
        } catch (DoesNotExistException e) {
            System.out.println("ERROR - one exists, wHat?!");
        }
        //Close
        try {
            System.out.println("trying to close 'one' ");
            tai.close("one");
            System.out.println("That should work..");
        } catch (DoesNotExistException e) {
            System.out.println("ERROR - one exists, wHat?!");
        } catch (NeedsFlushException e) {
            System.out.println("Good - Cant close if we still need to flush");
        }
    }
}
