public class LSD
{
	public static String[] sort(String[] a,int W){
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W-1;d>=0;d--){
			int[] count = new int[R+1];
			for(int i=0;i<N;i++){
				count[a[i].charAt(d)+1]++;
			}
			for(int i=0;i<R;i++)
				count[i+1]+=count[i];
			for(int i=0;i<N;i++)
				aux[count[a[i].charAt(d)]++]=a[i];
			for(int i=0;i<N;i++)
				a[i]=aux[i];
		}
		
		return aux;
	}
}