import org.junit.Test;

import static org.junit.Assert.*;

public class TestOfTime {

    @Test
    public void test1(){
        Time timeStore = new Time("14:00:00");
        assertEquals("is time stored", "14:00:00", timeStore.toString());
    }

    @Test
    public void test2(){
        Time testSubtract1 = new Time("6:50");
        Time testSubtract2 = new Time("7:19");
        Duration difference = testSubtract2.subtract(testSubtract1);

        assertEquals("does subtract work", 29, difference.intValue("minute"));
    }

    @Test
    public void test3(){
        Time testZero = new Time("6:50");
        Duration zeroDifference = testZero.subtract(testZero);

        assertEquals("subtracting time form itself returns zero", 0, zeroDifference.intValue("minute"));
    }

    @Test
    public void test4(){
        Time testSubtract1 = new Time("6:50");
        Time testSubtract2 = new Time("6:55");
        Duration difference = testSubtract2.subtract(testSubtract1);

        assertEquals("intValue with millisecond", 300000, difference.intValue("millisecond"));
    }

    @Test
    public void test5(){
        Time testSubtract1 = new Time("13:17");
        Time testSubtract2 = new Time("13:27");
        Duration difference = testSubtract2.subtract(testSubtract1);

        assertEquals("intValue with second", 600, difference.intValue("second"));
    }

    @Test
    public void test6(){
        Time testSubtract1 = new Time("6:50");
        Time testSubtract2 = new Time("8:00");
        Duration difference = testSubtract2.subtract(testSubtract1);

        assertEquals("intValue with minute", 70, difference.intValue("minute"));
    }

    @Test
    public void test7(){
        Time testSubtract1 = new Time("6:00");
        Time testSubtract2 = new Time("8:00");
        Duration difference = testSubtract2.subtract(testSubtract1);

        assertEquals("intValue with hour", 2, difference.intValue("hour"));
    }
}
