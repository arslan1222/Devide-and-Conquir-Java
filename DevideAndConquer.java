public class DevideAndConquer{

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void devideConquer(int arr[], int si, int ei){

        // Base Case
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;

        devideConquer(arr, si, mid);  // Left part
        devideConquer(arr, mid+1, ei); // Right part
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei){

        int temp[] = new int[ei-si+1];

        int i = si;  // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0;  // iterator for temp array

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            temp[k++] = arr[i++];   // => temp[k] = arr[i]; k++; i++;
        }

        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // Copy temporary array to original array
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }

    }


    public static void main(String args[]){

        int arr[] = {3,2,8,4,1,7,5};
        devideConquer(arr, 0, arr.length-1);
        printArray(arr);


    }
}