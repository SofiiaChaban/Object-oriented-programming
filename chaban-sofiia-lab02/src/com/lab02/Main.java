package com.lab02;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Main {
    public static Container containerNew = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("_______Menu_______");
            System.out.println("1 - make container");
            System.out.println("2 - fill container");
            System.out.println("3 - clear container");
            System.out.println("4 - show container");
            System.out.println("5 - menu for container");
            System.out.println("6 - exit");
            System.out.println("__________________");
            Scanner scan = new Scanner(System.in);
            byte command = scan.nextByte();
            switch (command) {
                case 1:
                    System.out.println("Enter the length of container");
                    int length = scan.nextInt();
                    containerNew = new Container(length);
                    System.out.println("Done! You have created a container");
                    break;
                case 2:
                    if (containerNew != null) {
                        System.out.println("Enter a string to add in container. To stop print '/stop'");
                        scan.nextLine();
                        String str = scan.nextLine();
                        while (!str.equals("/stop")) {
                            containerNew.add(str);
                            str = scan.nextLine();
                        }
                    } else System.out.println("Create container first!");
                    break;
                case 3:
                    if (containerNew != null) {
                        containerNew.clear();
                        System.out.println("Container is clear");
                    } else System.out.println("Create container first!");
                    break;
                case 4:
                    if (containerNew != null) {
                        System.out.println("Here is your container:");
                        System.out.println(containerNew.toString());
                    } else System.out.println("Create container first!");
                    break;
                case 5:
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("            Welcome to container menu");
                    System.out.println("|1 - add element to container");
                    System.out.println("|2 - remove element");
                    System.out.println("|3 - convert to array and iterate through");
                    System.out.println("|4 - current size");
                    System.out.println("|5 - check whether a string is equal");
                    System.out.println("|6 - check if any other container is equal");
                    System.out.println("|7 - get element by index");
                    System.out.println("|8 - get element's index");
                    System.out.println("|9 - sort");
                    System.out.println("|10 - iterate through container (foreach)");
                    System.out.println("|11 - iterate through container (while)");
                    System.out.println("|12 - lets check how the serialization works");
                    System.out.println("|13 - lets check how the deserialization works");
                    System.out.println("|14 -lets complete the task from a previous lab");
                    System.out.println("|15 - return");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    byte command2 = scan.nextByte();
                    switch (command2) {
                        case 1:
                            System.out.println("Enter a string you want to add");
                             scan.nextLine();
                            containerNew.add(scan.nextLine());
                            System.out.println("Done! An element has been added");
                            break;
                        case 2:
                            System.out.println("Write down an element,which you want to delete");
                            scan.nextLine();
                            if (containerNew.remove(scan.nextLine())) {
                                System.out.println("Done! An element has been removed");
                            } else {
                                System.out.println("Error! The element doesn't exist");
                            }
                            break;
                        case 3:
                            System.out.println("Let's convert your container to array");
                            System.out.println("Converting...");
                            String[] array = containerNew.toArray();
                            System.out.println("Done!");
                            System.out.println("Now let's look at your array :)");
                            System.out.print("[");
                            for (int i = 0; i < array.length; i++) {
                                System.out.print(" " + array[i]);
                            }
                            System.out.println("]");
                            break;
                        case 4:
                            System.out.println("The current size of your container is: " + containerNew.size());
                            break;
                        case 5:
                            System.out.println("Let's check if container contains an element");
                            System.out.println("Enter the element");
                             scan.nextLine();
                            if (containerNew.contain(scan.nextLine())) {
                                System.out.println("Yay! Container contains this element");
                            } else {
                                System.out.println("Ooops...There is no such element");
                            }
                            break;
                        case 6:
                            System.out.println("Let's check whether two containers are equal");
                            System.out.println("Let's create another one container");
                            Container container1 = new Container(1000);
                            System.out.println("Let's add some elements");
                            for (int i = 0; i < containerNew.size(); i++) {
                                scan.nextLine();
                                container1.add(scan.nextLine());
                            }
                            System.out.println("Done! Let's compare two containers..");
                            System.out.println("Comparing...");
                            if (containerNew.containsAll(container1)) {
                                System.out.println("Yay! These containers are equal");
                            } else {
                                System.out.println("Ooops..these containers are not equal!");
                            }
                            break;
                        case 7:
                            System.out.println("Let's get element from container by index");
                            System.out.println("Enter an index: ");
                            //scan.nextInt();
                            System.out.println(containerNew.getElement(scan.nextInt()));
                            System.out.println("Done!");
                            break;
                        case 8:
                            System.out.println("Let's get element's index");
                            System.out.println("Enter an element");
                            scan.nextLine();
                            System.out.println(containerNew.getIndex(scan.nextLine()));
                            System.out.println("Done!");
                            break;
                        case 9:
                            System.out.println("Let's sort your container");
                            System.out.println("Sorting...");
                            containerNew.sort();
                            System.out.println("Done!");
                            break;
                        case 10:
                            System.out.println("Let's iterate your container by foreach loop");
                            for (String s1 : containerNew.toArray()) {
                                System.out.println(s1 + ",");
                            }
                            System.out.println("Done!");
                            break;
                        case 11:
                            System.out.println("Let's iterate your container by while loop");
                            Iterator<String> iter = containerNew.iterator();
                            while (iter.hasNext()) {
                                System.out.println(iter.next() + ", ");
                            }
                            System.out.println("Done!");
                            break;
                        case 12:
                            System.out.println("Let's check serialization");
                            System.out.println("Enter name of file");
                             scan.nextLine();
                            if (containerNew.serialize(scan.nextLine())) {
                                System.out.println("Done");
                            } else {
                                System.out.println("Error");
                            }
                            break;
                        case 13:
                            scan.nextLine();
                            if (containerNew.deserialize(scan.nextLine())) {
                                System.out.println("Done");
                            } else {
                                System.out.println("Error");
                            }
                            break;
                        case 14:
                            System.out.println("Let's do a task from previous lab with our container");
                            System.out.println("Calculating...");
                            String text = containerNew.toString();
                            ArrayList<String> res = new ArrayList<>();
                            ArrayList<String> words = new ArrayList<>();
                            if (text != null) {
                                int counter = 0, wordStart = 0;
                                boolean word = false;
                                while (counter != text.length()) {
                                    if ((Character.isDigit(text.charAt(counter)) ||
                                            Character.isAlphabetic(text.charAt(counter))) && !word) {
                                        wordStart = counter;
                                        word = true;
                                    } else if (!Character.isDigit(text.charAt(counter)) &&
                                            !Character.isAlphabetic(text.charAt(counter)) && word) {
                                        words.add(text.substring(wordStart, counter));
                                        word = false;
                                    }
                                    counter++;
                                }
                            }
                            for (int i = 0; i < words.size(); i++) {
                                int length1 = words.get(i).length();
                                if (words.get(i).charAt(0) == words.get(i).charAt(length1 - 1)) {
                                    res.add(words.get(i));
                                }
                            }
                            System.out.println("All calculations are done!");
                            System.out.println("Now, let's see a result");
                            for (String s : res) {
                                System.out.println(s);
                            }
                            break;
                        case 15:
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Bye-bye");
                    System.exit(0);
                default:
                    System.out.println("Oops! Wrong input");

            }

        }
    }
}
