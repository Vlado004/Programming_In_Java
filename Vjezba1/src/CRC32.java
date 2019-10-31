
public class CRC32 implements Checksum {
    private int crc;
    private long[] table;

    CRC32() {
        long rem;
        table = new long[256];
        for (int i = 0; i < 256; i++) {
            rem = i;
            for (int j = 0; j < 8; j++) {
                if ((rem & 1) == 1) {
                    rem >>>= 1;
                    rem ^= 0xedb88320;
                } else {
                    rem >>>= 1;
                }
            }
            table[i] = rem;
        }
    }

    @Override
    public void update(byte[] bytes, int crc_value, int size) {
        crc = ~crc_value;

        for (int i = 0; i < size; i++) {
            crc = (int)((crc >>> 8) ^ table[(crc & 0xff) ^ bytes[i]]);
        }

        crc = ~crc;
    }

    @Override
    public long getValue() {
        return crc;
    }

}
