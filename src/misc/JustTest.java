package misc;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author huangyongkang, created 2020-04-10
 */


public class JustTest {

  private static Random random = new Random();

  public static void main(String[] args) throws IOException, ClassNotFoundException {
//    List<Node> nodes = new ArrayList<>();
//
//    for (int i = 0; i < 10; i++) {
//      nodes.add(newNode());
//    }
//
//    nodes.sort(Comparator.comparing(Node::getSuccess));
//
//    nodes.forEach(Node::print);

    Node node = newNode();
    node.print();
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/XM/test-node.txt"));
    oos.writeObject(node);
    oos.close();

    File file = new File("/Users/XM/test-node.txt");
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
    Node newNode = (Node)ois.readObject();
    newNode.print();


  }

  private static Node newNode() {
    Node node = new Node();
    node.setSuccess(random.nextBoolean());
    node.setCanToHistory(random.nextBoolean());
    return node;
  }

  static class Node extends PrintDouble{

    public Node() {

    }

    private Boolean success;

    private transient Boolean canToHistory;

    public void print() {
      System.out.println("success:" + success.toString() + " canToHistory:" + canToHistory);
    }

    public Boolean getSuccess() {
      return success;
    }

    public void setSuccess(Boolean success) {
      this.success = success;
    }

    public Boolean getCanToHistory() {
      return canToHistory;
    }

    public void setCanToHistory(Boolean canToHistory) {
      this.canToHistory = canToHistory;
    }

  }

}
