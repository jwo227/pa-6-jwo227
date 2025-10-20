import java.util.*;

public class MedicalRecord {
  private String id;
  private String patientID;
  private String diagnosis;
  private String treatment;
  private String prescribedMedication;
  private LocalDateTime visitDate;
  private String doctorName;

  public Prescription(String id, String patientID, LocalDateTime visitDate, String diagnosis, String prescribedMedication, String doctorName) {
    this.id = id;
    this.patientID = patientID;
    this.visitDate = visitDate;
    this.doctorName = doctorName;
    this.prescribedMedication = prescribedMedication;
    this.diagnosis = diagnosis;
    this.treatment = treatment;
  }
  
  public String getID() {return this.id;}
  public String getPatientID() {return this.patientID;}
  public LocalDateTime getVisitDate() {return this.visitDate;}
  public String getDoctorName() {return this.doctorName;}
  public String getPrescribedMedication() {return this.prescribedMedication;}
  public String getPatientID() {return this.patientID;}
  public String getTreatment() {return this.treatment;}

  public void setID(String id) {this.id = id;}
  public void setPatientID(String patientID) {this.patientID = patientID;}
  public void setVisitDate(LocalDateTime visitDate) {this.visitDate = visitDate;}
  public void setDoctorName(String doctorName) {this.doctorName = doctorName;}
  public void setPrescribedMedication(String prescribedMedication) {this.prescribedMedication = prescribedMedication;}
  public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}
  public void setID(String treatment) {this.treatment = treatment;}

  public String toString() {
    return String.format("", id);
  }
  
}
