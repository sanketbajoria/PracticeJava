package com.practice.serialization.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialization Example
 * 
 * @author sbajo1
 *
 */
public class SerializationExample {

	public static void main(String[] args) {
		try {
			String filename = "test.ser";
			// Serialize the string to the file
			serialize(filename, "abc");
			// Deserialize and print the string from same file
			System.out.println(deserialize(filename));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("something went wrong");
		}
	}

	/**
	 * Serialize the string to particular file
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public static void serialize(String filename, String str) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream output = new ObjectOutputStream(fos);) {
			output.writeObject(str);
		}
	}

	/**
	 * Deserialize the string from the same file
	 * 
	 * @param filename
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String deserialize(String filename)
			throws ClassNotFoundException, FileNotFoundException, IOException {
		try (FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream input = new ObjectInputStream(fis);) {
			return (String) (input.readObject());
		}
	}

}
