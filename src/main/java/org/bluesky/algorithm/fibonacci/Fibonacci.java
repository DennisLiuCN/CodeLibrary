package org.bluesky.algorithm.fibonacci;

/**
 * 斐波那契数列
 * @author: liuyuefeng
 * @date: 2015-1-13 上午10:08:01
 * @version: V1.0
 * 
 */
/*
 * 题目1：写一个函数，输入n，其斐波那契数列的第n项。
 * 斐波那契数列的定义如下：
 * F_0 = 0
 * F_1 = 1
 * F_n = F_{n-1} + F_{n-2}
*/	
public class Fibonacci {
	
	/**
	 * 使用递归方式，时间复杂度是n的指数级别
	 * @param n
	 * @return: int
	 * @throws:
	 */
	public static int FibonacciRecursive(int n)
	{
	    if(n<=0)
	        return 0;
	    if(n==1)
	        return 1;
	    return FibonacciRecursive(n-1)+FibonacciRecursive(n-2);
	}
	
	/**
	 * 使用非递归方式，空间复杂度为O(1)，时间复杂度为O(n)
	 * @param n
	 * @return: int
	 * @throws:
	 */
	public static int FibonacciNonRecursive(int n)
	{
	    if(n<=0)
	        return 0;
	    else if(n==1)
	        return 1;
	    else
	    {
	        //当n>=2时，初始化pre=f(0)=0,post=f(1)=1,f(n)=0;
	        int pre=0;
	        int post=1;
	        int fn=0;
	        //采用循环计算斐波那契数列，通过两个临时变量pre和post保存中间结果，避免重复计算
	        for(int i=2;i<=n;i++)
	        {
	        	//fn等于其前面两个元素值的和
	            fn=pre+post;
	            //然后让pre和post分别直线他们后面的元素。
	            pre=post;
	            post=fn;
	        }
	        return fn;
	    }
	}

}
