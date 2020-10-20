package com.lpl.sort;

/**
 * 八种常用排序算法：
 *  交换排序分为：冒泡排序、快速排序。
 *  插入排序分为：直接插入排序、希尔排序。
 *  选择排序：简单选择排序、堆排序。
 *  归并排序。
 *  基数排序。
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 2, 5, 4, 10};
        System.out.println("排序前：" + arr);
        //排序
        bubbleSort(arr);
        System.out.println("排序后：" + arr);
    }

    //均以升序排序为例：
    /**
     * 1.冒泡排序：从第一个元素开始，比较相邻的两个元素，如果第一个比第二个大，则进行交换。然后进行下一组相邻元素比较，执行同样的操作，以此类推...
     *      执行完一轮后最后一个元素即为序列中最大的元素。
     *
     *      除去上次操作的最后一个元素，重复以上步骤，知道没有任何一对需要比较的元素为止。
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }
        if (arr.length < 2) {
            return;
        }
        int temp = 0;
        for(int i=0; i<arr.length-1; i++) {
            //每一轮的比较与交换
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
