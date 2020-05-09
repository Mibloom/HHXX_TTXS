package demo;

import java.util.Arrays;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/25 19:31
 */
public class 二分查找 {

    public static int find1(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int find2(int[] array, int a, int low, int high) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (low > high) {
            return -2;
        }
        int mid = (high + low) / 2;
        if (array[mid] == a) {
            return mid;
        } else if (array[mid] > a) {
            return find2(array, a, low, mid - 1);
        } else {
            return find2(array, a, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] ints = {2};
        System.out.println(find1(ints, 2));
        System.out.println(find2(ints, 2, 0, ints.length - 1));
    }
}
