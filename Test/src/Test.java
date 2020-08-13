import java.util.Arrays;

class Test{
	
	static void solve(int[] arr) {
		
		 
		 int writeIndex = 1;
		 
		 for(int i = 0; i < arr.length - 1; i++) {
			 if(arr[i] != arr[i + 1]) {
				 arr[writeIndex] = arr[i + 1];
				 writeIndex++;
			 }
		 }
		
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(Arrays.toString(arr));
		
		solve(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
}