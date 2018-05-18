import java.util.Scanner;
import java.util.Random;

public class RoqueniNoneUniform
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter how many data points you want inside the test data");
		int n = in.nextInt();
		createArrays(n);
	}

	public static void createArrays(int n)
	{
		int[] halfAndHalfArray = createFirstArray(n);
		int[] halfOneQuarterArray = createSecondArray(n);
		int[] halfRandomArray = createThirdArray(0);
		testSelectionSort(halfAndHalfArray, "first");
		testSelectionSort(halfOneQuarterArray, "second");
		testSelectionSort(halfRandomArray, "third");
		testInsertionSort(halfAndHalfArray, "first");
		testInsertionSort(halfOneQuarterArray, "second"); 
		testInsertionSort(halfRandomArray, "third");
	}

	public static int[] createFirstArray(int n)
	{
		int[] array = new array[n];
		int first = (int) n/2;
		int second = n - first;
		for(int i = 0; i < first; i++)
		{
			array[i] = 0;
		}
		for(int j = 0; j< n-1; j++)
		{
			array[j] = 1;
		}
		return randomizeArray(array);
	}
	
	/**test a different method*/
	public static int[] createSecondArray(int n)
	{
		int first = (int)n/2;
		int second = (int) (n-first)/2;
		int third = (int) (n-first-second)/2;
		int fourth = n - first - second - third;
		int[] array = new array[n]
		for(int i = 0; i < first - 1; i++)
		{
			array[i] = 0;
		} 
		for(int j = first; j < second -1; j++)
		{
			array[j] = 1;
		}
		for(int k = second; k < third -1; k++)
		{
			array[k] = 2;
		}
		for(int g = third; g < array.length; g++)
		{
			array[g] = 3;
		}
		return randomizeArray(array);
	}

	//test
	public static int[] createSecondArray(int n)
	{
		int remainder = n;
		int half; 
		int[] array = new array[n];
		int insertNumb = 0;
		int previous = 0;
		while(remainder != 0)
		{
			half = remainder/2;
			remainder = remainder - half;
			for(int i = half; i >= 0; i--)
			{
				array[previous + i] = insertNumb; 
			}
			insertNumb++;
			previous += half; 
		}
	}

	public static int[] createThirdArray(int n)
	{
		Random ran = new Random();
		int[] array = new array[n];
		if(n%2 == 0)
		{
			int first = n/2;
			int second = first;
		}
		else
		{
			int first = (n+1)/2;
			int second = n - first;
		}
		for(int i = 0; i < first - 1; i++)
		{
			array[i] = 0;
		}
		for(int k = first; k < n -1; k++)
		{
			array[k] = ran.nextInt();
		}
		return randomizeArray(array);
	}

	public static int[] randomizeArray(int[] array)
	{
		Random ran = new Random();
		int firstRandomIndex;
		int temp;
		int secondRandomIndex;
		for(int i = 0; array.length - 1; i++)
		{
			firstRandomIndex = ran.nextInt(array.length-1);
			secondRandomIndex = ran.nextInt(array.length-1);
			temp = array[firstRandomIndex];
			array[firstRandomIndex] = array[secondRandomIndex];
			array[secondRandomIndex] = temp;
		}
		return array;
	}

	public static void testInsertionSort(Comparable[] a, String str)
	{
		Stopwatch sw = new Stopwatch();
	        int N = a.length;
        
        	for (int i = 1; i < N; i++)
        	{
            		for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                		exch(a, j, j-1);
        	}
		double time = sw.elapsedTime();
		System.out.println("For the " + str + " array using Insertion Sort " + N + " elements took " + time + " time.");
		
			
	}

	private static void exch(Comparable[] a, int i, int j)
	{
        	Comparable t = a[i]; a[i] = a[j]; a[j] = t;
        }

	public static void testSelectionSort(Comparable[] a, String str)
	{
		Stopwatch sw = new Stopwatch();
		int N = a.length;
        	for (int i = 0; i < N; i++)
        	{
            		// Exchange a[i] with smallest entry in a[i+1...N).
            		int min = i; // index of smallest entry.
            		for (int j = i+1; j < N; j++)
                		if (less(a[j], a[min])) min = j;
            		exch(a, i, min);
        	}
		System.out.println("For the " + str + " array using Selection Sort " + N + " elements took " + time + " time.");
	}

}
