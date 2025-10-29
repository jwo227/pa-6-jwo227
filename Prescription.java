import java.time.LocalDateTime;

public class Prescription {
  private String id;
  private String patientID;
  private String patientName;
  private String medication;
  private String dosage;
  private LocalDateTime issuedTime;
  private boolean filled;

  public Prescription(String id, String patientID, String patientName, String medication, String dosage) {
    this.id = id;
    this.patientID = patientID;
    this.issuedTime = LocalDateTime.now();
    this.patientName = patientName;
    this.medication = medication;
    this.dosage = dosage;
    this.filled = false;
    
  }

  public String getID() {return this.id;}
  public String getPatientID() {return this.patientID;}
  public String getPatientName() {return this.patientName;}
  public String getMedication() {return this.medication;}
  public String getDosage() {return this.dosage;}
  public LocalDateTime getIssuedTime() {return this.issuedTime;}

  public void setID(String id) {this.id = id;}
  public void setPatientId(String patientID) {this.patientID = patientID;}
  public void setPatientName(String patientName) {this.patientName = patientName;}
  public void setMedication(String medication) {this.medication = medication;}
  public void setDosage(String dosage) {this.dosage = dosage;}
  public void setIssuedTime(LocalDateTime issuedTime) {this.issuedTime = issuedTime;}

  public String toString() {
    return String.format("", id);
  }
}
