package misc;

/**
 * @author huangyongkang, created 2020-04-07
 */


public class TryCatchFinally {

  public static void main(String[] args) {
    System.out.println(getDoubleValue(4));
  }

  private static int getDoubleValue(int value) {
    try {
      // 执行了 exit 将不会再执行 finally 语句块
      System.exit(0);
      return 2 * value;
    } finally {
      System.out.println("getDoubleValue println");
      // finally 中的 return 值会覆盖 try 中的 return
      return 1;
    }
  }

}
