package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

  public void mainMenu() {
    Catalogue catalogue = new Catalogue(10);

    //Create items and add to catalogue
    Item item1 = new Item("Sport", "Skateboard");
    catalogue.addItem(item1);
    System.out.println(item1);

    // System.out.println(Arrays.toString(catalogue.getFullList()));
    ///////////////////////////////////////////////

    // Exercise Part 2: Make program with user input instead of hardcoded values
    // Make program able to show menu and handles user choices in loop
    // Ask user what user wants to do

    int choice = -1;

    while (choice != 0) {

      System.out.println("Hvad kunne du tænke dig?");
      System.out.println("1. Se hele kataloget");
      System.out.println("2. Se hvad der er ledigt");
      System.out.println("3. Opret ting til udlån");
      System.out.println("4. Lån ting");
      System.out.println("5. Aflever ting");
      System.out.println("0. Exit");

      // Read user choice
      Scanner sc = new Scanner(System.in);
      choice = sc.nextInt();

      // Decide what to do based on user choice
      if (choice == 1) { // get all items in cataloque
        System.out.println("Den fulde liste:");
        Item[] allItems = catalogue.getFullList();
        for (int i = 0; i < allItems.length; i++) {
          System.out.println(allItems[i]);
        }

      } else if (choice == 2) { // get available items in cataloque
        System.out.println("Hvad der er ledigt:");
        Item[] availableItems = catalogue.getAvailableItems();
        for (int i = 0; i < availableItems.length; i++) {
          System.out.println(availableItems[i]);
        }
      } else if (choice == 3) { // Add new Item to catalogue
        // Hardcoded values for new Item
        System.out.println("Angiv en kategori for genstanden, du vil tilføje:");
        String category = sc.nextLine();
        System.out.println("Angiv en titel på genstanden:");
        String item = sc.nextLine();
        System.out.println();

        catalogue.addItem(new Item(category, item));
        System.out.println("Genstanden er nu tilføjet og kan tilgås via kataloget.");
        System.out.println();
        //System.out.println(Arrays.toString(catalogue.getFullList()));
      } else if (choice == 4) { // make item unavailable
        // Hardcoded search criteria Skateboard
        System.out.println("Hvilken ting vil du låne?");
        sc.nextLine(); //scanner bud
        String itemTest = sc.nextLine();
        Item found = catalogue.findItem(itemTest);
        catalogue.borrowItem(found);
        System.out.println("Du har hermed lånt " + found);
        System.out.println();
      } else if (choice == 5) { // make item available again
        // Hardcoded search criteria Skateboard
        Item found = catalogue.findItem("Skateboard");
        System.out.println(found);
        catalogue.returnItem(found);
        System.out.println(found);
      } else if (choice == 0) {
        System.out.println("Afslutter program");
        System.exit(0);
      }
      else { // invalid choice
        System.out.println("Du foretog et ugyldigt valg.");

      }
    }
  }
}
