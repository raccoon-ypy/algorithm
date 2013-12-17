
public class Quick3string {
	private static int charAt(String s,int d){
		try{
			int ret = (int)s.charAt(d);
			return ret;
		} catch(IndexOutOfBoundsException e){
			return -1;
		}
	}
	
	public static void sort(String[] a){
		System.out.println("-------------------start sort----------------------");
		sort(a,0,a.length-1,0);
		System.out.println("-------------------end sort----------------------");
	}
	
	public static void sort(String[]a, int start,int end,int pos){
		System.out.println("-------------------start----------------------");
		System.out.println("start="+start);
		System.out.println("end="+end);
		printArray(a,start,end);
		if(start>=end)return;
		int ch = charAt(a[start],pos);
	
		int l = start;
		int r = end;
		int i = l+1;
		System.out.println("i="+i);
		System.out.println("r="+r);
		while(i<=r){
			int v = charAt(a[i],pos);
			
			System.out.println("ch="+ch);
			System.out.println("v="+v);
			
			if(v<ch){
				exch(a,i++,l++);
			} else if(v>ch){
				exch(a,i,r--);
			} else {
				i++;
			}
		}
		System.out.println("-------------------finish----------------------");
		sort(a,start,l-1,pos);
		if(ch>0)
			sort(a,l,r,pos+1);
		sort(a,r+1,end,pos);
		
		
	}
	
	public static void exch(String a[],int i,int j){
		if(a==null)return;
		if(a.length<i||a.length<j)return;
		
		System.out.println("exchange:"+a[i]+"<->"+a[j]);
		String tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	public static void printArray(String[] a,int start,int end){
		int n = a.length;
		for(int i=0;i<=end;i++){
			System.out.println(a[i]);
		}
	}
}
