package org.bluesky.algorithm.sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 冒泡排序算法
 * @author: liuyuefeng
 * @date: 2014-9-14 下午5:17:20
 * @version: V1.0
 *
 */
public class BubbleSort {
	private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSort.class);
	
	/**
	 * 冒泡排序(from before to after)
	 * @param list
	 * @param n
	 * @return: void
	 * @throws:
	 */
	public static void bubbleSortFbta(int list[], int n) {
		LOGGER.info("   原始数据:" + Arrays.toString(list));
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (list[j] < list[j - 1]) {
					temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}
			}
			LOGGER.info("第" + (i + 1) + "次排序结果:" + Arrays.toString(list));
		}
	}

	/**
	 * 冒泡排序(from after to before)
	 * @param list
	 * @param n
	 * @return: void
	 * @throws:
	 */
	public static void bubbleSortFatb(int list[], int n) {
		LOGGER.info("   原始数据:" + Arrays.toString(list));
		int temp = 0;
		for (int i = n - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (list[j + 1] < list[j]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
			LOGGER.info("第" + (i + 1) + "次排序结果:" + Arrays.toString(list));
		}
	}
	
}
