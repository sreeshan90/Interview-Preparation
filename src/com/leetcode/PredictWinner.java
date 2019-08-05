
public class PredictWinner {

	public boolean PredictTheWinner(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return true;
		}

		return isWinnerA(nums, 0, 0, 0, nums.length - 1, true);
	}

	public boolean isWinnerA(int[] nums, int p1Count, int p2Count, int left, int right, boolean isTurnA) {


        if(left>=right){
            //game over
            if(p1Count>p2Count) return true;
            return false;
        }
		if (isTurnA) {

				return isWinnerA(nums, p1Count + nums[left], p2Count, left + 1, right, false)
						|| isWinnerA(nums, p1Count + nums[right], p2Count, left, right - 1, false);
		} else {

				return isWinnerA(nums, p1Count, p2Count + nums[left], left + 1, right, true)
						&& isWinnerA(nums, p1Count, p2Count + nums[right], left, right - 1, true);
		}

	}

}
