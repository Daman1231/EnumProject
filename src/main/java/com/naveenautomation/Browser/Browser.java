package com.naveenautomation.Browser;

public enum Browser {

	GOOGLE_CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox");
	
	String name;

	private Browser(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
