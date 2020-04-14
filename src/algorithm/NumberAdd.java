package algorithm;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author huangyongkang, created 2020-04-14
 */


public class NumberAdd {

  /**
   * 给你两个 非空 链表来代表两个非负整数。
   * 数字最高位位于链表开始位置。
   * 它们的每个节点只存储一位数字。
   * 将这两数相加会返回一个新的链表。
   * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
   *
   * 进阶：
   * 如果输入链表不能修改该如何处理？
   * 换句话说，你不能对列表中的节点进行翻转。
   *
   *
   * 解法一：
   * 将ListNode转换为BigDecimal，进行数值计算，然后再将结果转回ListNode
   * 缺点：BigDecimal有位数限制（极限位数未测出来），速度会慢一些
   *
   * 解法二：
   * 低位开始两数相加再加进位，用一个变量存储进位
   * 至于如何解决从低位开始，可以反转链表，可以用栈
   *
   */

  public static void main(String[] args) {

    NumberAdd numberAdd = new NumberAdd();

    ListNode listNode1 = numberAdd.transToListNode("1");
    ListNode listNode2 = numberAdd.transToListNode("999999999999999999999999999999999999999"
        + "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
    new NumberAdd().addTwoNumbers(listNode1, listNode2);
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    String strNum1 = transToNumStr(l1);
    BigDecimal num1 = new BigDecimal(strNum1);

    String strNum2 = transToNumStr(l2);
    BigDecimal num2 = new BigDecimal(strNum2);

    BigDecimal res = num1.add(num2);

    // TODO 删除
    System.out.println(res.toPlainString());
    return transToListNode(res.toPlainString());
  }

  /**
   * 数字字符串转换为链表
   *
   * @param numStr 数字字符串
   * @return 数字链表
   */
  private ListNode transToListNode(String numStr) {
    char[] numCharArr = numStr.toCharArray();
    ListNode root = new ListNode(numCharArr[0] - '0');
    ListNode p = root;

    for (int i = 1; i < numCharArr.length; i++) {
      ListNode node = new ListNode(numCharArr[i] - '0');
      p.next = node;
      p = node;
    }

    // 会被初始化，但还是做一下
    p.next = null;
    return root;
  }

  /**
   * 数字链表转换为数字字符串
   *
   * @param listNode  数字链表
   * @return 数字字符串
   */
  private String transToNumStr(ListNode listNode) {
    StringBuilder sbNum1 = new StringBuilder();
    ListNode p = listNode;

    do {
      sbNum1.append(p.val);
      p = p.next;
    } while (Objects.nonNull(p));
    return sbNum1.toString();
  }

  /**
   * 内部节点类
   */
  static class ListNode {
    Integer val;
    ListNode next;

    ListNode(Integer x) {
      val = x;
    }

    // 未使用
    private static ListNode buildListNode(int...nums) {
      paramCheck(nums);

      ListNode root = new ListNode(nums[0]);
      ListNode p = root;
      for (int i = 1; i < nums.length; i++) {
        ListNode node = new ListNode(nums[i]);
        p.next = node;
        p = node;
      }
      p.next = null;
      return root;
    }

    // 未使用
    private static void paramCheck(int[] nums) {
      if (nums.length == 0) {
        throw new IllegalArgumentException("nums 不能为空");
      }

      for (int num : nums) {
        if (num > 10 || num < 0) {
          throw new IllegalArgumentException("num 参数不符合 [0-9]");
        }
      }
    }

  }

}
