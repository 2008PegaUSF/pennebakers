package Questions;

import java.util.Arrays;

public class questionOne {
	public int[] bubbleSort(int arr[]) {
		
		int[] arrReturn = Arrays.copyOf(arr, arr.length);
		
		// sort
	    for(int i=0; i<arrReturn.length; i++)
	    {
	        for(int j=i + 1; j<arrReturn.length; j++)
	        {
	            if(arrReturn[i] > arrReturn[j])
	            {
	                int temp = arrReturn[i];
	                arrReturn[i] = arrReturn[j];
	                arrReturn[j] = temp;
	            }
	        }
	    }
		/*for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}*/
		return arrReturn;
	}
		
		
	}
	
	/*static void printArray(int arr[]) {
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}*/

