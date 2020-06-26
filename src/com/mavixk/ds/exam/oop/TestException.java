package mavixk.ds.exam.oop;

public class TestException {
  public static void main(String[] args){
    testException();
  }

  public static void testException(){
    try{
      int a = 40/0;
      //return;//invalid since return in catch makes outer block unreachable
    }catch(RuntimeException e){
      e.printStackTrace();
      return; //valid
    }finally{
      System.out.println("in final block");
      //return; //makes outer block unreachable
    }
    System.out.println("outside try-catch-block");
  }
}
