import java.util.*;

public class Patient implements Comparable<E> {
  private String[] severities;
  private String id;
  private String name;
  private int age;
  private String severity;
  private String symptoms;
  private LocalDateTime arrivalTime;
  private boolean treated;

  public Patient(String id, String name, int age, String severity, String symptoms) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.severity = severity;
    this.symptoms = symptoms;
  }

  public String getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSeverity() {
    return severity;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public int getAge() {
    return age;
  }

  public void setID(String d) {
    this.id = d;
  }

  public void setName(String n) {
    this.name = n;
  }

  public void setSeverity(String s) {
    this.severity = s;
  }

  public void setSymptoms(String y) {
    this.symptoms = y;
  }

  public void setAge(int a) {
    this.age = a;
  }

  public int compareTo(Patient n, Patient o) {
    int comparisons = n.getSeverity.compareTo(o.getSeverity);
    if(comparisons < 0) {return -1;}
    if(comparisons == 0) {return 0;}
    if(comparisons > 0) {return 1;}
    //order by priority
    //1. Critical
    //2. Urgent
    //3. Standard
    //4. Non_Urgent
  }

  public boolean equals(Object o) {
    if(o instanceof Patient) {
      Patient p = Patient (o);
      return id.equals(o.getID());
    }
    return false;
  }
  
  public String toString() {
    return String.format("%-5s\t%-16s\t%.2d\t%-10s\t", id, name, age, severity);
  }
  public long getWaitingTime() {
    return 0L;
  }
  
}
