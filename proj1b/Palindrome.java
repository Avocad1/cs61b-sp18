public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> returnDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            char firstWord = word.charAt(i);
            returnDeque.addLast(firstWord);
        }
        return returnDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d1 = wordToDeque(word);
        return isPalindrome(d1);
    }

    private boolean isPalindrome(Deque d1){
        if (d1.size() == 1){
            return true;
        }
        if (d1.size() == 0){
            return true;
        }
        if (d1.removeFirst() != d1.removeLast()) {
            return false;
        } else {
            return isPalindrome(d1);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d1 = wordToDeque(word);
        while (d1.size() > 1) {
            if (!cc.equalChars(d1.removeFirst(), d1.removeLast()))
                return false;
        }
        return true;
    }
}
