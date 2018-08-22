package org.tcrow.sort;

import org.tcrow.util.RandomUtil;

/**
 * @author pp
 * @date 2018/8/21
 * @description
 * 随机快速排序，屏蔽了出现输入数组完全顺序的情况造成最坏排序结果
 */
public class QuickSort implements SortInterface{

    @Override
    public int[] sort(int[] arr) {
        //随机交换长度次，打乱原有数组排序规则，保证不会出现顺序数组的概率是个随机数
//        for (int i = 0; i < arr.length; i++) {
//            Sort.swap(0,RandomUtil.getIntegerBetween(0, arr.length - 1),arr);
//        }

        return qSort(arr,0,arr.length);
    }

    private int[] qSort(int[] arr,int low,int high){

        if(low < high){
            int pivot = partition(arr,low,high -1);
            qSort(arr,low,pivot);

            qSort(arr,pivot + 1,high);
        }

        return arr;
    }

    private int partition(int[] arr, int low, int high) {
        int k = arr[low];
        while (low < high){
            while (low < high && arr[high] >= k){
                high--;
            }
            if(low < high){
                Sort.swap(low,high,arr);
            }

            while (low < high && arr[low] <= k){
                low++;
            }
            if(low < high){
                Sort.swap(low,high,arr);
            }
        }
        return low;
    }
}