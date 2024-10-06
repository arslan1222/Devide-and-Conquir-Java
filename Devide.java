public class Devide{

    public static void devide(int arr[], int si, int ei){

        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;

        devide(arr, si, mid);
        devide(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

        public static void merge(int arr[], int si, int mid, int ei){
            int i = si;
            int j = mid+1;
            int k = 0;
            int temp[] = new int[ei-si+1];

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
                temp[k] = arr[i];
                k++; i++;
            }

            while(j <= ei){
                temp[k] = arr[j];
                k++; j++;
            }

            for(k=0, i=si; k<temp.length; k++, i++){
                arr[i] = temp[k];
            }
        }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        int arr[] = {3,6,2,1,9,4,5};
        devide(arr, 0, arr.length-1);
        printArr(arr);
    }
}