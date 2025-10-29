import java.time.LocalDateTime;

public class MedicalRecord {
  private String id;
  private String patientId;
  private String diagnosis;
  private String treatment;
  private String prescribedMedication;
  private LocalDateTime visitDate;
  private String doctorName;

  public MedicalRecord(String id, String patientId, LocalDateTime visitDate,String diagnosis, String treatment, String prescribedMedication, String doctorName) {
    this.id = id;
    this.patientId = patientId;
    this.visitDate = visitDate;
    this.doctorName = doctorName;
    this.prescribedMedication = prescribedMedication;
    this.diagnosis = diagnosis;
    this.treatment = treatment;
  }
  
  public String getID() {return this.id;}
  public String getPatientId() {return this.patientId;}
  public LocalDateTime getVisitDate() {return this.visitDate;}
  public String getDoctorName() {return this.doctorName;}
  public String getDiagnosis() {return this.diagnosis;}
  public String getPrescribedMedication() {return this.prescribedMedication;}
  public String getTreatment() {return this.treatment;}

  public void setPatientId(String patientID) {this.patientId = patientID;}
  public void setVisitDate(LocalDateTime visitDate) {this.visitDate = visitDate;}
  public void setDoctorName(String doctorName) {this.doctorName = doctorName;}
  public void setPrescribedMedication(String prescribedMedication) {this.prescribedMedication = prescribedMedication;}
  public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}
  public void setTreatment(String treatment) {this.treatment = treatment;}
  public void setID(String id) {this.id = id;}

  public String toString() {
    return String.format("%-6s\t%-8s\t%-20s\t%-20s\t%-15s\t%-15s\t%-20s", 
                          id, patientId, diagnosis, treatment, prescribedMedication, doctorName, visitDate);
  }
  
}
