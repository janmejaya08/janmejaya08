/*Given an unsorted array arr of size n that contains only non negative integers,
find a sub-array (continuous elements) that has sum equal to s. 
You mainly need to return the left and right indexes(1-based indexing) of that subarray.
*/

import java.util.Arrays;
import java.util.Scanner;

public class SubarrayWithSum {

    public static int[] findSubarrayWithSum(int[] arr, int s) {
        int left = 0;
        int right = 0;
        int currSum = 0;

        while (right < arr.length) {
            currSum += arr[right];

            while (currSum > s) {
                currSum -= arr[left];
                left++;
            }

            if (currSum == s) {
                
                return new int[]{left + 1, right + 1}; 
            }

            right++;
        }

        
        return new int[]{-1};
    }

    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Enter array size: ");
    	int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter your choice: ");
        for(int i=0;i<n;i++)
        {
        	arr[i]=sc.nextInt();
        }
        System.out.println("Enter your target sum: ");
        int s =sc.nextInt();
        int[] result = findSubarrayWithSum(arr, s);

        System.out.println(Arrays.toString(result)); 
    }
}
