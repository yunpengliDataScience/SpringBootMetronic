package org.dragon.yunpeng.metronic.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenateLists {
	public static void main(String[] args) {
		// Example lists
		List<String> list1 = Arrays.asList("Apple", "Banana-A", "Cherry");
		List<String> list2 = Arrays.asList("Red", "Yellow-B", "Dark Red");

		// Call the method and get the aligned strings
		List<String> alignedStrings = concatenateAndAlignLists(list1, list2, 10);

		// Print the result
		alignedStrings.forEach(System.out::println);
	}

	/**
	 * Concatenates and aligns two lists of strings.
	 *
	 * @param list1 The first list of strings.
	 * @param list2 The second list of strings.
	 * @return A list of concatenated and aligned strings.
	 */
	public static List<String> concatenateAndAlignLists(List<String> list1, List<String> list2, int minimumSpace) {
		// Ensure lists are the same size
		if (list1.size() != list2.size()) {
			throw new IllegalArgumentException("Both lists must have the same number of elements.");
		}

		// Find maximum width for alignment
		int maxLenList1 = list1.stream().mapToInt(String::length).max().orElse(0);

		// Concatenated list
		List<String> concatenatedList = new ArrayList<>();

		// Concatenate and align
		for (int i = 0; i < list1.size(); i++) {
			// Align list1 element and add a space separator with list2 element
			String alignedString = String.format("%-" + (maxLenList1 + minimumSpace) + "s %s", list1.get(i),
					list2.get(i));
			concatenatedList.add(alignedString);
		}

		return concatenatedList;
	}
}
