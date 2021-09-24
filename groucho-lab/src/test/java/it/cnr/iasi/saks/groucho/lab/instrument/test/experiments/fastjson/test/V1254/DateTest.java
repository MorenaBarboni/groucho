/*FastJSON V 1.2.54*/
package it.cnr.iasi.saks.groucho.lab.instrument.test.experiments.fastjson.test.V1254;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * This class is a re-implementation of the original Unit Test:
 *  com.alibaba.json.bvt.serializer.date.DateTest
 * distributed with Fastjson 1.2.54
 */

public class DateTest extends TestCase {

    Date date;

    public void configure(Date d){
         this.date = d;
    }

    @Test
    public void test_date() throws Exception {

        Date date = this.date;
        long millis = date.getTime();
        String stringMillis = Long.toString(millis);

        Assert.assertEquals(stringMillis, JSON.toJSONString(date));
        Assert.assertEquals("new Date("+stringMillis +")", JSON.toJSONString(date, SerializerFeature.WriteClassName));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate ="\""+ sdf.format(date)+"\"";
        Assert.assertEquals(formattedDate, JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDate2 ="\""+ sdf2.format(date)+"\"";
        Assert.assertEquals(formattedDate2, JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS"));

        String formattedDate3 ="\'"+ sdf2.format(date)+"\'";
         Assert.assertEquals(formattedDate3, JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS",
                                                SerializerFeature.UseSingleQuotes));
    }
}
