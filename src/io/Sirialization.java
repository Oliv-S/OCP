package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sirialization {

	public static void main(String[] args) {
		
		
		Animal animal1 = new Animal("Maus", 15);
		System.out.println(animal1);
		
		Animal animal2 = new Animal("Katze", 7);
		System.out.println(animal2);
		
		List<Animal> animalsList = new ArrayList<>();
		animalsList.add(animal1);
		animalsList.add(animal2);
		//Write an Animal to File
		String fileName = "target\\classes\\io\\Animal.data";
		File file = new File (fileName);
		System.out.println("File: " + file.getAbsolutePath());
		saveAnimals(animalsList, file);
		//Read an Animal from File
		
		System.out.println("Reading Animals data from file "+file.getAbsolutePath());
		List<Animal> animalsListFromFile = readAnimals(file);
		for (Animal animal : animalsListFromFile) {
			System.out.println(animal);
		}

	}
	
	public static List<Animal> readAnimals(File file)  {
		List<Animal> animals = new ArrayList<>();
		try(ObjectInputStream outputStream = new ObjectInputStream(new BufferedInputStream  (new FileInputStream(file)))){
			Animal readedAnimalFromFile;
			Object objectFromFile;
			while ((objectFromFile = outputStream.readObject())!=null) {
				if (objectFromFile instanceof Animal) 
					animals.add((Animal)objectFromFile);
			}
		} catch (EOFException e) {
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animals;
	}	
	
	public static void saveAnimals(List<Animal> animals, File file)  {
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(file)))){
			for (Animal animal : animals) {
				outputStream.writeObject(animal);				
			}
			outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Animal implements Serializable{

	private static final long serialVersionUID = 4227338598794659211L;
	
	private String name;
	private int age;

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}

