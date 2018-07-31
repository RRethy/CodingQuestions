import java.util.LinkedList;
import java.lang.System;

public class AnimalShelter {
  public static void main(String[] args) {
    PriorityStack stack = new PriorityStack();
    Dog dog1 = new Dog("Dog1", System.nanoTime());
    Cat cat1 = new Cat("Cat1", System.nanoTime());
    Dog dog2 = new Dog("Dog2", System.nanoTime());
    Cat cat2 = new Cat("Cat2", System.nanoTime());
    Dog dog3 = new Dog("Dog3", System.nanoTime());
    Cat cat3 = new Cat("Cat3", System.nanoTime());
    Dog dog4 = new Dog("Dog4", System.nanoTime());
    Cat cat4 = new Cat("Cat4", System.nanoTime());
    Dog dog5 = new Dog("Dog5", System.nanoTime());
    Cat cat5 = new Cat("Cat5", System.nanoTime());
    stack.enqueue(dog1);
    stack.enqueue(dog2);
    stack.enqueue(dog3);
    stack.enqueue(dog4);
    stack.enqueue(dog5);
    stack.enqueue(cat1);
    stack.enqueue(cat2);
    stack.enqueue(cat3);
    stack.enqueue(cat4);
    stack.enqueue(cat5);
    System.out.println(String.format("%s", stack.dequeueCat().name));
    System.out.println(String.format("%s", stack.dequeueDog().name));
    System.out.println(String.format("%s", stack.dequeueDog().name));
    System.out.println(String.format("%s", stack.dequeueDog().name));
    System.out.println(String.format("%s", stack.dequeueCat().name));
    System.out.println(String.format("%s", stack.dequeueCat().name));
    System.out.println(String.format("%s", stack.dequeueDog().name));
    System.out.println(String.format("%s", stack.dequeueDog().name));
    System.out.println(String.format("%s", stack.dequeueCat().name));
    System.out.println(String.format("%s", stack.dequeueCat().name));
  }

  public static class Animal {
    String name;
    long time;

    public Animal(String name, long time) {
      this.name = name;
      this.time = time;
    }
  }

  public static class Dog extends Animal {
    public Dog(String name, long time) {
      super(name, time);
    }
  }

  public static class Cat extends Animal {
    public Cat(String name, long time) {
      super(name, time);
    }
  }

  public static class PriorityStack {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();

    public void enqueue(Animal animal) {
      if (animal instanceof Cat) {
        cats.addLast((Cat) animal);
      } else if (animal instanceof Dog) {
        dogs.addLast((Dog) animal);
      }
    }

    public Animal dequeueAny() {
      if (dogs.size() == 0) {
        return cats.removeFirst();
      } else if (cats.size() == 0) {
        return dogs.removeFirst();
      }

      if (cats.peek().time > dogs.peek().time) {
        return dogs.removeFirst();
      } else {
        return cats.removeFirst();
      }
    }

    public Dog dequeueDog() {
      return dogs.removeFirst();
    }

    public Cat dequeueCat() {
      return cats.removeFirst();
    }

    public boolean isEmpty() {
      return dogs.size() + cats.size() == 0;
    }
  }
}
