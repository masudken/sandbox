package jp.co.gfam.gits.common.crypto;

import static org.junit.Assert.*;

import org.junit.Test;

public class CipherUtilsTest {

    @Test
    public void testEncrypt001() {
        assertEquals("2lYsoYjnKwzGXHZ8Nwzfew==", CipherUtils.encrypt("haruka"));
        assertEquals("vEPG2n0GV6NbmjqHODugFA==", CipherUtils.encrypt("1234"));
        assertEquals("ZMflASUtMYQdAxxzY4OMAQ==", CipherUtils.encrypt("tet"));
        assertEquals("tet", CipherUtils.decrypt(CipherUtils.encrypt("tet")));
        assertEquals("", CipherUtils.decrypt(CipherUtils.encrypt("abc")));
        assertEquals("", CipherUtils.decrypt(CipherUtils.encrypt("1234567")));
    }
}
