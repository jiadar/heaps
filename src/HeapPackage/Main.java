package HeapPackage;

public class Main {
   public static void main(String[] args) {
      int[] a = {5, 9, 1, 3, 10, 8, 4, 6};
      int[] b = {23, 43, 12, 32, 77, 53, 98, 38, 45, 46, 31, 17, 14, 39, 80};
      int[] c = {75, 31, 32, 19, 10, 34, 56, 78, 24, 59, 34, 29, 54, 67, 18};
      System.out.println("");
      System.out.println("Hello HEAP...");
      System.out.println("");
      System.out.println("3rd smallest (4) = " + kthSmallest(a, 3));
      System.out.println("5th smallest (31) = " + kthSmallest(b, 5));
      System.out.println("10th smallest (54) = " + kthSmallest(c, 10));
      
   }

   public static int kthSmallest(int[] a, int k) {
      MaxHeap<Integer> heap = new MaxHeap();
      int i;
      for (i=0; i<k; i++) 
         heap.add(a[i]);
      for (i=k; i<a.length; i++) {
         if (heap.getMax() > a[i]) {
            heap.removeMax();
            heap.add(a[i]);
         }
      }
      return heap.getMax();
   }
}
