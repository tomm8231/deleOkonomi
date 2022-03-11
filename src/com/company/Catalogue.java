package com.company;

public class Catalogue {

  private int counter;

  private Item[] items;

  public Catalogue (int number) {
     this.items = new Item[number];
  }

  public void addItem(Item i) {
    items[counter++] = i;
  }

  //Skal laves om, da getter ikke skal printe
  public Item[] getFullList() {
    System.out.println("Den fulde liste:");
    for(int i = 0; i < counter; i++) {
      Item temp = items[i];
      if (temp != null) {
        System.out.println(temp);
      }
    }
    return items;
  }

  //Skal laves om, da getter ikke skal printe.
  public Item[] getAvailableItems() {
    Item[] availables = new Item[items.length];
    for(int i = 0; i < items.length; i++) {
      Item temp = items[i];
      if (temp != null && temp.showAvailability()) {
        availables[i] = temp;
        System.out.println(temp);
      }
    }
    return availables;
  }
  public Item findItem(String searchName) {
    for(int i = 0; i < items.length; i++) {
      Item temp = items[i];
      if (temp != null && temp.getDescription().equals(searchName)) {
        return temp;
      }
    }
    return null;
  }

  public void borrowItem(Item found) {
    found.makeUnavailable();
  }

  public void returnItem(Item found) {
    found.makeAvailable();
  }

}



