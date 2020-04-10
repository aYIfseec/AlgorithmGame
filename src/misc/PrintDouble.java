package misc;

import java.math.BigDecimal;

/**
 * @author huangyongkang, created 2020-04-09
 */


public class PrintDouble {

  public static void main(String[] args) {
    double ten = -0.00001;
    double three = 300000000;
    double result = ten / three;

    // -3.3333333333333334E-14
    System.out.println("result:" + result);
    // -0.00
    System.out.println("result:" + String.format("%.2f", result));


    BigDecimal tenBigDecimal = BigDecimal.valueOf(-0.00001);
    BigDecimal threeBigDecimal = BigDecimal.valueOf(300000000);
    BigDecimal resultBigDecimal = tenBigDecimal
        .divide(threeBigDecimal, 10, BigDecimal.ROUND_HALF_UP);

    System.out.println("resultBigDecimal:" + resultBigDecimal.toPlainString());

  }

}
