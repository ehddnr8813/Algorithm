package kakao;

import java.util.Arrays;
import java.util.HashSet;

public class Solution4 {

	static long min= 1;
	static HashSet<Long> set= new HashSet<>();
	
	public static void main(String[] args) {
		solution(10, new long[]{8,8,1,1,1,1});
	}
	
    public static long[] solution(long k, long[] room_number) {
    	long[] answer = new long[room_number.length];
        for(int i=0; i<room_number.length; i++){
        	if(set.contains(room_number[i])){
        		if(room_number[i]>min){
        			while(true){
        				if(set.contains(room_number[i])){
        					room_number[i]++;
        				}
        				else{
        					set.add(room_number[i]);
        					answer[i]=room_number[i];
        					break;
        				}
        			}
        		}
        		else{
            		answer[i]=min;
            		set.add(min);
                	while(true){
                		if(set.contains(min)){
                			min++;
                		}
                		else break;
                	}
        		}
        	}
        	else{
        		set.add(room_number[i]);
        		answer[i]=room_number[i];
        		if(room_number[i]==min){
                	while(true){
                		if(set.contains(min)){
                			min++;
                		}
                		else break;
                	}
        		}
        	}
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
