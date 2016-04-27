package com.jf.thread;

public class ThreadBasic {
	
	public static void main(String[] args){
		Thread t = new Thread("a") {
			public void run(){
				System.out.println(this.getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end");
			}
		};
		t.start();
		System.out.println("end2");
		class Demo {
			public void p(){
				System.out.println(1);
			}
		}
		Demo d = new Demo(){
			public void p(){
				System.out.println(2);
			}
		};
		d.p();
	}

}
