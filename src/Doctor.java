public class Doctor extends Staff{
     /** Define the Doctor class*/
    private double consultationFees;//the consultation fees of the doctor

    public Doctor(double consultationFees,String staffid,String specialization,int id,String name,String nationality,char gender,int phone){
        super(specialization, staffid, id, name, nationality, gender, phone);//super class constructor
         /** Construct a Doctor object */
        this.consultationFees=consultationFees;
    }
    
    public double getConsultationFees() {
    /** Return the consultation fees of this doctor */
        return consultationFees;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setConsultationFees(double consultationFees) {
       /** set a new consultation fees of this doctor */
        this.consultationFees = consultationFees;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public String toString() {
     /** Return the information of this doctor */
        return super.toString()+"\n\tConsultation Fees :" + consultationFees;
    }
}
