package com.company;

public class Item {

  private String category;
  private String item;
  private boolean isAvailable;

  public Item (String category, String item) {
    this.category = category;
    this.item = item;
    isAvailable = true;
  }

  public boolean showAvailability() {
    return isAvailable;
  }

  public void changeAvailability() {
    if (isAvailable == true) {
      isAvailable = false;
    } else {
      isAvailable = true;
    }
  }


  public String toString() {
    return category + " " + item;
  }

}