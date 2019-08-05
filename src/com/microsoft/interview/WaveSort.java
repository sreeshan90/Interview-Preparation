package com.microsoft.interview;

public class WaveSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] sortWave(int[] A) {

		// start with second element in the array and compare with the previus
		// and next elements
		// hop two elemts so thath you mainitain consitency of the comparirions
		// if prev is < than curr, swap
		// if next is < than curr, swap again

		for (int i = 1; i < A.length; i += 2) {

			// check if index out of bound
			if (i + 1 < A.length) {
				if (A[i + 1] < A[i]) {
					// swap(i+1,i);
					int temp = A[i + 1];
					A[i + 1] = A[i];
					A[i] = temp;

				}
			}

			if (A[i - 1] < A[i]) {
				// swap(i-1,i);
				int temp = A[i - 1];
				A[i - 1] = A[i];
				A[i] = temp;
			}

		}
		return A;

	}
}
