import org.junit.Assert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CRC32Test {

    private static CRC32 checksum;
    byte bytes[];

    @BeforeAll
    static void setUp() {
        checksum = new CRC32();
    }

    @AfterEach
    void tearDown() {
        checksum.reset();
    }

    @Test
    void getValue() {
        Assert.assertEquals(0, checksum.getValue());
    }

    @Test
    void reset() {
        Assert.assertEquals(0, checksum.getValue());
    }


    @ParameterizedTest
    @ValueSource(strings = "Hello world!")
    void update1(String str) {
        bytes = str.getBytes();
        checksum.update(bytes);
        Assert.assertEquals(461707669L, checksum.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = "Hello world!")
    void Update2(String str) {
        bytes = str.getBytes();
        checksum.update(bytes, 0, bytes.length);
        Assert.assertEquals(461707669L, checksum.getValue());
    }

    @ParameterizedTest
    @ValueSource(chars = '!')
    void Update3(int c) {
        String truncated = "Hello world";
        bytes = truncated.getBytes();
        checksum.update(bytes);
        checksum.update(c);
        Assert.assertEquals(461707669L, checksum.getValue());
    }
}