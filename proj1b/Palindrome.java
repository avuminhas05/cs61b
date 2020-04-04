public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> dq = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word) {
        Deque dq1 = wordToDeque(word);
        Deque dq2 = wordToDeque(word);
        while(!dq1.isEmpty()){
            if(dq1.removeFirst() != dq2.removeLast())
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque dq1 = wordToDeque(word);
        Deque dq2 = wordToDeque(word);
        for(int i = 0; i < word.length(); i++){
            boolean areEqual = cc.equalChars((char)dq1.removeFirst(), (char)dq2.removeLast());
            if(!areEqual && !isMidIndex(i, word.length()))
                return false;
        }
        return true;
    }

    /* Return true if given index is middle index of an array of given length */
    private boolean isMidIndex(int index, int length){
        if((length % 2) == 0)
            return false;
        return index == length/2;
    }
}
