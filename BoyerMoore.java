
public class BoyerMoore {
	private static char[] patChars;
	private static int[] right;
	public static int find(String target,String pattern){
		if(isEmpty(target)||isEmpty(pattern))
			return -1;
		if(target.length()<pattern.length())
			return -1;
		
		patChars = build(pattern);
		right = new int[patChars.length];
		for(int i=0;i<pattern.length();i++){
			right[getPosition(pattern.charAt(i))]=i;
		}
		
		int N = target.length();
		int M = pattern.length();
		int skip=0;
		for(int i=0;i<=N-M;i+=skip){
			skip=0;
			for(int j=M-1;j>=0;j--){
				if(pattern.charAt(j)!=target.charAt(i+j)){
					int p = getPosition(target.charAt(i+j));
					if(p==-1)skip = j-p;
					else skip = j-right[p];
					if(skip<1)skip=1;
					break;
				}
			}
			if(skip==0)return i;
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
