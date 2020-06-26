package mavixk.ds.exam.oop;

class InvalidUserException extends RuntimeException {
  private String message;

  public InvalidUserException(String message){
    this.message = message;
  }

  @Override
  public String toString() {
    return "InvalidUserNameException" + ": " + this.message;
  }
}

public class TestException {

  public static void main(String[] args) {
    testException();
    testCustomException();
  }

  public static void testCustomException() {
    try {
      String name = "mavixk";
      if (name.length() < 7) {
        throw new InvalidUserException("username length < 8");
      }
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }

  public static void testException() {
    try {
      int a = 40 / 0;
      //return;//invalid since return in catch makes outer block unreachable
    } catch (RuntimeException e) {
      e.printStackTrace();
      return; //valid
    } finally {
      System.out.println("in final block");
      //return; //makes outer block unreachable
    }
    System.out.println("outside try-catch-block");
  }
}
