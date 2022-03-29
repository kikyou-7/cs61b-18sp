import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < "persiflage".length(); i++) {
            actual.append(d.removeFirst());
        }
        assertEquals("persiflage", actual.toString());
    }
    @Test
    public void testIsPalindrome() {
        String[] wordsAC = {"abba", "a", "", "abcdcba", "AA"};
        String[] wordsWA = {"abbA", "ab", "ac", "abdcba", "aA"};
        for (String word : wordsAC) {
            assertTrue(palindrome.isPalindrome(word));
        }
        for (String word : wordsWA) {
            assertFalse(palindrome.isPalindrome(word));
        }
    }
    @Test
    public void testIsPalindromeObo() {
        String[] wordsAC = {"abab", "a", "", "ADB", "ABCDBCB"};
        String[] wordsWA = {"abbA", "ac", "acc", "aa", "aaa"};
        OffByOne obo = new OffByOne();
        for (String word : wordsAC) {
            assertTrue(palindrome.isPalindrome(word, obo));
        }
        for (String word : wordsWA) {
            assertFalse(palindrome.isPalindrome(word, obo));
        }
    }

    @Test
    public void testIsPalindromeObn() {
        String[] wordsAC = {"ae", "abfe", "", "a", "AAE"};
        String[] wordsWA = {"abbA", "ac", "acc", "aa", "aaa"};
        OffByN obn = new OffByN(4);
        for (String word : wordsAC) {
            assertTrue(palindrome.isPalindrome(word, obn));
        }
        for (String word : wordsWA) {
            assertFalse(palindrome.isPalindrome(word, obn));
        }
    }
}
