package com.XIPerformer.util;

import java.io.File;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


public class Testing {
	
public static void main(String[] args) {
	
	TestNG testng = new TestNG();
	List<String> newArrayList = Lists.newArrayList();
	String path = System.getProperty("user.dir")+File.separator+"testng.xml";
	newArrayList.add(path);
	testng.setTestSuites(newArrayList);
	testng.run();
}
}
