public class DevidenConquir{


    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static int dividenConquir(int arr[], int tar, int si, int ei){

        // Base Case
        if(si > ei){
            return -1;
        }


        int mid = si + (ei-si)/2;

        if(arr[mid] == tar){
            return mid;
        }

        // If mid on L1
        if(arr[si] < arr[mid]){
            // Case a: Left side
            if(arr[si] <= tar && tar <= arr[mid]){
                return dividenConquir(arr, tar, si, mid-1);
            }else {
                // Case b: Right side
                return dividenConquir(arr, tar, mid+1, ei);
            }
        }
        // If mid on L2
        else {
            // Case c: Left side
            if(arr[mid+1] <= tar && tar <= ei){
                return dividenConquir(arr, tar, si, mid-1);
            }else {
                // Case d: Right side
                return dividenConquir(arr, tar, mid+1, ei);
            }
        }



    }





    public static void main(String args[]){

        int arr[] = {6,7,8,9,2,3,4,5};
        int tar = 7;
        int search = dividenConquir(arr, tar, 0, arr.length-1);
        System.out.print(search);

    }
}