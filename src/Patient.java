public class Patient extends Person{
   /** Define the Patient class  */
   private String illness;//the illness of the Patient
   private String bloodGroup;//the blood group of the Patient
   private Doctor doctor;//the doctor of the Patient
   private Medicine[] medicine;//the medicine of the Patient
   private Room room;//the room of the Patient

     public Patient(String illness,String bloodGroup,int id,String name,String nationality,char gender,int phone,int totMedicine){
        super(id, name, nationality, gender, phone);//super class constructor
         /** Construct a Patient object */
        this.illness=illness;
        this.bloodGroup=bloodGroup;
        this.doctor=doctor;
        this.room=room;
       this.medicine=new Medicine[totMedicine];
    }
     
     public int getTotalMedicine(){
     /** Return the total number of medicine for this patient */
     return medicine.length;
}
 /**----------------------------------------------------------------------------------------------------------------------------*/
     public String getIllness() {
    /** Return the illness of this patient */
        return illness;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setIllness(String illness) {
        this.illness = illness;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getBloodGroup() {
     /** Return the blood group of this patient */
        return bloodGroup;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public Doctor getDoctor() {
    /** Return the doctor of this patient */
        return doctor;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public Medicine getMedicine(int index) {
    /** Return the medicine\s of this patient */
       return medicine[index];
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setMedicine(Medicine medicine,int index) {
          this.medicine[index] = medicine;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public Room getRoom() {
    /** Return the room of this patient */
        return room;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setRoom(Room room) {
        this.room = room;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
  public double calTotalBill(){
    double total=0;
    total+=this.doctor.getConsultationFees();
    total+=this.room.getCharges();
    for (int i=0;i<medicine.length;i++){
        total+=medicine[i].getPrice();
  }
    return total;  
  }
 /**----------------------------------------------------------------------------------------------------------------------------*/
   public String printPatientBasicInfo(){
  return super.toString()+ "Illness: " + illness + ", BloodGroup: " + bloodGroup; 
    }

/**----------------------------------------------------------------------------------------------------------------------------*/  
   @Override
    public String toString() {
      /** Return the information of this patient */
       return super.toString()+"\n------------------------------------------------------------------------------------------- "+"\nIllness: " + illness + ", BloodGroup: " + bloodGroup+"\n-------------------------------------------------------------------------------------------";
    }
}
