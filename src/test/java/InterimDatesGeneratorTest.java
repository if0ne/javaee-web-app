import org.junit.Assert;
import org.junit.Test;
import ru.rsreu.javaeewebapp.util.InterimDatesGenerator;

import java.sql.Date;
import java.util.List;

public class InterimDatesGeneratorTest {

    @Test
    public void Test1() {
        Date begin = new Date(2021-1900, 10, 20);
        Date end = new Date(2021-1900, 10, 22);
        int day = 3;

        List<Date> dates = InterimDatesGenerator.getInterimDatesBetween(begin, end, day);

        Assert.assertEquals(0, dates.size());
    }

    @Test
    public void Test2() {
        Date begin = new Date(2021-1900, 10, 20);
        Date end = new Date(2021-1900, 11, 4);
        int day = 7;

        List<Date> dates = InterimDatesGenerator.getInterimDatesBetween(begin, end, day);

        Assert.assertEquals(2, dates.size());
    }

    @Test
    public void Test3() {
        Date begin = new Date(2021-1900, 10, 20);
        Date end = new Date(2021-1900, 11, 5);
        int day = 7;

        List<Date> dates = InterimDatesGenerator.getInterimDatesBetween(begin, end, day);

        Assert.assertEquals(3, dates.size());
    }

    @Test
    public void Test4() {
        Date begin = new Date(2021-1900, 11, 12);
        Date end = new Date(2022-1900, 0, 9);
        int day = 5;

        List<Date> dates = InterimDatesGenerator.getInterimDatesBetween(begin, end, day);

        Assert.assertEquals(4, dates.size());
    }

    @Test
    public void Test5() {
        Date begin = new Date(2021-1900, 10, 25);
        Date end = new Date(2021-1900, 10, 22);
        int day = 3;

        List<Date> dates = InterimDatesGenerator.getInterimDatesBetween(begin, end, day);

        Assert.assertEquals(0, dates.size());
    }
}
