
public interface Checksum {

    void update(byte bytes[], int crc_value, int size);
    long getValue();

}