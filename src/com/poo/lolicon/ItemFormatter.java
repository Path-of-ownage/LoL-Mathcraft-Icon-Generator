package com.poo.lolicon;

public class ItemFormatter {
	
	public static String splitCamelCase(String s) {
		return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}
	
	public static String replaceSpaceWithUnderscore(String s) {
		return s.replace(' ', '_');
	}
	
	public static String cutBrackets(String s) {
		String[] parts = s.split("\\(");
		return parts[0].trim();
	}
	
	public static String replaceHyphenWithSpace(String s) {
		return s.replace('-', ' ');
	}
	
	public static String toLowerCase(String s) {
		return s.toLowerCase();
	}
	
	public static String getFirstWordOfPhrase(String s) {
		return s.split("\\s+")[0];
	}
}
