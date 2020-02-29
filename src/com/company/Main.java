package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        // Hotel Java is a six floor hotel. There are 10 rooms on each floor from 00 to 09.
        // Every room with number 09 is a luxurious apartment with 3 beds and beautiful sea sight. The rooms with number 08
        // have capacity of 3 beds. The other rooms with even numbers have 2 beds capacity and the rooms with odd number
        // have 1 bed capacity. Rooms from 00 to 05 have a sight to the swimming pool and rooms from 06 to 09 have a beautiful sea sight
        // without room 08 which has a sight to the swimming pool.

        int chosenRoom = 0;
        //This array contains the user's information and it is ready to be initialized.
        String[] accommodationInformation = new String[4];
        //This array contains list with available rooks for the chosen date and it is later filtrated by the bed count and sight type.
        int[] availableRooms = {100, 101, 103, 105, 107, 109, 200, 202, 206, 208, 207, 209, 301, 302, 303, 307, 309, 400,
                401, 403, 405, 406, 407, 503, 504, 507, 508, 509, 600, 601, 602, 604, 605, 608, 609};
        //This is the bed capacity of a room.
        int roomCapacity = 0;

        char toChoose;
        // This char is used when the user miss clicks so he can choose what to do again.
        char toChooseSpare;
        // This char is used when the user has chosen one option but after that he wants to choose the other one.
        char chooseToRegisterAfterReadingInfo;
        char chooseTypeOfSight = '0';
        char ChooseRoomCapacity;


        printWelcomeScreen();

        toChoose = sc.next().charAt(0);

        if (toChoose == 'a' || toChoose == 'A') {

            printInfoAboutHotel();
            System.out.print("If you want to register please press 'y' .");
            chooseToRegisterAfterReadingInfo = sc.next().charAt(0);

            if (chooseToRegisterAfterReadingInfo == 'y' || chooseToRegisterAfterReadingInfo == 'Y') {
                register(chooseToRegisterAfterReadingInfo, availableRooms, accommodationInformation, chosenRoom, roomCapacity);
            }

        } else if (toChoose == 'b' || toChoose == 'B') {

            register(chooseTypeOfSight, availableRooms, accommodationInformation, chosenRoom, roomCapacity);

        } else {

            System.out.println("Please press 'a' or 'b' to choose an action." + "\n" + "\n");
            toChooseSpare = sc.next().charAt(0);
            chooseActionSpare(toChooseSpare, availableRooms, chosenRoom, accommodationInformation, roomCapacity);

        }


    }

    public static void printAvailableRooms(int[] available) {

        for (int i = 0; i < available.length; i++) {
            if (i == 0) {
                System.out.println("                                       Available rooms");
            }

            System.out.print(available[i] + ", ");
        }
        System.out.println(" ");
    }


    public static void printInfoAboutHotel() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Java Hotel is situated at one of the most serene areas of Laoag City, Ilocos Norte."
                + "\n" + " It is famous for its unique Balinese Moroccan atmosphere, exquisite Spanish design and warm Ilocano touch. "
                + "\n" + "Java Hotel offers 1st class services, with affordable rates & exceptional amenities."
                + "\n" + "Its recreational facilities will surely meet your needs and expectations for it includes a souvenir shop, "
                + "\n" + "tennis court, fitness gym, swimming pool, and the only wall climbing facility in Laoag City,"
                + "\n" + "as well as The Majestic and The Venetian function halls."
                + "\n");
        System.out.println(" ");
    }


    public static void chooseActionSpare(char choose, int[] availableRooms, int chosenRoom, String[] accommodationInformation, int roomCapacity) {
        Scanner input = new Scanner(System.in);
        //This method is used when the user miss clicks or when the user doesn't press 'a' or 'b'.

        if (choose == 'a' || choose == 'A') {
            printInfoAboutHotel();
        } else if (choose == 'b' || choose == 'B') {
            register(choose, availableRooms, accommodationInformation, chosenRoom, roomCapacity);

            printAccommodationInfoArray(accommodationInformation, chosenRoom);
        }
    }


    public static void printWelcomeScreen() {
        System.out.println(" Welcome to Hotel Java!" + "\n" + "What do you want to do?");
        System.out.println(" ");
        System.out.println("Press 'a' to read information about the hotel.");
        System.out.println(" ");
        System.out.println("Press 'b' to register in the hotel." + "\n");
    }


    public static void fillAccommodationInfoArray(String[] accommodationInformation) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your first and your last name:  ");
        accommodationInformation[0] = input.nextLine();
        System.out.println(" ");

        System.out.print("Please enter date of accommodation:  ");
        accommodationInformation[1] = input.nextLine();
        System.out.println(" ");

        System.out.print("Please enter date of leaving:  ");
        accommodationInformation[2] = input.nextLine();
        System.out.println(" ");

        System.out.print("Extra message:  ");
        accommodationInformation[3] = input.nextLine();
        System.out.println(" ");

    }


    public static void printAccommodationInfoArray(String[] info, int room) {
        System.out.println(room);

        System.out.println("You are registered in our hotel! " + "\n" + "This is your information: " + "\n");
        System.out.println("This is your information: ");
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
        System.out.println("Have a nice stay.");
    }


    public static void register(char chooseTypeOfSight, int[] availableRooms, String[] accommodationInformation, int chosenRoom, int roomCapacity) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        fillAccommodationInfoArray(accommodationInformation);
        printAvailableRooms(availableRooms);

        System.out.print("Please enter the bed capacity of your room. "
                + "Enter '1' for one bed '2' for two beds and '3' for three beds");
        System.out.println(" ");
        roomCapacity = input.nextInt();

        System.out.println("What kind of sight do you want? "
                + "Press 's' for sea sight or press 'p' for inner court and swimming pool sight.");
        chooseTypeOfSight = sc.next().charAt(0);


        for (int i = 0; i < availableRooms.length; i++) {
            if (roomCapacity == 1 && (chooseTypeOfSight == 'p' || chooseTypeOfSight == 'P')) {
                if (availableRooms[i] % 10 == 1 || availableRooms[i] % 10 == 3 || availableRooms[i] % 10 == 5) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
            if (roomCapacity == 2 && (chooseTypeOfSight == 'p' || chooseTypeOfSight == 'P')) {
                if (availableRooms[i] % 10 == 0 || availableRooms[i] % 10 == 2 || availableRooms[i] % 10 == 4) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
            if (roomCapacity == 3 && (chooseTypeOfSight == 'p' || chooseTypeOfSight == 'P')) {
                if (availableRooms[i] % 10 == 8) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
            if (roomCapacity == 1 && (chooseTypeOfSight == 's' || chooseTypeOfSight == 'S')) {
                if (availableRooms[i] % 10 == 7) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
            if (roomCapacity == 2 && (chooseTypeOfSight == 's' || chooseTypeOfSight == 'S')) {
                if (availableRooms[i] % 10 == 6) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
            if (roomCapacity == 3 && (chooseTypeOfSight == 's' || chooseTypeOfSight == 'S')) {
                if (availableRooms[i] % 10 == 9) {
                    System.out.print(availableRooms[i] + ", ");
                }

            }
        }
        System.out.println(" ");
        System.out.print("Please enter a room: ");
        chosenRoom = input.nextInt();

        printAccommodationInfoArray(accommodationInformation, chosenRoom);
    }
}

