/**
 * Implementation of Knuth-Morris-Pratt Algorithm using DFA(deterministic finite-state automaton)
 * */
public class KMP_DFA {
	/**
	 * Find the first occurrence of pattern in target
	 * @param target
	 * @param pattern
	 * @return the position of first occurrence
	 */
	
	private static char[] patChars;
	public static int find(String target,String pattern){
		if(isEmpty(target)||isEmpty(pattern))
			return -1;
		if(target.length()<pattern.length())
			return -1;
		
		patChars = build(pattern);
		
		//----------------------TEST CODE START-------------------------
		System.out.print("pattern chars:\n");
		for(int i=0;i<patChars.length;i++){
			System.out.print(patChars[i]+" ");
		}
		System.out.print("\n");
		
		for(int i=0;i<patChars.length;i++){
			System.out.print(getPosition(patChars[i])+" ");
		}
		System.out.print("\n");
		//----------------------TEST CODE END-------------------------
		
		int[][] dfa =new int[patChars.length][pattern.length()];
		
		int j=0;
		int x=0;
		for(int i=0;i<patChars.length;i++){
			dfa[getPosition(pattern.charAt(i))][j] = 0;
		}
		for(j=0;j<pattern.length();++j){
			for(int i=0;i<patChars.length;i++){
				dfa[getPosition(pattern.charAt(i))][j] = dfa[getPosition(pattern.charAt(i))][x];
			}
			dfa[getPosition(pattern.charAt(j))][j]=j+1;
			x=dfa[getPosition(pattern.charAt(j))][x];
		}
		//----------------------TEST CODE START-------------------------
		System.out.print("  ");
		for(j=0;j<pattern.length();j++){
			System.out.print(pattern.charAt(j) +" ");
		}
		System.out.print("\n");
		for(int i=0;i<patChars.length;i++){
			System.out.print(patChars[i]+" ");
			for(j=0;j<pattern.length();j++){
				System.out.print(dfa[i][j]+" ");
			}
			System.out.print("\n");
		}
		//----------------------TEST CODE END-------------------------
		int state = 0;
		for(int i=0;i<target.length();i++){
			char ch = target.charAt(i);
			int p = getPosition(ch);
			if(p==-1)
				state = 0;
			else
				state = dfa[p][state];
			System.out.print(ch+":"+state);
			System.out.print("\n");
			if(state == pattern.length())
				return i-state+1;
		}
		return -1;
	}
	
	
	private static int getPosition(char ch){
		int length = patChars.length;
		int start = 0;
		int end = length-1;
		int pos = (start+end)/2;
		while(start!=end){
			if(ch>patChars[pos]){
				start = pos+1;
			} else {
				end = pos;
			}
			pos = (start+end)/2;
		}
		if(patChars[pos]==ch)return pos;
				
		return -1;
	}
	
	private static char[] build(String pattern){
		if(isEmpty(pattern))return null;
		char[] tmp = new char[pattern.length()];
		
		int length=0;
		for(int i=0;i<pattern.length();i++){
			if(insert(tmp,pattern.charAt(i),length))
				length++;
		}
		char[] result = new char[length];
		for(int i=0;i<length;i++){
			result[i] = tmp[i];
		}
		return result;
	}

	private static boolean insert(char[] tmp, char ch,int length) {
		if(length==0){
			tmp[0] = ch;
			return true;
		}
		int start = 0;
		int end = length-1;
		int pos = (start+end)/2;
		while(start!=end){
			if(ch>tmp[pos]){
				start = pos+1;
			} else {
				end = pos;
			}
			pos = (start+end)/2;
		}
		
		if(tmp[pos]==ch)return false;
		
		if(ch>tmp[start]){
			insertPos(tmp,ch,start+1);
		} else {
			insertPos(tmp,ch,start);
		}
		return true;		
	}
	private static void insertPos(char[] tmp,char ch,int pos){
		int n=tmp.length;
		for(int i=n-1;i>pos;--i){
			tmp[i] = tmp[i-1];
		}
		tmp[pos]=ch;
	}


	private static boolean isEmpty(String s){
		if(s==null||s.length()==0){
			return true;
		}
		return false;
	}
}
