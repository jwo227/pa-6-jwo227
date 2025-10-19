import java.util.*;

public class EmergencyRoom() {
  private PriotiryQueue<Patient> triageQueue;
  private ArrayList<MedicalRecord> medicalRecords;
  private LinkedList<Patient> treatmentRoomQueue; 
  private Queue<Prescription> prescriptionQueue; //shuffles songs before playing them
  private Stack<String> operationHistory;
  private ArrayList<Patient> patientDB;

  public EmergencyRoom() {
    triageQueue = new PriorityQueue<>;
    medicalRecords = new ArrayList<>;
    treatmentRoomQueue = new LinkedList<>;
    prescriptionQueue = new Queue<>;
    operationHistory = new Stack<>();
    patientDB = new ArrayList<>();
  }

  /*
  * @param p
  *adds patient to treatMentRoomQueue
  */
  public void admitPatient(Patient p) {
    
  }

  /*
  *
  *@return patient from patient database that is up next in treatmentRoomQueue
  */
  public Patient treatNextPatient() {
    return null;
  }

  /*
  *
  *@param patientID
  *remove patient from treatmentRoomQueue
  */
  public void completePatientTreatment(String patientID) {
    //remove patient id from treatmentRoomQueue
  }

  /*
  *
  *@param mr
  *adds new patient into medical records 
  */
  public void addMedicalRecord(MedicalRecord mr) {
    //add new patient into medical records using id
  }

  /*
  * 
  *@param p
  *adds new prescription to queue
  */
  public void issuePrescription(Presciption p) {
    //assign prescription to patient and remove from queue
  }

  /*
  *
  *add new prescription into queue
  */
  public void fillNextPrescription() {
    //add new prescription into queue
  }

  /*
  *
  *@return list of patients that are recieving treatment
  */
  public List<Patient> getPatientsInTreatment() {
    return null;
  }

  /*
  *
  * @return counts number of prescriptions in queue
  */
  public int getPendingPrescriptionCount() {
    return 0;
  }

  /*
  * @return true if queue is restored to previous state (undo peek, pop, etc.); false otherwise
  */
  public boolean undoLastOperation() {
    return false;
  }
     
  
}
