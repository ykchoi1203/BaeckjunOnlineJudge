class Solution {
    public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int[][] position = new int[4][3];
		position[3][0] = 1;
		position[3][2] = 2;
		int[] arr;
		int[] arr2;
		for(int i : numbers) {
			if(i == 1 || i == 4 || i == 7) {
				arr = whereHand(1, position);
				position[arr[0]][arr[1]] = 0;
				if(i == 1) position[0][0] = 1;
				else if(i == 4) position[1][0] = 1;
				else position[2][0] = 1;
				sb.append("L");
			} else if(i == 3 || i == 6 || i == 9) {
				arr = whereHand(2, position);
				position[arr[0]][arr[1]] = 0;
				if(i == 3) position[0][2] = 2;
				else if(i == 6) position[1][2] = 2;
				else position[2][2] = 2;
				sb.append("R");
			} else {
				if(i == 2) arr = new int[] {0,1};
				else if(i == 5) arr = new int[] {1,1};
				else if(i == 8) arr = new int[] {2,1};
				else arr = new int[] {3,1};

				if(closeHand(whereHand(1, position), whereHand(2, position), arr, hand) == 1) {
					arr2 = whereHand(1, position);
					position[arr2[0]][arr2[1]] = 0;
					position[arr[0]][arr[1]] = 1;
					sb.append("L");
				} else {
					arr2 = whereHand(2, position);
					position[arr2[0]][arr2[1]] = 0;
					position[arr[0]][arr[1]] = 2;
					sb.append("R");
				}
			}
		}
		return sb.toString();
	}

	public int[] whereHand(int num, int[][] position) {
		for(int i=0; i<position.length; i++) {
			for(int j=0; j<position[0].length; j++) {
				if(num == 1 && position[i][j] == 1) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = j;
					return arr;
				}
				else if(num == 2 && position[i][j] == 2) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = j;
					return arr;
				}
			}
		}
		return null;
	}

	public int closeHand(int[] left, int[] right, int[] arr, String hand) {
		int leftRange = Math.abs(left[0] - arr[0]) + Math.abs(left[1] - arr[1]);
		int rightRange = Math.abs(right[0] - arr[0]) + Math.abs(right[1] - arr[1]);

		if(leftRange < rightRange) return 1;
		else if (leftRange > rightRange) return 2;
		else return hand.equals("left") ? 1 : 2;
	}
}