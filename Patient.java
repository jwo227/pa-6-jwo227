import java.time.LocalDateTime;

public class Patient implements Comparable<Patient> {
  private static final String[] severities = {"CRITICAL", "URGENT", "STANDARD", "NON_URGENT"};
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
    this.arrivalTime = LocalDateTime.now();
    this.severity = severity;
    this.symptoms = symptoms;
    this.treated = false;
  }

  public String getPatientId() {return id;}
  public String getName() {return name;}
  public String getSeverity() {return severity;}
  public String getSymptoms() {return symptoms;}
  public int getAge() {return age;}
  public boolean isTreated() {return treated;}
  public long getWaitingTime() {
    return java.time.LocalDateTime.now().getSecond() - arrivalTime.getSecond();
  }

  public void setPatientId(String d) {this.id = d;}
  public void setTreated(boolean treated) {this.treated = treated;}
  public void setName(String n) {this.name = n;}
  public void setSeverity(String s) {this.severity = s;}
  public void setSymptoms(String y) {this.symptoms = y;}
  public void setAge(int a) {this.age = a;}


  public int compareTo(Patient o) {
    if(this.severity.equals(o.severity)) {
      return 0;
    } else if (this.severity.equals("CRITICAL")) {
      return -1;
    } else if (o.severity.equals("CRITICAL")) {
      return 1;
    } else if (this.severity.equals("URGENT")) {
      return -1;
    } else if (o.severity.equals("URGENT")) {
      return 1;
    } else if (this.severity.equals("STANDARD")) {
      return -1;
    } else {
      return 1;
    }
  }

  public boolean equals(Object o) {
    if(o instanceof Patient) {
      Patient p = (Patient) o;
      return id.equals(p.getPatientId()); 
    }
    return false;
  }
  
  public String toString() {
    return String.format("%-5s\t%-16s\t%02d\t%-10s", 
                             id, name, age, severity);
  }
  
  
}


