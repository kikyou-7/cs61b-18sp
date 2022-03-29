public class OffByN implements CharacterComparator {
    public static int diff;
    public OffByN(int n) {
        diff = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int d = x - y;
        return (d == diff) || (-d == diff);
    }
}
