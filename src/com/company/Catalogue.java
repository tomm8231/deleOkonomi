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

  public Item[] getFullList() {
    return items;
  }

  }

