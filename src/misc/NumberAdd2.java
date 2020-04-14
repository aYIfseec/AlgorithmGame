package misc;

import java.util.Objects;
import java.util.Stack;

/**
 * @author huangyongkang, created 2020-04-14
 */


public class NumberAdd2 {

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

    NumberAdd2 numberAdd = new NumberAdd2();

    ListNode listNode1 = numberAdd.transToListNode("100000");
    ListNode listNode2 = numberAdd.transToListNode("8");
    numberAdd.addTwoNumbers(listNode1, listNode2);
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Stack<Integer> numStack1 = buildStack(l1);
    Stack<Integer> numStack2 = buildStack(l2);

    Stack<Integer> result = addTwoNumbers(numStack1, numStack2);
    return buildListNode(result);
  }

  private ListNode buildListNode(Stack<Integer> numStack) {
    ListNode listNode = new ListNode(numStack.pop());
    ListNode p = listNode;

    while(!numStack.empty()) {
      ListNode node = new ListNode(numStack.pop());
      p.next = node;
      p = node;
    }
    return listNode;
  }

  private Stack<Integer> addTwoNumbers(Stack<Integer> numStack1, Stack<Integer> numStack2) {
    Stack<Integer> result = new Stack<>();

    int maxSize = Math.max(numStack1.size(), numStack2.size());
    int advanceNum = 0;

    for (int i = 0; i < maxSize; i++) {
      int sum = advanceNum;

      if (!numStack1.empty()) {
        sum += numStack1.pop();
      }

      if (!numStack2.empty()) {
        sum += numStack2.pop();
      }

      if (sum > 9) {
        advanceNum = sum / 10;
      } else {
        advanceNum = 0;
      }

      result.push(sum % 10);
    }

    if (advanceNum > 0) {
      result.push(advanceNum);
    }

    return result;
  }

  private Stack<Integer> buildStack(ListNode listNode) {
    Stack<Integer> numStack = new Stack();
    do {
      numStack.push(listNode.val);
      listNode = listNode.next;
    } while (Objects.nonNull(listNode));
    return numStack;
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
   * 内部节点类
   */
  static class ListNode {
    Integer val;
    ListNode next;

    ListNode(Integer x) {
      val = x;
    }
  }

}
