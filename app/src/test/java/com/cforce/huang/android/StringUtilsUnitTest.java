package com.cforce.huang.android;

import com.cforce.huang.android.utils.StringUtils;

import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * Created by huang on 2016/9/23.
 */
public class StringUtilsUnitTest {

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(StringUtils.isEmpty(""));
        Assert.assertTrue(!StringUtils.isEmpty("2"));
    }

    @Test
    public void isSpaceTest(){
        Assert.assertTrue(StringUtils.isSpace(" "));
        Assert.assertTrue(!StringUtils.isSpace(" 1"));
    }

    @Test
    public void null2Length0Test(){
        Assert.assertEquals("", StringUtils.null2Length0(null));
    }

    @Test
    public void upperFirstLetterTest(){
        Assert.assertEquals("Hello", StringUtils.upperFirstLetter("hello"));
    }

    @Test
    public void lowerFirstLetterTest(){
        Assert.assertEquals("hello", StringUtils.lowerFirstLetter("Hello"));
    }

    @Test
    public void reverseTest(){
        Assert.assertEquals("abc", StringUtils.reverse("cba"));
    }

    @Test
    public void getPYFirstLetterTest(){
        Assert.assertEquals("h", StringUtils.getPYFirstLetter("黄"));
    }

    @Test
    public void cn2PYTest(){
        Assert.assertEquals("huang", StringUtils.cn2PY("黄"));
    }
}
