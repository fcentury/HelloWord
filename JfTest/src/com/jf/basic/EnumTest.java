package com.jf.basic;

public class EnumTest {
	public enum XQ {
		MON(1),TUE(2){
			public boolean isReset(){
				return true;
			}
		},SUN(0);
		
		private int value;
		private XQ(int value){
			this.value=value;
		}
		
		private int getValue(){
			return value;
		}
	}
	
	public static void main(String[] args){
//		System.out.println(XQ.MON.getValue());
		String value="[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']";
		System.out.println(value);
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
//		value = value.replaceAll("(?i)javascript","");
		value = value.replaceAll("\"","");
		System.out.println(value);
	}
}

