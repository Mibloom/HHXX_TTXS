package happy.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/20 9:48
 **/
public class 冒泡排序 {
    public static void main(String[] args) {
        Random random = new Random(1024);
        int[] arr = new int[20000];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = random.nextInt(1000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(arr[arr.length - 1] - arr[0] == 999);

    }

    static void bubbleSort(int[] nums) {
        int maxJ = nums.length - 1;
        int lastJ = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < maxJ; j++) {
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    isSorted = false;
                    lastJ = j;
                }
            }
            maxJ = lastJ;
            if (isSorted){
                break;
            }


        }
    }
}
