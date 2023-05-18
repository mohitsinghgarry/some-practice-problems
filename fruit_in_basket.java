class Solution {
    public int totalFruit(int[] fruits) {
        return maxSubarrayWithDistinctCharacters(fruits,2);
    }
    public int maxSubarrayWithDistinctCharacters(int []arr,int k){
		int windowStart=0;
		int maxLength=Integer.MIN_VALUE;
		Map<Integer,Integer> map=new HashMap<>();
		for(int windowEnd=0; windowEnd<arr.length;windowEnd++)
		{
			int  currTree=arr[windowEnd];
			map.put(currTree, map.getOrDefault(currTree,0)+1);
			while(map.size()>k)
			{
				int leftChar=arr[(windowStart)];
				windowStart++;
				map.put(leftChar, map.get(leftChar)-1);
				if(map.get(leftChar)==0)
				{
					map.remove(leftChar);
				}
			}
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
	}
}