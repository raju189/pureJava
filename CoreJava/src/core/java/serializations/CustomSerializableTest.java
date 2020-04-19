package core.java.serializations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomSerializableTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = new String("ser_custom.ser");

		Demo demo = new Demo("name", "secret value");
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			stream.writeObject(demo);
		}
		System.out.println("Before " + demo);
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			System.out.println(stream.readObject());
		}

	}

}

class Demo implements Serializable {
	private String name;
	private transient String secret;

	public Demo(String name, String secret) {
		this.name = name;
		this.secret = secret;
	}

	private void writeObject(ObjectOutputStream ps) throws IOException {
		ps.defaultWriteObject();
		ps.writeObject("@#$" + secret);
	}

	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		is.defaultReadObject();

		String dsecret = (String) is.readObject();

		secret = dsecret.substring(3);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "name = " + name + ", scret = " + secret;
	}

}
