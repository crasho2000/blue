package com.blue;

import java.util.ArrayList;

public class HelloWorld {
    // 归并排序主函数
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 计算中间点
            int mid = left + (right - left) / 2;
            
            // 递归排序左半部分
            mergeSort(arr, left, mid);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right);
            
            // 合并已排序的两半
            merge(arr, left, mid, right);
        }
    }
    
    // 合并两个已排序的子数组
    public static void merge(int[] arr, int left, int mid, int right) {
        // 计算两个子数组的大小
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // 创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // 复制数据到临时数组
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        // 合并临时数组
        int i = 0, j = 0;
        int k = left; // 初始索引
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // 复制剩余元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // 打印数组的方法
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // 原始数组
        int[] i = new int[]{5, 2, 9, 1, 5, 6};
        System.out.println("排序前的数组：");
        printArray(i);
        
        // 调用归并排序
        mergeSort(i, 0, i.length - 1);
        
        System.out.println("归并排序后的数组：");
        printArray(i);
        
        
        // 保留原有的WorkBarrie输出
        ArrayList<WorkBarrie> as = new ArrayList<>();
        System.out.println("\nWorkBarrie枚举值：");
        for (WorkBarrie workBarrie : WorkBarrie.values()) {
            System.out.println(workBarrie); 
        }
    }
}