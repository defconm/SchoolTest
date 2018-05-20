/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roqueninoneuniform;

/**
 *
 * @author defco
 */
public class SelectionSort
{
    private int N;
    
    public int getN()
    {return this.N;}
    
    public void sort(Comparable[] a) {
        N = a.length;
        
        for (int i = 0; i < N; i++)
        {
            // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of smallest entry.
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }
    
    //methods below this point come from SortPlatform
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    
    private void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
}