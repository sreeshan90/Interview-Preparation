package com.ctci.stacksQueues;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    int id;
    String name;
}
public class AnimalShelter {

    static class Dog extends Animal{

        String name;

        public Dog(int id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
    }

    static class Cat extends Animal{

        public Cat(int id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
    }

    private Queue<Dog> dogs = new LinkedList<Dog>();
    private Queue<Cat> cats = new LinkedList<Cat>();

    public void enQueue(Animal animal) {

        if (animal.getClass().equals("Dog")) {
            dogs.add((Dog) animal);
        }
        else if (animal.getClass().equals("Cat")) {
            cats.add((Cat) animal);
        }
    }

    public Animal deQueueAny() throws Exception {
        if (!dogs.isEmpty()) {
            return dogs.poll();
        }else if (!cats.isEmpty()) {
            return cats.poll();
        }
        else{
            throw new Exception( "No animals available");
        }
    }

    public Animal deQueueDog() throws Exception {
        if (!dogs.isEmpty()) {
            System.out.println("DeQueuing cat");
            return dogs.poll();
        }
        else {
            throw new Exception( "No Dogs available");
        }
    }

    public Animal deQueueCat() throws Exception {
        if (!cats.isEmpty()) {
            System.out.println("DeQueuing cat");
            return cats.poll();
        }
        else {
            throw new Exception( "No Cats available");
        }
    }

    public static void main(String[] args) throws Exception {

        AnimalShelter shelter = new AnimalShelter();

        shelter.enQueue(new Cat(213));
        shelter.enQueue(new Dog(231));
        shelter.enQueue(new Dog(1245));
        shelter.enQueue(new Cat(8978));

        System.out.println(shelter.deQueueAny());
        System.out.println(shelter.deQueueCat());
        System.out.println(shelter.deQueueDog());

    }

}
