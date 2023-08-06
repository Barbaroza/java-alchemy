package com.pmb.wait.wait_2023_02_02;

/**
 * @author lvrui
 */
public class BinSearchSolution {

    int count = 0;
    public int InversePairs(int [] array) {
        // 长度小于2则无逆序对
        if(array.length < 2)
            return 0;
        // 进入归并
        mergeSort(array,0,array.length-1);
        return count;
    }

    public void mergeSort(int[] array,int left,int right){
        // 找分割点
        int mid = left+(right-left)/2;
        if(left < right){
            // 左子数组
            mergeSort(array,left,mid);
            // 右子数组
            mergeSort(array,mid+1,right);
            // 并
            merge(array,left,mid,right);
        }
    }

    public void merge(int[] array,int left,int mid,int right){
        // 创建临时数组，长度为此时两个子数组加起来的长度
        int[] arr =  new int[right-left+1];
        // 临时数组的下标起点
        int c = 0;
        // 保存在原数组的起点下标值
        int s = left;
        // 左子数组的起始指针
        int l = left;
        // 右子数组的起始指针
        int r = mid+1;
        while(l <= mid && r <= right ){
            // 当左子数组的当前元素小的时候，跳过，无逆序对
            if(array[l] <= array[r]){
                // 放入临时数组
                arr[c] = array[l];
                // 临时数组下标+1
                c++;
                // 左子数组指针右移
                l++;
            }else{ // 否则，此时存在逆序对
                // 放入临时数组
                arr[c] = array[r];
                // 逆序对的个数为    左子数组的终点- 当前左子数组的当前指针
                count += mid+1-l;
                count %= 1000000007;
                // 临时数组+1
                c++;
                // 右子数组的指针右移
                r++;
            }
        }

        // 左子数组还有元素时，全部放入临时数组
        while(l <= mid)
            arr[c++] = array[l++];
        // 右子数组还有元素时，全部放入临时数组
        while(r <= right)
            arr[c++] = array[r++];
        // 将临时数组中的元素放入到原数组的指定位置
        for(int num:arr){
            array[s++] = num;
        }
    }

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (array[m] > array[j]) i = m + 1;
            else if (array[m] < array[j]) j = m;
            else j--;
        }
        return array[i];
    }

    public int compare (String version1, String version2) {

        String [] subV1  = version1.split("\\.");
        String [] subV2  = version2.split("\\.");

        int compare = 0;
        for (int i = 0; i < Math.max(subV1.length, subV2.length);i++) {

            String sub1 = null;
            if (i < subV1.length) {
                sub1 = subV1[i];
            }
            String sub2 = null;
            if (i < subV2.length) {
                sub2 = subV2[i];
            }
            compare = compareSubV(sub1, sub2);

            if (compare != 0) {
                break;
            }
        }
        return compare;

    }


    private int compareSubV(String sub1,String sub2){
        return reverseNum(sub1).compareTo(reverseNum(sub2));
    }

    private Integer reverseNum(String sub1){
        if(sub1==null){
            return 0;
        }
        int number = 0;
        for(int i =0;i<sub1.length();i++){
            number = 10*number + sub1.charAt(i)-'0';
        }

        return number;
    }

}
