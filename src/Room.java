public class Room {
/** Define the Room class */
    private int roomNo;;//the number of the room
    private String floor;//the floor of the room
    private String block;//the block of the room
    private double charges;//the charges of the room
    
    public Room(int roomNo,String floor,String block,double charges){
   /** Construct a Room object */
        this.roomNo=roomNo;
        this.floor=floor;
        this.block=block;
        this.charges=charges;
    }

    public int getRoomNo() {
    /** Return the number of this room */
          return roomNo;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setRoomNo(int roomNo) {
     /** set a new number for this room */
        this.roomNo = roomNo;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getFloor() {    
    /** Return the floor of this room */
        return floor;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setFloor(String floor) {
     /** set a new floor for this room */
        this.floor = floor;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public String getBlock() {
      /** Return the block of this room */
        return block;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setBlock(String block) {
      /** set a new block for this room */
        this.block = block;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public double getCharges() {
     /** Return the charges of this room */
        return charges;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/
    public void setCharges(double charges) {
     /** set a new charges for this room */
        this.charges = charges;
    }
/**----------------------------------------------------------------------------------------------------------------------------*/   
    @Override
    public String toString() {
    /** Return the information of this room */
        return "\tRoom No: " + roomNo + "\n\tLocated in floor: " + floor + "\n\tBlock :" + block + "\n\tCharges: " + charges;
    }
  }
