import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN {

    @Test
    public void testEqualChars(){
        OffByN cmp = new OffByN(5);
        assertTrue(cmp.equalChars('a', 'f'));
        assertTrue(cmp.equalChars('f', 'a'));
        assertFalse(cmp.equalChars('f', 'h'));
    }
}
