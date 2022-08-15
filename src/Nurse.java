public class Nurse extends Staff {
     /** Define the Nurse class*/
    private int experience;//the experience years of the nurse

   public Nurse(int experience,String staffid,String specialization,int id,String name,String nationality,char gender,int phone){
        super(specialization, staffid, id, name, nationality, gender, phone);//super class constructor
        /** Construct a Nurse object */
         this.experience= experience; 
    }
    
   public int getExperience() {
     /** Return the experience years of this nurse */
        return experience;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setExperience(int experience) {
    /** set a new experience years of this nurse */
        this.experience = experience;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/   
    @Override
    public String toString() {
    /** Return the information of this nurse */
        return  super.toString()+"\n\tExperience Year: " + experience ;
    }
}
