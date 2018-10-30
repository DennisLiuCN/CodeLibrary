package org.bluesky.algorithm.sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 快速排序算法
 * @author: liuyuefeng
 * @date: 2014-9-14 下午5:17:02
 * @version: V1.0
 *
 */
public class QuickSort {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);
	private static int i = 1;

	/**
	 * 进行一次排序分割
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 * @return: int
	 * @throws:
	 */
	private static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {
				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	/**
	 * 快速排序，循环调用getMiddle()
	 * @param list
	 * @param low
	 * @param high
	 * @return: void
	 * @throws:
	 */
	public static void quickSort1(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			LOGGER.info("第" + (i++) + "次排序结果:" + Arrays.toString(list));
			quickSort1(list, low, middle - 1); // 对低字表进行递归排序
			quickSort1(list, middle + 1, high); // 对高字表进行递归排序
		}
	}
	
	/**
	 * 快速排序(合并后方式)，递归调用自身
	 * @param list
	 * @param low
	 * @param high
	 * @return: void
	 * @throws:
	 */
	public static void quickSort2(int list[], int low, int high) {
		if (high < low)
			return;
		int tmp = list[low];
		int i = low, j = high;
		while (i < j) {
			while (i < j && list[j] >= tmp)
				j--;
			if (i < j)
				list[i] = list[j];
			while (i < j && list[i] <= tmp)
				i++;
			if (i < j)
				list[j] = list[i];
		}
		list[i] = tmp;
		if (low < i - 1)
			quickSort2(list, low, i - 1);
		if (high > i + 1)
			quickSort2(list, i + 1, high);
	}

}
