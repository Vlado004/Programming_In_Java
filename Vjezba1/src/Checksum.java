
public interface Checksum {

    void update(byte[] bytes, int start, int size);
    long getValue();

}