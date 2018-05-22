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
		createArraysAndTest();
	}

	public static void createArraysAndTest()
	{
		Integer[] firstArray = createFirstArray(655536);
		Integer[] secondArray = createSecondArray(65536);
		Integer[] thirdArray = createThirdArray(65536);
                Integer[] firstArrayDoubled = createFirstArray(131072);
		Integer[] secondArrayDoubled = createSecondArray(131072);
		Integer[] thirdArrayDoubled = createThirdArray(131072);
		testSelectionSort(firstArray, firstArrayDoubled);
		testSelectionSort(secondArray, secondArrayDoubled);
		testSelectionSort(thirdArray, thirdArrayDoubled);
                randomizeArray(firstArray);
                randomizeArray(secondArray);
                randomizeArray(thirdArray);
                randomizeArray(firstArrayDoubled);
                randomizeArray(secondArrayDoubled);
                randomizeArray(thirdArrayDoubled);
		testInsertionSort(firstArray, firstArrayDoubled);
		testInsertionSort(secondArray, secondArrayDoubled); 
		testInsertionSort(thirdArray, thirdArrayDoubled);
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

	public static void testInsertionSort(Comparable[] a, Comparable[] b)
	{
		Stopwatch sw = new Stopwatch();
                InsertionSort sort = new InsertionSort();
                sort.sort(a);
		double time = sw.elapsedTime();
                sw = null;
                sort = null;
                sw = new Stopwatch();
                sort.sort(b);
                double time2 = sw.elapsedTime();
		System.out.println("For the array using Insertion Sort b was " + Math.log(time/time2)/Math.log(2.0));	
	}


	public static void testSelectionSort(Comparable[] a, Comparable[] b)
	{
		Stopwatch sw = new Stopwatch();
                SelectionSort selecSort = new SelectionSort();
                selecSort.sort(a);
                double time = sw.elapsedTime();
                sw = null;
                selecSort = null;
                sw = new Stopwatch();
                selecSort = new SelectionSort();
                selecSort.sort(b);
                double time2 = sw.elapsedTime();
		System.out.println("For the array using Selection Sort b was " + Math.log(time/time2)/Math.log(2.0) );
	}

}
