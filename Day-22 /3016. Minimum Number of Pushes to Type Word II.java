class Solution {
    public int minimumPushes(String word) {
        int arr[] = new int[26];
        for(char ch : word.toCharArray()){
            arr[ch -'a']++;
        } 
        Arrays.sort(arr);

        int postion = 0;
        int ans = 0;

        for(int i = 25; i>= 0; i--){
            if(arr[i] == 0) break;

        int push = (postion / 8) + 1;
        ans += arr[i] * push;
        postion++; 
        }
        return ans;
    }
}
