public class OffByN implements CharacterComparator {

    private int offBy;

    public OffByN(int N){
        offBy = N;
    }

    @Override
    public boolean equalChars(char a, char b){
        return Math.abs(a - b) == offBy;
    }
}
