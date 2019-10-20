import static org.junit.Assert.*;
import org.junit.Test;


public class FlikTest {

    @Test
    public void testIsSameNo(){
        assertTrue(Flik.isSameNumber(new Integer(0), new Integer(0)));
        assertFalse(Flik.isSameNumber(new Integer(0), new Integer(1)));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}
