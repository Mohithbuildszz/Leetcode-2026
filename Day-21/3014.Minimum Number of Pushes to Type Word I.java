class Solution {
    public int minimumPushes(String word) {
        int Pushes = 0;
        for(int itr = 0; itr < word.length(); itr++ ){
            Pushes += (itr / 8) + 1 ;
        }
        return Pushes;
    }
}
