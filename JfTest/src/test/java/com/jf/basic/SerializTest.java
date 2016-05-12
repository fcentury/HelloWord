package com.jf.basic;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		serializeUser();
		User u = deserializeUser();
		System.out.println(u.getSex());
	}
	
	public static void serializeUser() throws FileNotFoundException, IOException{
		User u = new User();
		u.setName("jf");
		u.name = "OK";
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/utest.txt")));
		oo.writeObject(u);
		System.out.println("user对象序列化成功！");
		oo.close();
		UserE ue = new UserE();
		ue.setName("jf");
		ObjectOutputStream oo1 = new ObjectOutputStream(new FileOutputStream(new File("E:/uetest.txt")));
		oo1.writeObject(ue);
		System.out.println("userE对象序列化成功！");
		oo1.close();
	}
	
	public static User deserializeUser() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/utest.txt")));
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("E:/uetest.txt")));
		User user = (User)ois.readObject();
		System.out.println("user反序列化成功！" + user);
		UserE userE = (UserE)ois1.readObject();
		UserE.name="OK";
		System.out.println("userE反序列化成功！" + userE);
		ois.close();
		ois1.close();
		return user;
	}

}

/**
 * Serializable接口序列化
 * transient不能被序列化，static修饰的不序列化，static反序列化出来的是jvm中的值
 * @author jiafengma
 *
 */
class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static String name;
	private transient String sex="nan";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString(){
		return "name=" + name + "|sex=" + sex;
	}
}

/**
 * Externalizable接口序列化
 * static并非不序列化，同样进行序列化，但是反序列化的时候取的值是当前jvm的值，读取的jvm中的值
 * @author jiafengma
 */
class UserE implements Externalizable {
	
	public static String name;
	private transient String sex="nan";
	
	public UserE(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString(){
		return "name=" + name + "|sex=" + sex;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeObject(sex);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
		name = (String)in.readObject();
		sex = (String)in.readObject();
	}
	
}
