package com.test;
/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 * */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length()==0){
			return true;
		}

		for (int i=1;i<=s.length();i++){
			if (dict.contains(s.substring(0,i))&&wordBreak(s.substring(i), dict)){
				return true;
			}
		}
		return false;

	}

	public static boolean wordBreakDP(String s, Set<String> dict) {
		int length = s.length();
		boolean[] can = new boolean[length+1];
		can[0] = true;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j] && dict.contains(s.substring(j, i))) {
					can[i] = true;
					break;
				}
			}
		}
		return can[length];

	}
	//below method uses an int array to recreate record the word boundries.
	public static int wordBreakDP2(String s, Set<String> dict) {
		int length = s.length();
		int [] can = new int[length+1];
		can[0] = 1;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j]!=0 && dict.contains(s.substring(j, i))) {
					can[i] = i;
					break;
				}
			}
		}
		return can[length];

	}

	//word segmentation using recursion
	static String SegmentString(String input, Set<String> dict) {
		if (dict.contains(input)) return input;
		int len = input.length();
		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = input.substring(i, len);
				String segSuffix = SegmentString(suffix, dict);
				if (segSuffix != null) {
					return prefix + " " + segSuffix;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Set <String> dict= new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("codeoj");

	//	System.out.println(wordBreakDP2("leetcodeo", dict));
		System.out.println(SegmentString("leetcodeoj", dict));
	}
	static Map<String, String> memoized =  new HashMap<String, String>();

	static String SegmentString2(String input, Set<String> dict) {
		if (dict.contains(input)) return input;
		if (memoized.containsKey(input)) {
			return memoized.get(input);
		}
		int len = input.length();
		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = input.substring(i, len);
				String segSuffix = SegmentString2(suffix, dict);
				if (segSuffix != null) {
					memoized.put(input, prefix + " " + segSuffix);
					return prefix + " " + segSuffix;
				}
			}
			memoized.put(input, null);
			return null;
		}
		return memoized.get("");
	}
}
