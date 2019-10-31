
public interface Checksum {

    long getValue();
    void reset();
    void update(byte[] bytes);
    void update(byte[] bytes, int crc_value, int size);
    void update(int bytes);

}