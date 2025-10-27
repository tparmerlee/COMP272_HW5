/******************************************************************
 *
 *   Tristan Parmerlee / COMP 272-002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        // add all elements of list1 to map
        for (int i : list1){
            map.put(i, true);
        }

        // check if every element in list 2 is contained in map
        for (int i : list2){
            if (map.get(i) == null){
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : array){
            heap.offer(i);
            // keep only k-elements that are greater than the root
            if (heap.size() > k){
                heap.poll();
            }
        }

        // return the root node (which has k elements greater than it)
        return heap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // add lists to heap
        for (int i : array1) heap.offer(i);
        for (int j : array2) heap.offer(j);

        int size = heap.size();
        int[] returnArray = new int[size];

        // remove the root node of the heap (which will always be less than all of the other elements in the heap)
        // and add them to return array
        for (int k = 0; k<size; k++){
            returnArray[k] = heap.poll();
        }

        return returnArray;
    }

}