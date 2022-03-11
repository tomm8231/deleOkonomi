package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

  private Scanner sc = new Scanner(System.in);

  public void newLine() {
    System.out.println();
  }

  public void showCatalogue(Catalogue catalogue) {
    System.out.println("Den fulde liste:");
    Item[] allItems = catalogue.getFullList();
    for (int i = 0; i < allItems.length; i++) {
    System.out.println(allItems[i]);
    }
    newLine();
  }

  public void showAvailableItems(Catalogue catalogue) {
    System.out.println("Hvad der er ledigt:");
    Item[] availableItems = catalogue.getAvailableItems();
    for (int i = 0; i < availableItems.length; i++) {
      System.out.println(availableItems[i]);
    }
    newLine();
  }

  public void addNewItem(Catalogue catalogue) {
    // Hardcoded values for new Item

    System.out.println("Angiv en kategori for genstanden, du vil tilføje:");
    sc.nextLine();
    String category = sc.nextLine();
    System.out.println("Angiv en titel på genstanden:");
    String item = sc.nextLine();
    newLine();
    catalogue.addItem(new Item(category, item));
    System.out.println("Genstanden er nu tilføjet og kan tilgås via kataloget.");
    newLine();
    //System.out.println(Arrays.toString(catalogue.getFullList()));
  }

  public void makeItemUnavailable(Catalogue catalogue) {
    // Hardcoded search criteria Skateboard
    System.out.println("Hvilken ting vil du låne?");

    sc.nextLine(); // scanner bug
    String itemTest = sc.nextLine();

    Item found = catalogue.findItem(itemTest);
    catalogue.borrowItem(found);

    System.out.println("Du har hermed lånt " + found);
    newLine();
  }

  public void makeItemAvailable(Catalogue catalogue) {
    // Hardcoded search criteria Skateboard
    System.out.println("Hvilken vare vil du aflevere?");

    sc.nextLine();
    String item = sc.nextLine();

    Item found = catalogue.findItem(item);

    System.out.println(found);
    catalogue.returnItem(found);
    System.out.println(found);
    System.out.println("Tak! Varen er nu afleveret.");
    newLine();
  }

  public void terminateProgramme() {
    System.out.println("Afslutter program");
    System.exit(0);
  }

  public void invalidChoiceMessage() {
    System.out.println("Du foretog et ugyldigt valg.");
    newLine();
  }

  public void menuOptions() {
    System.out.println("------------------------------");
    newLine();
    System.out.println("Hvad kunne du tænke dig?");
    newLine();
    System.out.println("1. Se hele kataloget");
    System.out.println("2. Se hvad der er ledigt");
    System.out.println("3. Opret ting til udlån");
    System.out.println("4. Lån ting");
    System.out.println("5. Aflever ting");
    System.out.println("0. Exit");
  }

  public void mainMenu() {
    Catalogue catalogue = new Catalogue(10);

    //Create items and add to catalogue
    Item item1 = new Item("Sport", "Skateboard");
    catalogue.addItem(item1);
    // System.out.println(Arrays.toString(catalogue.getFullList()));
    ///////////////////////////////////////////////

    // Exercise Part 2: Make program with user input instead of hardcoded values
    // Make program able to show menu and handles user choices in loop
    // Ask user what user wants to do

    int choice = -1;

    while (choice != 0) {

      // Menu options
      menuOptions();

      // Read user choice
      choice = sc.nextInt();
      newLine();

      // Decide what to do based on user choice
      switch (choice) {

        case 1 -> {
          showCatalogue(catalogue);
        }
        case 2 -> {
          showAvailableItems(catalogue);
        }
        case 3 -> {
          addNewItem(catalogue);
        }
        case 4 -> {
          makeItemUnavailable(catalogue);
        }
        case 5 -> {
          makeItemAvailable(catalogue);
        }
        case 0 -> {
          terminateProgramme();
        }
        default -> invalidChoiceMessage();

      }
    }
  }
}
