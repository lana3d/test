package test.Exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Animal {
    private String name;
    private String color;
    private int numOfLegs;
    private int lifeExpectancy;


    public Animal(String name, String color, int numOfLegs, int lifeExpectancy) {

        this.name = name;
        this.color = color;
        this.numOfLegs = numOfLegs;
        this.lifeExpectancy = lifeExpectancy;
    }

    public static void main(String[] args) throws IOException {
        Animal[] animalsArray = new Animal[10];
        animalsArray[0] = new Vegetarian("Elephant", "grey", 4, 70, "grass");
        animalsArray[1] = new Predator("Hyena", "brown", 4, 12, "humans");
        animalsArray[2] = new Vegetarian("Rhino", "grey", 4, 50, "grass");
        animalsArray[3] = new Vegetarian("Hippo", "brown", 4, 40, "grass");
        animalsArray[4] = new Vegetarian("Bison", "brown", 4, 15, "grass");
        animalsArray[5] = new Vegetarian("Wildebeest", "grey", 4, 20, "grass");
        animalsArray[6] = new Predator("Lion", "orange", 4, 14, "buffalo");
        animalsArray[7] = new Predator("Fox", "orange", 4, 5, "birds");
        animalsArray[8] = new Predator("Leopard", "orange", 4, 17, "antelope");
        animalsArray[9] = new Predator("Bear", "brown", 4, 20, "fish");

        BufferedWriter writer = new BufferedWriter(new FileWriter("c:/temp/samplefile1.txt"));
        for (Animal animal : animalsArray) {
            System.out.println(animal.toString());
            writer.write(animal.toString());
            writer.newLine();
         }
        writer.close();



        System.out.println("\nFirst Name letters: ");
        for (Animal animal : animalsArray) {
            System.out.println(animal.getName().substring(0, 1));
        }
        int sumLegs = calculateLegs(animalsArray);
        System.out.println("\nSum Number of legs: " + sumLegs);

        String longLifeAnimal = calculateHighestLifExpectancy(animalsArray);
        System.out.println("\nThe animal with the highest life expectancy: " + longLifeAnimal);

        String popularColor = calculatePopularColor(animalsArray);
        System.out.println("\nThe most popular color: " + popularColor);

        Arrays.sort(animalsArray, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return (o2.getLifeExpectancy() - o1.getLifeExpectancy());
            }
        });
        System.out.println("\nSorted by Life Expectancy: ");
        for (Animal animal : animalsArray)
            System.out.println(animal);


        System.out.println("\nNames without vowels: ");
        removeAEIOU(animalsArray);


        System.out.println("\nIf there are 2 equal animal habits: " + isTwoEqualHabit(animalsArray));


    }

    public static int calculateLegs(Animal[] animalsArray) {
        int sumLegs = 0;
        for (Animal animal : animalsArray) {
            int numOfLegs = animal.getNumOfLegs();
            sumLegs = sumLegs + numOfLegs;
        }
        return sumLegs;
    }
    /*public static void colorCounter(Animal[] a, int n) {
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i].getColor() == a[j].getColor()) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(a[i].getColor() + count);
        }
    }*/


    public static String calculatePopularColor(Animal[] a) {


        String mostPopularColor = a[0].getColor();
        int maxcount = 0;
        for (Animal animalCurrent : a) {
            int count = 0;
            for (Animal animal : a) {
                if (animal.getColor() == animalCurrent.getColor()) {
                    count = count + 1;
                }
                if (count > maxcount) {
                    maxcount = count;
                    mostPopularColor = animalCurrent.getColor();
                }
            }
        }
        return mostPopularColor;
    }

    public static String calculateHighestLifExpectancy(Animal[] a) {
        int max = a[0].getLifeExpectancy();
        String highestLifExpectancy = a[0].getName();
        for (Animal i : a) {
            if (i.getLifeExpectancy() > max) {
                highestLifExpectancy = i.getName();
            }
        }
        return highestLifExpectancy;
    }

    public static String removeAEIOU(Animal[] a) {
        String nameWithoutAEIOU = "";
        char[] AEIOU = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (Animal animal : a) {
            String name = animal.getName();
            for (char x : AEIOU) {

                if (animal.getName().contains(String.valueOf(x))) {

                    name = name.replace(String.valueOf(x), "");

                }
            }
            nameWithoutAEIOU = name;
            System.out.println(nameWithoutAEIOU);
        }

        return nameWithoutAEIOU;

    }

    public static boolean isTwoEqualHabit(Animal[] a) {


        String habit = "";
        String habits[] = new String[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] instanceof Vegetarian) {
                Vegetarian b = (Vegetarian) a[i];
                habit = b.getFavoriteVegetable();
                habits[i] = habit;
            } else if (a[i] instanceof Predator) {
                Predator p = (Predator) a[i];
                habit = p.getFavoritePray();
                habits[i] = habit;
            }
        }

         for (String h : habits) {
             int count = 0;
             for (int i = 0; i < a.length; i++) {
                 if ((habits[i]).equals(h)) {
                     count = count + 1;

                     if (count == 2)
                         return true;
                 }
             }
         }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

}

