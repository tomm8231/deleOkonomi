package com.company;

public class Item {

  private String category;
  private String description;
  private boolean isAvailable;

  public Item(String category, String description) {
    this.category = category;
    this.description = description;
    isAvailable = true;
  }

  public String getDescription() {
   return description;
  }

  public boolean showAvailability() {
    return isAvailable;
  }

  public void makeAvailable() {
      isAvailable = true;
  }

  public void makeUnavailable() {
    isAvailable = false;
  }


    public String toString () {
      return category + " " + description + " " + isAvailable;
    }
  }
