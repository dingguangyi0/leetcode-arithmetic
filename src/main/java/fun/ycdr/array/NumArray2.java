package fun.ycdr.array;

public class NumArray2 {
    private int[] preSum;

    public NumArray2(int[] nums) {
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        this.preSum = preSum;
    }

    public int sumRange(int left, int right) {
      return preSum[right+1]-preSum[left];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(arr);
        System.out.println(numArray.sumRange(0, 2)); // return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(2, 5)); // return -1 (3 + (-5) + 2 + (-1))
        System.out.println(numArray.sumRange(0, 5)); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }
}
