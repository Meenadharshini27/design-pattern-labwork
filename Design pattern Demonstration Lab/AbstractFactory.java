abstract class Coffee {
    
    public final void brew() {
      boilWater();
      brewCoffee();
      pourInCup();
      addCondiments();
    }
  
    
    protected abstract void brewCoffee();
    protected abstract void addCondiments();
  
    
    private void boilWater() {
      System.out.println("Boiling water");
    }
  
    private void pourInCup() {
      System.out.println("Pouring in cup");
    }
  }
  
  
  class Espresso extends Coffee {
    @Override
    protected void brewCoffee() {
      System.out.println("Brewing espresso");
    }
  
    @Override
    protected void addCondiments() {
      System.out.println("Adding sugar");
    }
  }
  
  
  class Cappuccino extends Coffee {
    @Override
    protected void brewCoffee() {
      System.out.println("Brewing cappuccino");
    }
  
    @Override
    protected void addCondiments() {
      System.out.println("Adding frothed milk");
    }
  }
  
  
  public class AbstractFactory {
    public static void main(String[] args) {
      Coffee espresso = new Espresso();
      espresso.brew();
  
      Coffee cappuccino = new Cappuccino();
      cappuccino.brew();
    }
  }
  