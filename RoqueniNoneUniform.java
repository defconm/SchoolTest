/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roqueninoneuniform;

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
            if(n <= 0)
            {
                System.out.println("can not create array with size less than or equal to 0");
            }
            else
            {
		Integer[] halfAndHalfArray = createFirstArray(n);
		Integer[] halfOneQuarterArray = createSecondArray(n);
		Integer[] halfRandomArray = createThirdArray(n);
		testSelectionSort(halfAndHalfArray, "first");
		testSelectionSort(halfOneQuarterArray, "second");
		testSelectionSort(halfRandomArray, "third");
                randomizeArray(halfAndHalfArray);
                randomizeArray(halfOneQuarterArray);
                randomizeArray(halfRandomArray);
		testInsertionSort(halfAndHalfArray, "first");
		testInsertionSort(halfOneQuarterArray, "second"); 
		testInsertionSort(halfRandomArray, "third");
            }
	}

	public static Integer[] createFirstArray(int n)
	{
		Integer[] array = new Integer[n];
		int first = (int) n/2;
		int second = n - first;
		for(int i = 0; i < first; i++)
		{
			array[i] = 0;
		}
		for(int j = second; j< n; j++)
		{
			array[j] = 1;
		}

		return randomizeArray(array);
	}
	
	public static Integer[] createSecondArray(int n)
	{
            int half = n/2;
            int remain = n- half;
            int insertNumb = 0;
            int timesPerHalf = 0;
            Integer[] a = new Integer[n];
            for(int i = 0; i < n; i++)
            {
                if(timesPerHalf < half)
                {
                    a[i] = insertNumb;
                    timesPerHalf++;
                }
                else
                {
                    timesPerHalf = 1;
                    insertNumb++;
                    half = (int)(n-i)/2;
                    a[i] = insertNumb;
                    if(half == 0)
                    {
                        half = 1;
                    }
                }
                
            }
            return randomizeArray(a);
	}

	public static Integer[] createThirdArray(int n)
	{
            System.out.println("starting 3rd");
		Random ran = new Random();
		Integer[] array = new Integer[n];
                for(int i = 0; i < array.length; i++)
                {
                    if(i < array.length/2)
                    {
                        array[i] = 0;
                    }
                    else
                    {
                        array[i] = ran.nextInt();
                    }
                }
                
            System.out.println("array 3 complete");
	    return randomizeArray(array);
	}

	public static Integer[] randomizeArray(Integer
                [] array)
	{
		Random ran = new Random();
		int firstRandomIndex;
		int temp;
		int secondRandomIndex;
		for(int i = 0; i < array.length - 1; i++)
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
                InsertionSort sort = new InsertionSort();
                sort.sort(a);
		double time = sw.elapsedTime();
		System.out.println("For the " + str + " array using Insertion Sort " + sort.getN() + " elements took " + time + " seconds.");
		
			
	}


	public static void testSelectionSort(Comparable[] a, String str)
	{
		Stopwatch sw = new Stopwatch();
                SelectionSort selecSort = new SelectionSort();
                selecSort.sort(a);
                double time = sw.elapsedTime();
		System.out.println("For the " + str + " array using Selection Sort " + selecSort.getN() + " elements took " + time + " seconds.");
	}

}
