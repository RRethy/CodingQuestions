// Find median of two sorted arrays
public class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] newNums = new int[nums1.length + nums2.length];
    int i1 = 0;
    int i2 = 0;
    while (i1 + i2 < ((nums1.length + nums2.length) / 2 + 1)) {
      if (i1 == nums1.length && i2 == nums2.length) break;
      if (i1 == nums1.length) {
        newNums[i1 + i2] = nums2[i2];
        ++i2;
      } else if (i2 == nums2.length) {
        newNums[i1 + i2] = nums1[i1];
        ++i1;
      } else if (nums1[i1] < nums2[i2]) {
        newNums[i1 + i2] = nums1[i1];
        ++i1;
      } else {
        newNums[i1 + i2] = nums2[i2];
        ++i2;
      }
    }
    if (newNums.length % 2 == 0)
      return (newNums[newNums.length / 2]
          + newNums[newNums.length / 2 - 1]) / 2.0;
    return newNums[newNums.length / 2];
  }
}
