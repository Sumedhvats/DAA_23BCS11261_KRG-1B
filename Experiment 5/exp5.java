class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int p = partition(arr,low,high);
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
        }
    }
     static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        swap(arr, mid, high);

        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

