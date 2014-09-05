package rumman.freemarker;

public class ValueHolder {
	private String name;
	private String value;
	
	public ValueHolder(String name,String value){
		this.name=name;
		this.value=value;
	}
	public String getName(){
		return name;
	}
	public String getValue(){
		return value;
	}

}
