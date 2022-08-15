public class Medicine {
    /** Define the Medicine class */
    private int medicineCode;//the code of the medicine
    private String name;//the name of the medicine
    private double price;//the price of the medicine
    
    public Medicine(int medicineCode,String name,double price){
        /** Construct a Medicine object */
        this.medicineCode=medicineCode;
        this.name=name;
        this.price=price;
    }

    public int getMedicineCode() {
    /** Return the code of this medicine */
        return medicineCode;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setMedicineCode(int medicineCode) {
    /** set a new code for this medicine */
        this.medicineCode = medicineCode;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getName() {
   /** Return the name of this medicine */
        return name;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setName(String name) {
     /** set a new name for this medicine */
        this.name = name;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public double getPrice() {
    /** Return the price of this medicine */
        return price;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setPrice(double price) {
   /** set a new price for this medicine */
        this.price = price;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public String toString() {
       /** Return the information of this medicine */
        return "\tMedicine Code: " + medicineCode + "\n\tName: " + name + "\n\tPrice :" + price;
    }
 }
