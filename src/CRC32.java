
public class CRC32 implements Checksum {
    private long crc, rem;
    private long table[];
    private boolean table_made = false;

    CRC32() {
        if (!table_made) {
            table = new long[256];
            for (int i = 0; i < 256; i++) {
                rem = i;
                for (int j = 0; j < 8; j++) {
                    if ((rem & 1) == 1) {
                        rem >>= 1;
                        rem ^= 0xedb88320;
                    } else {
                        rem >>= 1;
                    }
                }
                table[i] = rem;
            }
            table_made = true;
        }
    }

    public void update(byte bytes[], int crc_value, int size) {
        crc = ~crc_value;

        for (int i = 0; i < size; i++) {
            crc = ((crc >> 8) ^ table[(int)(crc & 0xff) ^ bytes[i]]);
        }

        crc = ~crc;
    }

    public long getValue() {
        return crc;
    }

}
