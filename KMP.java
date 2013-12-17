
public class KMP {
	
	public static int find(String s, String p){
		int result = -1;
		int M = p.length();
		int[]next = new int[M];
		for(int i=0;i<M;i++){
			next[i] = PrefixSuffixMaxMatch(s.substring(0, i+1));
			
		}
		int i;
		for(i=0;i<s.length();){
			int j;
			for(j=0;j<M;){
				if(p.charAt(j)==s.charAt(i)){
					++i;++j;
				} else if(j==0){
					++i;
				} else {
					j=next[j];
				}
			}
			if(j==M)
				return i-M;
		}
		return result;
	}
	
	private static int PrefixSuffixMaxMatch(String s){		
		int n = s.length();
		if(n<=1)return 0;
		String[] prefix = new String[n-1];
		String[] suffix = new String[n-1];
		for(int i=0;i<n-1;i++){
			prefix[i] = s.substring(0,i+1);
			suffix[i] = s.substring(n-i-1);
			
			if(prefix[i].compareTo(suffix[i])==0){
				return i+1;
			}
		}
		return 0;
	}
}
