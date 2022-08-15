//28/11/2020
import java.util.*;//for Scanner
import java.io.*;//for file and printwriter

public class KAUHospitalSystem {

    public static void main(String[] args) throws FileNotFoundException {
         /** Main method */
        File file=new File("input.txt");//create file instace
     if(!file.exists()) {//check if the files are exists or not
       System.out.println("input file not found");
           System.exit(0);
        }
     
     Scanner input=new Scanner(file);//create a Scanner for input file
     PrintWriter output=new PrintWriter("Output.txt");//create file output
     
     /** Declare arrays and read size from input file */
     Room[]HRooms=new Room[input.nextInt()];//1D array for rooms information
     Medicine[]HMedicines=new Medicine[input.nextInt()];//1D array for medicines information
     Person[]HPersons=new Person[input.nextInt()];//1D array for person information
     
     /** Write formatted output to the file */
     output.println("--------------- Welcome to KAU Hospital System ---------------");
     String command;//declare coomand
     int rCounter=0;//counter for HRooms array
     int mCounter=0;//counter for HMedicines array
     int pCounter=0;//counter for HPersons array
     while(input.hasNext()){
        command=input.next();
        
     if(command.matches("Add_Room")){
         //Command #1
         output.println("Command Add_Room: Add a new room record in the System");
         HRooms[rCounter]=getRoom(input);//fill array room with variables form input file
         output.println(HRooms[rCounter].toString()); 
         output.println();
         output.println("----------------------------------------------------------------");
      rCounter++;//increment the room counter
     }
     if(command.matches("Add_Medicine")){
         //Command #2
         output.println("Command Add_Medicine: Add a new Medicine record in the System");
       HMedicines[mCounter]=getMedicineRecord(input);//fill array medicine with variables form input file
         output.println(HMedicines[mCounter].toString()); 
         output.println();
         output.println("----------------------------------------------------------------");
         mCounter++;//increment the medicine counter
     }
     if(command.matches("Add_Doctor")){
         //Command #3
         output.println("Command Add_Doctor: Add a new doctor record in the System");
         HPersons[pCounter]=getDoctor(input);//fill array person with doctor variables form input file
         output.println( HPersons[pCounter].toString()); 
         output.println();
         output.println("----------------------------------------------------------------");
        pCounter++;//increment the person counter
     }
      if(command.matches("Add_Nurse")){
          //Command #4
         output.println("Command Add_Nurse: Add a new nurse record in the System");
        HPersons[pCounter]=getNurse(input);//fill array person with nurse variables form input file
         output.println(HPersons[pCounter].toString()); 
         output.println();
         output.println("----------------------------------------------------------------");
        pCounter++;//increment the person counter
      }
       if(command.matches("Add_Patient")){
           //Command #5
         output.println("Command Add_Patient:\nAdd a new Patient record in the System");
         HPersons[pCounter]=getPatientRecord(input);//fill array person with patient variables form input file
         output.println(HPersons[pCounter].toString()); 
         output.println();
         output.println("----------------------------------------------------------------");
        pCounter++;//increment the person counter
     }
      if(command.matches("Assign_Doctor_Patient")){ 
          //Command #6
      output.println("Command Assign_Doctor_Patient:");
      int docID=input.nextInt();
      int paID=input.nextInt();
      Doctor doc=findDoctor(docID,HPersons);//check if ID valid or not
      Patient pa=findPatient(paID,HPersons);//check if ID valid or not
      if(doc==null){//not valid
          output.println("Doctor "+docID+" NOT FOUND");
      }
      else if (pa==null){//not valid
       output.println("Patient "+paID+" NOT FOUND");  
      }
      else{//valid
       Assign_Doctor_Patient(doc,pa,HPersons);  
        output.println("Successfully Processed by the System:\nFollowing are the details:");    
        output.println("\t\tPatient: "+pa.getName());
        output.println("\t\tAssigned to Doctor: "+doc.getName());
      }
      output.println("----------------------------------------------------------------");
     }
      if(command.matches("Assign_Room_Patient")){ 
          //Command #7
      output.println("Command Assign_Room_Patient:");
      int roomNum=input.nextInt();
      int paID=input.nextInt();
      Room room=findRoom(roomNum,HRooms);//check if room number valid or not
      Patient pa=findPatient(paID,HPersons);//check if ID valid or not
      if(room==null){//not valid
     output.println("Room "+roomNum+" NOT FOUND");
      }else if( pa==null){//not valid
     output.println("Patient "+paID+" NOT FOUND");   
      }
      else{//valid
     Assign_Room_Patient(room,pa,HPersons); 
     output.println("Successfully Processed by the System:\nFollowing are the details:");
     output.println("\tPatient: "+pa.getName());
     output.println("\tAssigned to Room: "+room.toString());
      output.println();
      }
     output.println("----------------------------------------------------------------");
     }
     if(command.matches("Assign_Medicine_Patient")){ 
         //Command #8
      output.println("Command Assign_Medicine_Patient:");
      int paID=input.nextInt();
      int numOfMed=input.nextInt();
      Patient pa=findPatient(paID,HPersons);//check if ID valid or not
      String print="";//collect all statments to print them using "print" variable
     if(pa==null){//not valid
       output.println("Patient "+paID+" NOT FOUND");    
     }else if(numOfMed>pa.getTotalMedicine()){//if the number of medicine in input file bigger than the actual number
         output.println("Information mismatch: Patient "+pa.getId()+"must have "+pa.getTotalMedicine()+" medicine not "+numOfMed);
     }else{//valid
          print+="Successfully Processed by the System:\nFollowing are the details:";
          print+="\n\tPatient: "+pa.getName();
    for(int i=0;i<numOfMed;i++){
         int med=input.nextInt();
         Medicine medName=findMedicine(med,HMedicines);//check if medicine code valid or not
         if(medName==null){//not valid
          output.print("Medicine "+med+" NOT FOUND"); 
          print="";
         }else{
          Assign_Medicine_Patient(medName,i,pa,HPersons); 
          print+="\n\tMedicine Prescribed: "+medName.getName();
         }
     } 
     output.println(print);
     }
     output.println("----------------------------------------------------------------");
     }
      if(command.matches("Print_Bill")){ 
          //Command #9
      output.println();
      output.println("Command: Print_Bill");
      output.println();
      output.println();
      output.println();
      output.println("--------------- Welcome to KAU Hospital System ---------------");
      output.println();
      Date currentDate=new Date();//current date and time
      output.println("--------- Current Date : "+currentDate+"--------");
      output.println();
      output.println("==================================================================");
      Arrays.sort(HPersons);//sort person array by their ID
      for(int p=0;p<HPersons.length;p++){
          if(HPersons[p] instanceof Patient){
         Patient pInfo=(Patient)HPersons[p];  
           output.println("Patient Detail:\n ID: "+pInfo.getId()+" Name: "+pInfo.getName()+"\n\tDoctor : "+pInfo.getDoctor().getName()+"   Doctor Consultation Fees: "+pInfo.getDoctor().getConsultationFees()+" SR");
           output.println("\tMedicines  are:");
        for(int m=0;m<pInfo.getTotalMedicine();m++){
         output.println("\tMedicine name: "+String.format("%-9s\t",pInfo.getMedicine(m).getName() )+"Price: "+pInfo.getMedicine(m).getPrice()+" SR");   
        }  
        output.println("\tRoom: "+pInfo.getRoom().getRoomNo()+" Room Charge: "+pInfo.getRoom().getCharges()+" SR");
        output.println("\t\t==== Total Charges :"+pInfo.calTotalBill()+" SR ====");
        output.println("----------------------------------------------------------------");
          }
      }
}
    if(command.matches("Quit")){
        //Command #10
      output.print("Thank you for using KAU Hospital System, Good Bye!");
      break;
    }
     }
     input.close();//close the file
     output.close();//close the file
    }
    /**----------------------------------------------------------------------------------------------------------------------------*/
    private static Doctor getDoctor(Scanner input){
     /** define varibles for doctor object */
       double fees=input.nextDouble();
       String staffId=input.next();
       String specialization=input.next();
       int id=input.nextInt();
       String name= input.next();
       String nationality=input.next();
       char gender=input.next().charAt(0);
       int phone=input.nextInt();
     Doctor doctor=new Doctor(fees,staffId,specialization,id,name,nationality,gender,phone);//create object from Doctor class        
     return doctor; //return the object 
   }
    /**----------------------------------------------------------------------------------------------------------------------------*/
    private static Nurse getNurse(Scanner input){
       /** define varibles for nurse object */
        int exYear=input.nextInt();
        String staffId=input.next();
        String specialization=input.next();
        int id=input.nextInt();
        String name= input.next();
        String nationality=input.next();
        char gender=input.next().charAt(0);
        int phone=input.nextInt();
      Nurse nurse=new Nurse(exYear,staffId,specialization,id,name,nationality,gender,phone);//create object from Nurse class  
     return nurse;//return the object  
    }
    /**----------------------------------------------------------------------------------------------------------------------------*/  
   private static Room getRoom(Scanner input){
       /** define varibles for room object */
       int roomNo=input.nextInt();
       String floor=input.next();
       String block=input.next();
       double charges=input.nextDouble();
       Room room=new Room(roomNo,floor,block,charges);//create object from Room class  
       return room;//return the object
    }
    /**----------------------------------------------------------------------------------------------------------------------------*/
   private static Medicine getMedicineRecord(Scanner input){
    /** define varibles for medicine object */
      int code=input.nextInt();
     String name=input.next();
     double price=input.nextDouble();
     Medicine medicine=new Medicine(code,name,price);//create object from Medicine class  
     return medicine;//return the object
    }
    /**----------------------------------------------------------------------------------------------------------------------------*/
   private static Patient getPatientRecord(Scanner input){
     /** define varibles for patient object */
      String illness=input.next();
      String bloodGroup=input.next();
      int id=input.nextInt();
      String name=input.next();
      String nationality=input.next();
      char gender=input.next().charAt(0);
      int phone=input.nextInt();
      int total=input.nextInt();
      Patient patient=new Patient(illness,bloodGroup,id,name,nationality,gender,phone,total);//create object from Patient class 
      return patient;//return the object
}
 /**----------------------------------------------------------------------------------------------------------------------------*/ 
   public static Doctor findDoctor(int docID,Person doc[]){
    /** Method that check the ID of the doctor and check if it is an object form Doctor class */
       for(int i=0;i<doc.length;i++){
           if(doc[i] instanceof Doctor && doc[i].getId()==docID)
               return (Doctor)doc[i];//return the doctor of this ID
       }
       return null;
   }
 /**----------------------------------------------------------------------------------------------------------------------------*/  
    public static Patient findPatient(int paID,Person pa[]){
    /** Method that check the ID of the patient and check if it is an object form Patient class */
        for(int i=0;i<pa.length;i++){
           if(pa[i] instanceof Patient && pa[i].getId()==paID)
               return (Patient)pa[i];//return the patient of this ID
       }
       return null;
   }
 /**----------------------------------------------------------------------------------------------------------------------------*/  
   public static Room findRoom(int roomNum,Room room[]){
    /** Method that check the number of the room if it is valid or not */
       for(int i=0;i<room.length;i++){
           if(room[i].getRoomNo()==roomNum)
               return room[i];
       }
       return null;
   } 
 /**----------------------------------------------------------------------------------------------------------------------------*/   
 public static Medicine findMedicine(int numOfMed,Medicine med[]){
   /** Method that check the medicie code if it is valid or not */
     for(int i=0;i<med.length;i++){
           if(med[i].getMedicineCode()==numOfMed)
               return med[i];
       }
       return null;
   } 
/**----------------------------------------------------------------------------------------------------------------------------*/  
   public static void Assign_Doctor_Patient(Doctor doc,Patient pa,Person per[]){
   /** Method that check the patient ID and assign the doctor to this patient */
       for(int i=0;i<per.length;i++){
       if(per[i].getId()==pa.getId()){
         Patient Apa=(Patient)per[i]; //Apa=assigend Patient 
         Apa.setDoctor(doc);
        per[i]=Apa; 
    }
   }    
   }
 /**----------------------------------------------------------------------------------------------------------------------------*/   
  public static void Assign_Room_Patient(Room room,Patient pa,Person per[]){
   /** Method that check the patient ID and assign the room to this patient */
      for(int i=0;i<per.length;i++){
       if(per[i].getId()==pa.getId()){
         Patient Apa=(Patient)per[i]; //Apa=assigned patient
         Apa.setRoom(room);
        per[i]=Apa; 

       }
   }    
   }
 /**----------------------------------------------------------------------------------------------------------------------------*/     
  public static void Assign_Medicine_Patient(Medicine med,int index,Patient pa,Person per[]){
  /** Method that check the patient ID and assign the medicine of this patient */
      for(int i=0;i<per.length;i++){
       if(per[i].getId()==pa.getId()){
         Patient Apa=(Patient)per[i]; //Apa=assigned patient
         Apa.setMedicine(med, index);
        per[i]=Apa; 
}
   }    
  }
}


