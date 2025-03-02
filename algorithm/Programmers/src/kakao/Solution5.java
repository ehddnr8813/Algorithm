package kakao;

public class Solution5 {

	static int count, answer;
	static int zeroTotal;
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{0,2,3,1,0,0,2,0,3,0}, 3));

	}
    public static int solution(int[] stones, int k) {
    	for(int i=0; i<stones.length; i++){
    		if(stones[i]==0){
    			int index=i;
    			count=1;
    			while(true){
    				if(--index<0)break;
    				if(stones[index]==0)count++;
    				else break;
    				if(count==k)return 0;
    			}
    			index=i;
    			count=1;
    			while(true){
    				if(++index==stones.length)break;
    				if(stones[index]==0)count++;
    				else break;
    				if(count==k)return 0;
    			}
    		}
    	}
    	
 loop:   while(true){
	 		answer++;		
        	for(int i=0; i<stones.length; i++){
        		if(stones[i]==0)continue;
        		if(--stones[i]==0){
        			int index=i;
        			count=1;
        			while(true){
        				if(--index<0)break;
        				if(stones[index]==0)count++;
        				else break;
        				if(count==k)break loop;
        			}
        			index=i;
        			count=1;
        			while(true){
        				if(++index==stones.length)break;
        				if(stones[index]==0)count++;
        				else break;
        				if(count==k)break loop;
        			}
        			zeroTotal++;
        			if(zeroTotal==stones.length)return answer;
        		}
        	}
    	}
        return answer;
    }
}
