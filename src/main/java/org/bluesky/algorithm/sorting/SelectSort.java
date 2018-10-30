package org.bluesky.algorithm.sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 选择排序算法
 * @author: liuyuefeng
 * @date: 2014-9-14 下午5:18:02
 * @version: V1.0
 *
 */
public class SelectSort {
	private static final Logger LOGGER = LoggerFactory.getLogger(SelectSort.class);

	/**
	 * 选择排序
	 * @param list
	 * @param n
	 * @return: void
	 * @throws:
	 */
	public static void selectSort(int list[], int n) {
		LOGGER.info("   原始数据:" + Arrays.toString(list));
		int temp;
		int k;
		for (int i = 0; i < n - 1; i++) {
			k = i;
			for (int j = i + 1; j < n; j++) {
				if (list[j] < list[k])
					k = j;
			}
			if (k != i) {
				temp = list[i];
				list[i] = list[k];
				list[k] = temp;
			}
			LOGGER.info("第" + (i + 1) + "次排序结果:" + Arrays.toString(list));
		}
	}
	
}
