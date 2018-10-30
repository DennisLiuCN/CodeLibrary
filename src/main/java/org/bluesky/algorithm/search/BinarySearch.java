package org.bluesky.algorithm.search;

/**
 * 二分查找（折半查找）算法
 * @author: liuyuefeng
 * @date: 2015-8-5 上午8:30:56
 * @version: V1.0
 * 
 */
/*
 * 1、二分查找的时间复杂度是O(log(n))，最坏情况下的时间复杂度是O(n)。
 * 2、二分查找的一个条件是待查询的数组是有序的，我们假设这里的数组是升序的。
 * 3、二分查找的主要思路就是设定两个指针low和high分别指向数组元素的首尾两端，然后比较数组中间结点array[middle]和待查找元素。
 * 	   如果待查找元素小于中间元素，那么表明带查找元素在数组的前半段，那么将high=middle-1；
 * 	   如果待查找元素大于中间元素，那么表明该元素在数组的后半段，将low=middle+1；
 * 	   如果中间元素等于待查找元素，那么返回middle的值。
 */
public class BinarySearch {

	/**
	 * 非递归方法实现
	 * @param array
	 * @param value
	 * @return: int
	 * @throws:
	 */
	public static int binarySearchNoRecursion(int[] array, int value) {
		if (array == null || array.length <= 0)
			return -1;
		
		int low = 0;
		int high = array.length - 1;
		int middle;
		while (low <= high) { // 此处等于不能忽略
			middle = (low + high) / 2; // 有些地方使用middle = low + (high - low) / 2;两者效果相同
			if (value == array[middle]) {
				return middle;
			} else if (value < array[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 递归方法实现
	 * @param array
	 * @param low
	 * @param high
	 * @param value
	 * @return: int
	 * @throws:
	 */
	private static int binarySearchRecursion(int[] array, int low, int high, int value) {
		while (low <= high) {
			int middle = (low + high) / 2; // 有些地方使用middle = low + (high - low) / 2;两者效果相同
			if (value == array[middle]) {
				return middle;
			} else if (value < array[middle]) {
				return binarySearchRecursion(array, low, middle - 1, value);
			} else {
				return binarySearchRecursion(array, middle + 1, high, value);
			}
		}
		return -1;
	}
	/**
	 * 递归方法实现
	 * @param array
	 * @param value
	 * @return: int
	 * @throws:
	 */
	public static int binarySearchRecursion(int[] array, int value) {
		if (array == null || array.length <= 0)
			return -1;
		return binarySearchRecursion(array, 0, array.length - 1, value);
	}

}
