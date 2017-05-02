package HeapPackage;

public class Main {
   public static void main(String[] args) {
      int[] a = {5, 9, 1, 3, 10, 8, 4, 6};
      System.out.println("");
      System.out.println("Hello HEAP...");
      System.out.println("");
      System.out.println("3rd smallest" + kthSmallest(a, 3));
   }

   public static int kthSmallest(int[] a, int k) {
      MaxHeap<Integer> heap = new MaxHeap();
      int i;
      for (i=0; i<k; i++) 
         heap.add(a[i]);
      for (i=k; i<a.length; i++) {
         if (heap.getMax() < a[i]) {
            heap.removeMax();
            heap.add(a[i]);
         }
      }
      return heap.getMax();
   }
}
