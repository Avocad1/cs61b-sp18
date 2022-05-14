public class OffByN implements CharacterComparator {
    private int intN;
    public OffByN(int N){
        intN = N;
    }
    public boolean equalChars(char x, char y){
        if (Math.abs(x - y) == intN)
            return true;
        return false;
    }
}
