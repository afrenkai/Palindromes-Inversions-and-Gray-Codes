public class inversion {

    public static void main (String args[]) {
        // A[0 .. n-1] = arr
        if (args.length > 3) {
            System.out.println("Usage: java inversion.java <speed> <List> <Len of list if you want more than 8");
        }
        else {
            // String inversion = args[0];
            int [] arr = str2IntArr(args[1]);
            // performInversion(inversion);
            System.out.println(arr);

        }
        
        
    }
    public static int[] str2IntArr(String argidx){
        int[] intArr = new int [argidx.length()];
        for (int i = 0; i < argidx.length(); i++){
            try {
                intArr[i] = argidx.indexOf(i);
            }
            catch (NumberFormatException e) {
                System.out.println("invalid input: " + argidx.indexOf(i));
            }
        }
        return intArr;
    }
}

// 

// public class fastinversioncount {
    
// }

// public class easyinversioncount {
    
// }

// 25 Points) Let A[0..n − 1] be an array of real numbers (or any ordered set). A
// pair (A[i], A[j]) is said to be an inversion if these numbers (elements) are out
// of order, i.e., i < j but A[i] > A[j]. Note that this pair need not be adjacent.
// The array/sequence (3, 2, 1) contains three inversions: (3,2), (2,1), and (3,1).
// Include a mechanism to allow users to enter a list of numbers from the console
// (keyboard) — either 8 by default or a choice of length entered by the user.
// (10 Points) Write a program with a na ̈ıve O(n2) [sorting] algorithm that counts
// the number of inversions in such an array A.
// Call your program/project ‘easyinversioncount’.
// (15 Points) Write a program with a O(n log n) [sorting] algorithm that counts
// the number of inversions in such an array A.
// Call your program/project ‘fastinversioncount’.
