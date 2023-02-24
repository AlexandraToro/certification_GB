package catalog;

public class counter implements AutoCloseable{
    public static int count = 0;
    public int add(){
        return count++;
    }

    @Override
    public void close() throws RuntimeException {

    }
}
