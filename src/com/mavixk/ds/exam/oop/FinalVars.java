package mavixk.ds.exam.oop;

public class FinalVars {

  private static final String version;

  static {
    version = "2.0"; //init static final in static block
  }

  private final int minor;

  {
    //minor = 7; //init member final in IIB valid
  }

  public FinalVars(){
    minor = 7; //valid
    initVars();
  }

  public void initVars(){
    //minor = 7; //invalid
  }

  public static void main(String[] args){
    FinalVars finalVars = new FinalVars();
    //finalVars.minor = 9; // leads to compilation error
    final int val;
    val = 23;//valid
    //val = 34;//invalid
    System.out.println(finalVars.minor);
    System.out.println(version);
  }

}
