package HeapPackage;

import java.util.Arrays;

public class IntMaxHeap
{
   private int elementCount = 0;
   private int[] data = new int[4];

   public void add(int value) {
      int i = elementCount;
      ensureCapacity();
      data[i] = value; // add to next spot in complete tree
      while(data[i] > data[parent(i)]) {
         swapWithParent(i);
         i=parent(i);
      }
      elementCount++;
   }
   public int getMax() {
      return data[0];
   }

   public int removeMax() {
      int max = data[0];
      // get the last value and put it at the top
      elementCount--;
      data[0] = data[elementCount];

      // filter down to a leaf
      int i=0;
      while (!isLeaf(i)) {
         // go left
         if (!hasRight(i) || data[left(i)] > data[right(i)]) {
            i = left(i);
         }
         // go right
         else {
            i = right(i);
         }
         swapWithParent(i);
      }
      
      return max;
   }
   public int size() {
      return 0;
   }

   private void ensureCapacity() {
      if (elementCount == data.length) {
         data = Arrays.copyOf(data, data.length * 2);
      }
   }
   private boolean hasRight(int i) {
      return (right(i) < elementCount);
   }

   private int left(int i) {
      return (2 * i) + 1;
   }
   
   private int right(int i) {
      return (2 * i) + 2;
   }

   private int parent(int i) {
      return (i - 1) / 2;
   }

   private void swapWithParent(int i) {
      int temp = data[i];
      data[i] = data[parent(i)];
      data[parent(i)] = temp;
   }

   private boolean isLeaf(int i) {
      return left(i) >= elementCount;
   }
}


