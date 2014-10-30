package java01.test41;

public class Car {
  String model;
  String maker;
  int cc = 800;
  boolean diesel;
  java.util.Date releaseDate;
  int capacity = 5;  
  
  public Car(String maker, String model, int cc) {
    this.maker = maker;
    this.model = model;
    this.cc = cc;
  }

}
