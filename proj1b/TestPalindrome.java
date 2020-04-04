import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("spyderedyps"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("aaaaaab"));
    }

    @Test
    public void testIsPalindromeComp(){
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("flke", cc));
        assertFalse(palindrome.isPalindrome("a", cc));
        assertFalse(palindrome.isPalindrome("naveen", cc));
    }
}
