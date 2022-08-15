public abstract class  Staff extends Person {
    /** Define the Staff class*/
    private String specialization;//the specialization of the staff member
    private String staffid;//the id of the staff member

    public Staff(String specialization,String staffid,int id,String name,String nationality,char gender,int phone){
        super(id, name, nationality, gender, phone);//super class constructor
        /** Construct a stapp object */
         this.specialization=  specialization;
           this.staffid=staffid;
   }
     public String getSpecialization() {
    /** Return the Specialization of this staff member */
        return specialization;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setSpecialization(String specialization) {
    /** set a new Specialization for this  staff member */
        this.specialization = specialization;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getStaffid() {
    /** Return the id of this staff member */
        return staffid;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setStaffid(String staffid) {
    /** set a new id for this  staff member */
        this.staffid = staffid;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/   
    @Override
    public String toString() {
        /** Return the information of this staff member */
        return super.toString()+"\n\tSpecilalization: " + specialization + "\n\tStaff ID: " + staffid;
    }
}
