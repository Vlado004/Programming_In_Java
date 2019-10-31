
public class CRC32 implements Checksum {
    private int crc;
    private long[] table;

    CRC32() {
        crc = 0;
    }

    @Override
    public void update(byte[] b, int start, int size) {
        crc = 0xFFFFFFFF;

        for (int i = 0; i < size; i++) {
            int tmp = (crc ^ b[start + i]) & 0xFF;

            for (int j = 0; j < 8; j++) {
                if ((tmp & 1) == 1) {
                    tmp = (tmp >>> 1) ^ 0xEDB88320;
                } else {
                    tmp = (tmp >>> 1);
                }
            }
            crc = (crc >>> 8) ^ tmp;
        }
        crc = ~crc;
    }

    @Override
    public long getValue() {
        return crc & (long)(Math.pow(2, 32)-1);
    }

}
