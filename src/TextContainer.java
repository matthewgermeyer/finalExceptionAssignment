public class TextContainer {
    public String key;
    public String text;
    public boolean flushed;
    //Constructor (String key)
    public TextContainer(String key) {
        this.key = key;
    }
    //Getters for Key and flushed
    public String getKey() {
        return key;
    }
    public boolean isFlushed() {
        return flushed;
    }
    //Methods
    //append
    public void append(String text){
        this.text = this.text + text;
        this.flushed = false;
    }
    //flush
    public void flushed(){
        this.flushed = true;
    }
}
