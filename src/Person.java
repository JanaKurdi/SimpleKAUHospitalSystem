public class Person implements Comparable<Person> {
     /** Define the super class "Person" */
    int id;//the ID of the Person
    String name;//the name of the Person
    String nationality;//the nationality of the Person
    char gender;//the gender of the Person
    int phone;//phone number of thePerson
   
    public Person(int id,String name,String nationality,char gender,int phone){
    /** Construct a Person object */
      this.id=id;
      this.name=name;
      this.nationality=nationality;
      this.gender=gender;
      this.phone=phone;
    }

    public int getId() {
    /** Return the ID of this Person */
        return id;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setId(int id) {
   /** set a new ID for this Person */
         this.id = id;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getName() {
   /** Return the name of this Person */
        return name;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setName(String name) {
    /** set a new name for this Person */
        this.name = name;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getNationality() {
    /** Return the nationality of this Person */
        return nationality;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setNationality(String nationality) {
    /** set a new nationality for this Person */
        this.nationality = nationality;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public char getGender() {
  /** Return the gender of this Person */
        return gender;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setGender(char gender) {
    /** set a new gender for this Person */
        this.gender = gender;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public int getPhone() {
   /** Return the phone number of this Person */
        return phone;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setPhone(int phone) {
    /** set a new phone number for this Person */
        this.phone = phone;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String toString() {
        /** Return the information of this Person */
        return "\tID: " + id + "\n\tName: " + name + "\n\tNationality :" + nationality + "\n\tGender: " + gender + "\n\tPhone: " + phone;
    }
  /**----------------------------------------------------------------------------------------------------------------------------*/  
   @Override
    public int compareTo(Person o) {
 //override compareTo method from comparable interface to sort HPersons array in main using ID   
        if(this.getId()>o.getId())  
        return 1;
    else 
    if(this.getId()<o.getId())  
        return -1;
    else
        return 0;
    }
}
