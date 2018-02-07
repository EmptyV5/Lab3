package com.company;

import java.io.IOException;

import java.net.URL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
	int wordCount = wordCount(text);
	System.out.println(wordCount);
    }

    public static int wordCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (isWord(temp)) {
                if (i == 0) {
                    count++;
                } else {
                    if (!isWord(str.charAt(i-1))) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    public static boolean isWord(char c) {
        if (((int)c >= (int)'A' && (int)c <= (int)'Z') || ((int)c >= (int)'a' && (int)c <= (int)'z')) {
            return true;
        } else {
            return false;
        }
    }

    public static String urlToString(final String url) {

        Scanner urlScanner;

        try {

            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");

        } catch (IOException e) {

            return "";

        }

        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();

        return contents;

    }
}

