package org.bluesky.algorithm.sorting;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class SortingTest extends TestCase{
	private int[] list;

	@Before
	public void setUp() throws Exception {
		list = new int[]{34, 3, 53, 2, 23, 7, 14, 10, 23};
	}

	@Test
	public void testQuickSort() {
		QuickSort.quickSort1(list, 0, list.length-1);
		assertTrue("快速排序结果与预期不同！", Arrays.equals(new int[]{2, 3, 7, 10, 14, 23, 23, 34, 53}, list));
	}
	
	@Test
	public void testBubbleSort() {
		BubbleSort.bubbleSortFbta(list, list.length);
		assertTrue("冒泡排序结果与预期不同！", Arrays.equals(new int[]{2, 3, 7, 10, 14, 23, 23, 34, 53}, list));
	}
	
	@Test
	public void testSelectSort() {
		SelectSort.selectSort(list, list.length);
		assertTrue("选择排序结果与预期不同！", Arrays.equals(new int[]{2, 3, 7, 10, 14, 23, 23, 34, 53}, list));
	}

}
