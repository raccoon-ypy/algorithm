
public class MSD {
	private static int R = 256;
//	private static String[] aux;
	
	public static String[] sort(String[] a){
		return sort(a,0,a.length,0);
	}
	private static String[] sort(String[] a,int start,int end,int pos){
		int N = end - start;
		if(N==0)return null;
		String[] aux = new String[N];
		int[] count = new int[R+2];
		int[] count_r = new int[R+2];
		
		for(int i=start;i<end;i++){
			count[charAt(a[i],pos)+2]++;
			count_r[charAt(a[i],pos)+2]++;
		}
		for(int r=0;r<R;r++){
			count[r+1]+=count[r];
			//count_r[r]=count[r];
		}
		//count_r[R]=count[R];
		
		for(int i=start;i<end;i++){
			aux[count[charAt(a[i],pos)+1]]=a[i];
			count[charAt(a[i],pos)+1]++;
		}
		for(int i=start;i<end;i++){
			a[i]=aux[i-start];
		}
		
		for(int r=2;r<R+2;r++){
			if(count_r[r]==0)continue;
			int l = count_r[r];
			char ch = (char)r;
			System.out.println(ch+":"+l);
			sort(a,start,start+l,pos+1);
			start+=l;
		}
		
		
		return a;
	}
	
	public static int charAt(String s ,int index){
		try{
			return s.charAt(index);
		} catch (IndexOutOfBoundsException  e){
			return -1;
		}
		
	}
}
