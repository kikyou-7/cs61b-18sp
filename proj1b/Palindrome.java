public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> ret = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ret.addLast(word.charAt(i));
        }
        return ret;
    }
    public boolean isPalindrome(String word) {
        int n = word.length();
        Deque<Character> dequeWord = wordToDeque(word);
        while (!dequeWord.isEmpty()) {
            Character f1 = dequeWord.removeFirst();
            if (dequeWord.isEmpty()) {
                break;
            }
            Character f2 = dequeWord.removeLast();
            if (f1 != f2) {
                return false;
            }
        }
        return true;
        /* for (int i = 0; i< n; i++) {
            if (word.charAt(i) != word.charAt(n-i-1)) {
                return false;
            }
        }
        return  true;*/
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int n = word.length();
        Deque<Character> dequeWord = wordToDeque(word);
        OffByOne obo = new OffByOne();
        while (!dequeWord.isEmpty()) {
            Character f1 = dequeWord.removeFirst();
            if (dequeWord.isEmpty()) {
                break;
            }
            Character f2 = dequeWord.removeLast();
            if (!obo.equalChars(f1, f2)) {
                return false;
            }
        }
        return true;
    }
}
