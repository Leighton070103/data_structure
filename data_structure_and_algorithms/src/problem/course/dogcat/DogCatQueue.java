package problem.course.dogcat;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DogCatQueue {
    public static final String DOG = "dog";
    public static final String CAT = "cat";
    private int count;
    Queue<Pair<Cat, Integer>> cats;
    Queue<Pair<Dog, Integer>> dogs;

    public DogCatQueue() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
        count = 0;
    }

    void add(Dog dog) {
        dogs.add(new Pair<Dog, Integer>(dog, ++count));
    }

    void add(Cat cat) {
        cats.add(new Pair<Cat, Integer>(cat, ++count));
    }

    boolean isEmpty() {
        return cats.isEmpty() && dogs.isEmpty();
    }

    Cat pollCat() {
        Pair<Cat, Integer> pair = cats.poll();
        System.out.println("Cat Poll: " + pair.getKey().getPetType() + " No." + pair.getValue());
        return pair.getKey();
    }

    Dog pollDog() {
        Pair<Dog, Integer> pair = dogs.poll();
        System.out.println("Dog Poll: " + pair.getKey().getPetType() + " No." + pair.getValue());
        return pair.getKey();

    }

    Pet pollAll() {
        if (dogs.isEmpty() && cats.isEmpty()) return null;
        if (dogs.isEmpty() && !cats.isEmpty()) return cats.poll().getKey();
        if (cats.isEmpty() && !dogs.isEmpty()) return dogs.poll().getKey();
        return dogs.peek().getValue() > cats.peek().getValue() ? dogs.poll().getKey() : cats.poll().getKey();
    }

    public static void main(String[] args){
        menu();
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        while (operation != 0){
            switch (operation){
                case 1: addPet();
                break;
                case 2:
            }
        }
    }

    public static void addPet(){
        System.out.println("11.Add cat");
        System.out.println("11.Add cat");

    }



    private static void menu(){
        System.out.println("Cat and dog queue...");
        System.out.println("Menu");
        System.out.println("1. Add pet");
        System.out.println("2. Poll cat");
        System.out.println("3. Poll Dog");
        System.out.println("4. Poll All");
        System.out.println("5. Is cat empty");
        System.out.println("6. Is dog empty");
        System.out.println("0. Exit");
    }

}
