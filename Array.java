/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reflectiontest;

/**
 *
 * @author Owner
 */

import java.util.Arrays;

class Array<E> {

	private final E[] arr;
	public final int length;

	// constructor
	public Array(Class<E> type, int length)
	{
		// Creates a new array with the specified type and length at runtime
		this.arr = (E[]) java.lang.reflect.Array.newInstance(type, length);
		this.length = length;
	}

	// Function to get element present at index i in the array
	E get(int i) {
		return arr[i];
	}

	// Function to set a value e at index i in the array
	void set(int i, E e) {
		arr[i] = e;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}

class Main
{
	// Program to create a generic array in Java
	public static void main(String[] args)
	{
		final int length = 5;

		// create an Integer array of given length
		Array<Integer> intArray = new Array(Integer.class, length);

		for (int i = 0; i < length; i++)
			intArray.set(i,i  );

		System.out.println(intArray);

		// create a String array of given length
		Array<String> strArray = new Array(String.class, length);

		for (int i = 0; i < length; i++)
			strArray.set(i, String.valueOf((char)(i + 65)));

		System.out.println(strArray);
	}
}