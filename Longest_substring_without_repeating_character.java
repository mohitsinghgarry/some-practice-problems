class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0 , max = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            if(set.contains(s.charAt(i))){
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(start ++));
                }
                set.add(s.charAt(i));
            }
            else{
                set.add(s.charAt(i));
            }
            max = Math.max(max , set.size());
        }
        return max;
    }
}