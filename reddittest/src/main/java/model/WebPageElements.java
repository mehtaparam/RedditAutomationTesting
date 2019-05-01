package model;

public class WebPageElements
{
	String name="";
	String locator="";
	String value="";
	
	public WebPageElements(String name,String locator,String value){
		this.locator=locator;
		this.name=name;
		this.value=value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
		
}
