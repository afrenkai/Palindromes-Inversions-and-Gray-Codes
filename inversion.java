import java.util.Arrays;

public class inversion {

    public static void main(String args[]) {
        // A[0 .. n-1] = arr
        if (args.length < 1 || args.length > 3) {
            System.out.println("Usage: java inversion <speed> <List of numbers as string> <Optional: Length of list>");
            return;
        }
        
        String inversion = args[0];
        String listInp = args.length > 1 ? args[1] : "45678901";
        int length = args.length == 3 ? Integer.parseInt(args[2]) : listInp.length();
        int[] arr = str2IntArr(listInp, length);

        int invCount = 0;
        if ("easy".equalsIgnoreCase(inversion)) {
            invCount = easyinversioncount.countInversions(arr);
        } else if ("fast".equalsIgnoreCase(inversion)) {
            invCount = fastinversioncount.countInversions(arr);
        } else {
            System.out.println("Pick 'easy' or 'fast'");
            return;
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Inversion Count: " + invCount);
    }

    public static int[] str2IntArr(String argidx, int length) {
        int[] intArr = new int[length];
        for (int i = 0; i < length && i < argidx.length(); i++) {
            try {
                intArr[i] = Character.getNumericValue(argidx.charAt(i));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + argidx.charAt(i));
                intArr[i] = 0; // default to 0 if input is not a valid integer
            }
        }
        return intArr;
    }
}

class easyinversioncount {
    public static int countInversions(int[] arr) {
        int invCount = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) { // Fixing the loop here to start j from i+1
                if (arr[i] > arr[j]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }
}

class fastinversioncount {
    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        // Merging and counting inversions
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                swaps += (mid + 1) - (left + i); // Count inversions
            }
        }

        // Copy remaining elements
        while (i < leftArray.length)
            arr[k++] = leftArray[i++];
        while (j < rightArray.length)
            arr[k++] = rightArray[j++];

        return swaps;
    }
}
