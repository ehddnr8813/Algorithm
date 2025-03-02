package kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {

	static ArrayList<Integer> list= new ArrayList<>();
	static boolean visited[]=new boolean[8];
	static boolean visited2[]=new boolean[8];
	static int answer, count, total;
	static boolean flag;
	
	
	public static void main(String[] args) {
		solution(new String[]{"frodo", "abc123", "crodo", "fradi", "frodoc"}, new String[]{"*r*d*", "abc1**"});
		System.out.println(answer);
	}
	
    public static int solution(String[] user_id, String[] banned_id) {
    	count=banned_id.length;
    	answer=0;
    	dfs2(user_id, banned_id, 0,0);
    	
        return answer;
    }
    private static void dfs2(String[] user_id, String[] banned_id, int idx, int c) {
		if(c==count){
			total=0;
			int index=0;
			String[] newUser= new String[count];
			for(int i=0; i<user_id.length; i++){
				if(visited2[i]){
					newUser[index]=user_id[i];
					index++;
				}
			}
			for(int i=0; i<newUser.length;i++){
				flag=false;
				dfs(newUser[i], banned_id,0, newUser[i].length());
				if(flag)System.out.println(Arrays.toString(newUser));
			}
			if(total==count)answer++;
			return;
		}
		for(int i=idx; i<user_id.length; i++){
			if(!visited2[i]){
				visited2[i]=true;
				dfs2(user_id, banned_id, i+1, c+1);
				visited2[i]=false;
			}
		}
	}

	static void dfs(String a, String[] b,int index, int len){
    	if(flag)return;
    	isMatch(a, b);
    	if(index==len-1){
    		return;
    	}
    	for(int i=index;i<len; i++){
    		if(!visited[i]){
    			visited[i]=true;
    			dfs(a,b,i+1, len);
    			visited[i]=false;
    		}
    	}
    }

	private static void isMatch(String ex, String[] ori) {
		String str= new String(ex);
		for(int i=0; i<str.length(); i++){
			if(visited[i])
				str= str.substring(0,i)+'*'+str.substring(i+1);
		}
		System.out.println(str);
		for(String s : ori){
			if(str.equals(s)){
				total++;
				flag=true;
			}
			break;
		}
	}
} 
