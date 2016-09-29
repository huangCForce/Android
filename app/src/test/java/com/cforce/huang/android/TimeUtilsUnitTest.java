package com.cforce.huang.android;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * Created by huang on 2016/9/23.
 */
public class TimeUtilsUnitTest {

    @Test
    public void milliseconds2StringTest(){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Assert.assertEquals(TimeUtils.getCurTimeDate(), new Date());
        Assert.assertEquals(TimeUtils.getCurTimeString(), TimeUtils.milliseconds2String(TimeUtils.getCurTimeMills()));
        Assert.assertEquals(TimeUtils.getCurTimeString(DATE_FORMAT), TimeUtils.milliseconds2String(TimeUtils.getCurTimeMills(), DATE_FORMAT));
        Assert.assertEquals("2016-09-23", TimeUtils.milliseconds2String(TimeUtils.getCurTimeMills(), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())));
    }

    @Test
    public void string2MillisecondsTest(){
        TimeUtils.string2Milliseconds("2016-09-23 12:23:34");
        TimeUtils.string2Milliseconds("2016-09-23", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
    }

    @Test
    public void string2DateTest(){
        TimeUtils.string2Date("2016-09-23 12:23:34");
        TimeUtils.string2Date("2016-09-23", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
    }

    @Test
    public void date2StringTest(){
        TimeUtils.date2String(new Date());
        TimeUtils.date2String(new Date(), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
    }

    @Test
    public void getIntervalTest(){

        TimeUtils.getIntervalTime("2016-09-23 12:34:56", "2016-09-24 12:23:34", ConstUtils.TimeUnit.DAY);
        TimeUtils.getIntervalTime(new Date(), new Date(), ConstUtils.TimeUnit.DAY);
        TimeUtils.getIntervalTime("2016-09-23", "2016-09-24", ConstUtils.TimeUnit.DAY, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
        TimeUtils.getIntervalByNow("2016-09-25", ConstUtils.TimeUnit.DAY);
        TimeUtils.getIntervalByNow("2016-09-25", ConstUtils.TimeUnit.DAY, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
        TimeUtils.getIntervalByNow(new Date(), ConstUtils.TimeUnit.DAY);
    }

    @Test
    public void timeTest(){
        Assert.assertTrue(TimeUtils.isLeapYear(2016));
        TimeUtils.milliseconds2Date(TimeUtils.getCurTimeMills());
        TimeUtils.date2Milliseconds(new Date());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = null;
        try {
            date = formatter.parse("2016-01-02");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println("Week number: " + calendar.get(Calendar.WEEK_OF_YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
