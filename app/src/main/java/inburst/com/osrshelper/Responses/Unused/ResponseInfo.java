package inburst.com.osrshelper.Responses.Unused;

public class ResponseInfo {
    private final String name;

    private final int store;

    public ResponseInfo(String name, int store) {
        this.name = name;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public int getStore() {
        return store;
    }
}
