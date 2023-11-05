package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
  private int balance;
  private Map<String, Drink> drinkInventory;
  private static VendingMachine instance;

  private VendingMachineImpl() {
    this.balance = 0;
    this.drinkInventory = new HashMap<>();

    drinkInventory.put("ScottCola", new ScottCola());
    drinkInventory.put("KarenTea", new KarenTea());
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter() {
    balance += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (drinkInventory.containsKey(name)) {
      Drink selectedDrink = drinkInventory.get(name);
      if (balance >= 75) {
        balance -= 75;
        return selectedDrink;
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }
  }
}
