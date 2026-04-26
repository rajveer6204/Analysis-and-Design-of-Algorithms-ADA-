
public class MergeQuickAnalysis {
                        //    Practical 4: Merge Sort & Quick Sort Analysis
    // ================= FACTORIAL =================
    static int factIter(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    static int factRec(int n) {
        if(n == 0 || n == 1) return 1;
        return n * factRec(n - 1);
    }

    // ================= FIBONACCI =================
    static void fibIter(int n) {
        int a = 0, b = 1, c;
        for(int i = 0; i < n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    static int fibRec(int n) {
        if(n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    // ================= BINARY SEARCH =================
    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == key) return mid;
            else if(key < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // ================= SORTING =================

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    // ================= MERGE SORT =================
    static void merge(int[] arr, int l, int m, int r) {
        int i = l, j = m+1, k = 0;
        int[] temp = new int[r - l + 1];

        while(i <= m && j <= r)
            temp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];

        while(i <= m) temp[k++] = arr[i++];
        while(j <= r) temp[k++] = arr[j++];

        for(i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];
    }

    static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    // ================= QUICK SORT =================
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    // ================= UTILITY =================
    static void printArray(int[] arr) {
        for(int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 6};

        int[] a1 = arr.clone();
        int[] a2 = arr.clone();

        System.out.println("Original Array:");
        printArray(arr);

        mergeSort(a1, 0, a1.length - 1);
        quickSort(a2, 0, a2.length - 1);

        System.out.println("Merge Sort:");
        printArray(a1);

        System.out.println("Quick Sort:");
        printArray(a2);

        System.out.println("Factorial (5): " + factIter(5));
        System.out.print("Fibonacci (5): ");
        fibIter(5);
    }
}