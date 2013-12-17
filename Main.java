
public class Main {
	public static void main(String[] args){
		Hello h = new Hello();
		h.printHello();
		char c = 0;
		System.out.println(c);
		String[] a = new String[]{"1qwsdf","opk222ju","jfiooo","opfeafewikj","effefaefsa","01213efae","a","456fawkgfp"};
		
		System.out.println("before sort");
		printArray(a);
		
		Quick3string.sort(a);
		System.out.println("after sort");
		printArray(a);
		
		
		
	}
	
	public static void printArray(String[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			System.out.println(a[i]);
		}
	}
}
