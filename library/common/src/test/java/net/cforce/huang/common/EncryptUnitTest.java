package net.cforce.huang.common;


import net.cforce.huang.common.utils.EncryptUtils;

import org.junit.Test;

/**
 *
 * Created by huang on 2016/9/23.
 */
public class EncryptUnitTest {

    @Test
    public void encryptMD2ToStringTest(){
        EncryptUtils.encryptMD2ToString("");
    }

    @Test
    public void encryptMD5ToStringTest(){
        EncryptUtils.encryptMD5ToString("");
    }
}
