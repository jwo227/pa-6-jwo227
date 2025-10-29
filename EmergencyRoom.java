import java.util.*;

public class EmergencyRoom{
  private PriorityQueue<Patient> triageQueue;
  private ArrayList<MedicalRecord> medicalRecords;
  private LinkedList<Patient> treatmentRoomQueue; 
  private Queue<Prescription> prescriptionQueue; //shuffles songs before playing them
  private Stack<String> operationHistory;
  private ArrayList<Patient> patientDB;
  private boolean filled;

  public EmergencyRoom() {
    triageQueue = new PriorityQueue<>();
    medicalRecords = new ArrayList<>();
    treatmentRoomQueue = new LinkedList<>();
    prescriptionQueue = new LinkedList<>();
    operationHistory = new Stack<>();
    patientDB = new ArrayList<>();
    filled = false;
  }

  /*
  * @param p
  *adds patient to treatMentRoomQueue
  */
  public void admitPatient(Patient p) {
        triageQueue.add(p);
        patientDB.add(p);
        operationHistory.push("Patient " + p + " admitted");   
  }

  /*
  *
  *@return patient from patient database that is up next in treatmentRoomQueue
  */
  public Patient treatNextPatient() {
    if(triageQueue.isEmpty()) {return null;}
    Patient nextPatient = triageQueue.poll();
    treatmentRoomQueue.add(nextPatient);
    operationHistory.add("Patient " + nextPatient + " up next");
       
      
    
    return nextPatient;
  }

  /*
  *
  *@param patientID
  *remove patient from treatmentRoomQueue
  */
  public void completePatientTreatment(String patientID) {
        if(!treatmentRoomQueue.isEmpty())
          treatmentRoomQueue.remove(patientID);
        Iterator<Patient> iter = treatmentRoomQueue.iterator();
        while(iter.hasNext()) {
          Patient p = iter.next();
          if(p.getPatientId().equals(patientID))
            iter.remove();
            operationHistory.add("Patient " + p.getPatientId() + " treatment completed");
            return;
        }
        //set patient treated status to 'true'
        
      
    
  }

  /*
  *
  *@param mr
  *adds new patient into medical records 
  */
  public void addMedicalRecord(MedicalRecord mr) {
    medicalRecords.add(mr);
    operationHistory.push("Medical Record " + mr.getID() + " added");
  }

  /*
  * 
  *@param p
  *adds new prescription to queue
  */
  public void issuePrescription(Prescription p) {
    prescriptionQueue.add(p);
    operationHistory.add("Prescription " + p.getPatientID() + " issued");
  }

  /*
  *
  *add new prescription into queue
  */
  public Prescription fillNextPrescription() {
    if(prescriptionQueue.isEmpty())
      return null;
    Prescription pr = prescriptionQueue.poll();
    this.filled = true;
    operationHistory.add("ER operation --> Prescription filled:" + pr.getID());
    return pr;
      
    //set filled status to true
  }

  /*
  *
  *@return list of patients that are recieving treatment
  */
  public List<Patient> getPatientsInTreatment() {
    List<Patient> patientsInTreatment = new ArrayList<>();
    for (Patient copyPatient : treatmentRoomQueue) {
      patientsInTreatment.add(copyPatient);
    }
    return patientsInTreatment;
  }

  /*
  *
  * @return counts number of prescriptions in queue
  */
  public int getPendingPrescriptionCount() {
    return prescriptionQueue.size();
  }

  /*
  * @return true if queue is restored to previous state (undo peek, pop, etc.); false otherwise
  */
  public boolean undoLastOperation() {
    if(operationHistory.isEmpty()) {return false;}
    String lastOperation = operationHistory.pop();
    System.out.println("Undoing ER operation --> " + lastOperation);
    return true;
    
  }
    
  public List<String> getOperationHistory() {
    List<String> listOperationHistory = new ArrayList<>();
    for (int index = 0; index < operationHistory.size(); index++) {
      listOperationHistory.add(operationHistory.get(index));
    }

    return listOperationHistory;
  }

  public List<Patient> getTriageWaitingList() {
    List<Patient> listTriageWaitingList = new ArrayList<>();
    for (Patient copyPatient : triageQueue) {
      listTriageWaitingList.add(copyPatient);
    }

    return listTriageWaitingList;
  }


  public List <Pair<String, Double>> getAverageWaitingTimeBySeverity() {
    List<Pair<String, Double>> averageTimeBySeverity = new ArrayList<>(4);
    int[] waitingTimeSizes = new int[4];
    double[] waitingTimeSum = new double[4];
    double[] averageWaitTime = new double[4];
    
    for (Patient patients : patientDB) {
      String severityCategory = patients.getSeverity();
      double waitingTime = patients.getWaitingTime();
      
      if (severityCategory.equals("CRITICAL")) {
        waitingTimeSizes[0]++;
        waitingTimeSum[0] += waitingTime;
      } else if (severityCategory.equals("URGENT")) {
        waitingTimeSizes[1]++;
        waitingTimeSum[1] += waitingTime;
      } else if (severityCategory.equals("STANDARD")) {
        waitingTimeSizes[2]++;
        waitingTimeSum[2] += waitingTime;
      } else if (severityCategory.equals("NON_URGENT")) {
        waitingTimeSizes[3]++;
        waitingTimeSum[3] += waitingTime;
      }

      
    }
    for (int i = 0; i < averageWaitTime.length; i++) {
      averageWaitTime[i] += waitingTimeSum[i]/waitingTimeSizes[i];
      averageTimeBySeverity.add(new Pair<String,Double>("null", averageWaitTime[i]));
    }
    
    return averageTimeBySeverity;
  }

  public List<Pair<String, Integer>> getPatientCountBySeverity() {
    List<Pair<String, Integer>> patientCountBySeverity = new ArrayList<>();
    int critical = 0, urgent = 0, standard = 0, nonUrgent = 0; 
    for (Patient patients : patientDB) {
      switch(patients.getSeverity()) {
        case "CRITICAL": critical++; break;
        case "URGENT": urgent++; break;
        case "STANDARD": standard++; break;
        case "NON_URGENT": nonUrgent++; break;
      }
    }

    patientCountBySeverity.add(new Pair<String,Integer>("CRITICAL", critical));
    patientCountBySeverity.add(new Pair<String,Integer>("URGENT", urgent));
    patientCountBySeverity.add(new Pair<String,Integer>("STANDARD", standard));
    patientCountBySeverity.add(new Pair<String,Integer>("NON_URGENT", nonUrgent));
    return patientCountBySeverity;
  }

  public double getTreatmentRoomUtilization(int rooms) {
    double percentage = patientDB.size()/(double) rooms;
    return percentage;
  }

}
