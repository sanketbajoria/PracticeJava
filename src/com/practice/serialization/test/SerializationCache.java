package com.practice.serialization.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Serialization Cache problem
 * Due to cache maintained, same object won't be written again. 
 * @author sbajo1
 *
 */
public class SerializationCache {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int[] v = new int[1];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream output = new ObjectOutputStream(bos);
		for(int i=0;i<5;i++){
			v[0] = i;
			output.writeObject(v);
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream input = new ObjectInputStream(bis);
		for(int i=0;i<5;i++){
			System.out.println(((int[])input.readObject())[0]);
		}

	}

}
