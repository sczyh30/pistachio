package org.samsara.pistachio.util;

import org.junit.Test;
import org.samsara.pistachio.entity.BookInfo;

import static org.junit.Assert.*;

/**
 * Json Util Test
 */
public class JsonUtilTest {

    @Test
    public void test() throws Exception {
        BookInfo bookInfo = new BookInfo("9787544276597", "丈量世界", "[德] 丹尼尔‧凯曼", DateUtil.toDate("2015-10-1"), "南海出版公司", 277, 1406);
        String jsonStr = JsonUtil.toJson(bookInfo);
        System.out.println(jsonStr);

        BookInfo b2 = JsonUtil.fromJson(jsonStr, BookInfo.class);
        System.out.println(b2);
    }

}