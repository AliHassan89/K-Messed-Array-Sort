/*

K-Messed Array Sort
Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient
function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging
to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

1 ≤ k ≤ 20
[output] array.integer

 */

package main.java;

public class KMessedSortArray {

    static int[] sortKMessedArray(int[] arr, int k) {
        int len = arr.length;
        if (len <= 1)
            return arr;

        for (int i=1; i<len; i++) {
            if (arr[i] > arr[i-1])
                continue;

            arr = swap(arr, i, k);
        }

        return arr;
    }


    private static int[] swap(int[] arr, int index, int k) {
        if (index > 0){
            int temp = arr[index];
            arr[index] = arr[index-1];
            arr[index-1] = temp;
            --k;
        }

        index = index -1;
        if (index > 0 && (arr[index] < arr[index-1]) && k>0){
            return swap(arr, index, k);
        }

        return arr;
    }
}
