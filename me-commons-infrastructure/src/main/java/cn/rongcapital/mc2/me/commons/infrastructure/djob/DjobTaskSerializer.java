package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DjobTaskSerializer {

	public static String toString(DjobTask task) throws IOException {
		String serialization = null;
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream)) {
			objectOutputStream.writeObject(task);
			serialization = arrayOutputStream.toString("ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			arrayOutputStream.close();
		}
		return serialization;
	}

	public static DjobTask toTask(String serialization) throws IOException {
		DjobTask task = null;
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(serialization.getBytes("ISO-8859-1"));
		try (ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream)) {
			task = (DjobTask) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			arrayInputStream.close();
		}
		return task;
	}

}
