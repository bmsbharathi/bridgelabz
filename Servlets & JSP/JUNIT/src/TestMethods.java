
/**
 * 
 */

/**
 * @author bridgeit
 *
 */
public class TestMethods {
	
	
	static int findMax(int arr[]) {
		
		int max = arr[0];
		for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
		//System.out.println(max);
		return max;
	}
	

	static boolean hasSomething(String input) {
		boolean flag =true;
		
		if(input.equals("")){
			flag = false;
		}
		return flag;
	}
	
	static int Findlength(String input) {
		int len=0;
		char inp[] = input.toCharArray(); 
		for(char c: inp) {
			len++;
		}
		return len;
	}
	
	public static void main(String args[]) {
		TestMethods.findMax(new int[] {4,6,2,1,89});
		TestMethods.Findlength("HELL0");
	}
}
