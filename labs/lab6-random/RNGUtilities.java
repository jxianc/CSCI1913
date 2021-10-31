// LAB 06
// AUTHORS: Jingxian Chai

public class RNGUtilities {
    public static int seed;

    /**
     * Update the seed value to a new seed value.
     * This is important to allow consistent testing!
     * @param newSeed
     */
    public static void seed(int newSeed) {
        seed = newSeed;
    }


    /**
     * This fucntion generate a new seed from previous seed, then update the seed variable
     * @return newSeed new seed
     */
    public static int next() { 
        int newSeed = (75 * seed) % 65537;
        seed(newSeed);
        return newSeed;
    }

    /**
     * This function generate random numbers from specific range where min <= r < max
     * @param min minimum value (inclusive)
     * @param max maximum value (exclusive)
     * @return random generated random number
     */
    public static int nextInt(int min, int max) {
        int random = (next() % (max - min)) + min;
        return random;
    }

    /**
     * This function creates array following a simple numeric pattern (0, 1, 2, 3, ... , length - 1)
     * @param length length of the array
     * @return returnArray generated array
     */
    public static int[] sequenceArray(int length) {
        int[] returnArray = new int[length];
        for (int i=0; i<length; i++) {
            returnArray[i] = i;
        }   
        return returnArray;
    }

    /**
     * This function creates array that have random numbers in it within specific range where min <= r < max
     * @param length length of the array
     * @param min minimum value (inclusive)
     * @param max maximum value (exclusive)
     * @return returnArray generated random array
     */ 
    public static int[] randomArray(int length, int min, int max) {
        int[] returnArray = new int[length];
        for (int i=0; i<length; i++) {
            returnArray[i] = nextInt(min, max);
        } 
        return returnArray;
    }

    /**
     * This function randomly reorder the array
     * @param array the given array 
     */
    public static void shuffle(int[] array) {
        for (int i=array.length-1; i>=0; i--) {
            int j = nextInt(0, i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * This function sorts the given array
     * @param array the given array
     */
    public static void sort(int[] array) {
        mergeSort(array, 0, array.length-1);
    }

    /** 
     * This function sorts the array using merge sort
     * @param array given array
     * @param low first index of the array
     * @param high last index of the array
    */
    public static void mergeSort(int[] array, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }

    /** 
     * This function merges two partitions of the array
     * @param array given array
     * @param low first index of the array
     * @param mid middle index of the array
     * @param high last index of the array
    */
    public static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] tempArray = new int[high - low + 1];
        while (i <= mid && j <= high) {
            tempArray[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= high) {
            tempArray[k++] = array[j++];
        }
        System.arraycopy(tempArray, 0, array, low, high - low + 1);
    }
}
