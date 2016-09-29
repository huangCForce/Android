package net.cforce.huang.common;


import net.cforce.huang.common.utils.RegexUtils;

import org.junit.Assert;
import org.junit.Test;

import static net.cforce.huang.common.utils.ConstUtils.REGEX_IP;


/**
 *
 * Created by huang on 2016/9/23.
 */
public class RegexUnitTest {

    @Test
    public void isMobileTest(){
        Assert.assertTrue(RegexUtils.isMobileSimple("13700000000"));
        Assert.assertTrue(RegexUtils.isMobileExact("13700000000"));
        Assert.assertTrue(RegexUtils.isTel("06685558878"));
    }

    @Test
    public void isIDCardTest(){
        Assert.assertTrue(RegexUtils.isIDCard15("130503670401001"));
        Assert.assertTrue(RegexUtils.isIDCard18("430700198805112726"));
    }

    @Test
    public void otherTest(){
        Assert.assertTrue(RegexUtils.isEmail("690910789@qq.com"));
        Assert.assertTrue(RegexUtils.isURL("http://www.baidu.com/"));
        Assert.assertTrue(RegexUtils.isChz("黄"));
        Assert.assertTrue(RegexUtils.isUsername("430700198805112726"));
        Assert.assertTrue(RegexUtils.isDate("2015-12-12"));
        Assert.assertTrue(RegexUtils.isIP("192.168.8.1"));
        Assert.assertTrue(RegexUtils.isMatch(REGEX_IP,"192.168.8.1"));
    }
}
