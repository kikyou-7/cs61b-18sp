import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        String[] pairAC = {"ab", "yz", "AB", "89"};
        String[] pairWA = {"ac", "aa", "Aq", "99"};
        for (String p : pairAC) {
            assertTrue(offByOne.equalChars(p.charAt(0), p.charAt(1)));
        }
        for (String p : pairWA) {
            assertFalse(offByOne.equalChars(p.charAt(0), p.charAt(1)));
        }
    }
}
