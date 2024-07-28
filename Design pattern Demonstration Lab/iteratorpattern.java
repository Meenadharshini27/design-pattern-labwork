import java.util.*;
class Node {
    int value;
    Node left;
    Node right;
  
    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  interface TreeIterator {
    boolean hasNext();
    Node next();
  }
  
  class InOrderIterator implements TreeIterator {
    private Stack<Node> stack;
    private Node current;
  
    public InOrderIterator(Node root) {
      stack = new Stack<>();
      current = root;
    }
  
    public boolean hasNext() {
      return current != null || !stack.isEmpty();
    }
  
    public Node next() {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      Node temp = current;
      current = current.right;
      return temp;
    }
  }
  
  class PreOrderIterator implements TreeIterator {
    private Stack<Node> stack;
  
    public PreOrderIterator(Node root) {
      stack = new Stack<>();
      stack.push(root);
    }
  
    public boolean hasNext() {
      return !stack.isEmpty();
    }
  
    public Node next() {
      Node current = stack.pop();
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
      return current;
    }
  }
  
  class PostOrderIterator implements TreeIterator {
    private Stack<Node> stack;
    private Node current;
  
    public PostOrderIterator(Node root) {
      stack = new Stack<>();
      current = root;
    }
  
    public boolean hasNext() {
      return current != null || !stack.isEmpty();
    }
  
    public Node next() {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      Node temp = current;
      if (!stack.isEmpty() && stack.peek().left == temp) {
        current = stack.peek().right;
        stack.pop();
        stack.push(temp);
      } else {
        current = null;
      }
      return temp;
    }
  }
  
  public class iteratorpattern {
    public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
  
      TreeIterator inOrderIterator = new InOrderIterator(root);
      while (inOrderIterator.hasNext()) {
        System.out.print(inOrderIterator.next().value + " ");
      }
      System.out.println();
  
      TreeIterator preOrderIterator = new PreOrderIterator(root);
      while (preOrderIterator.hasNext()) {
        System.out.print(preOrderIterator.next().value + " ");
      }
      System.out.println();
  
      TreeIterator postOrderIterator = new PostOrderIterator(root);
      while (postOrderIterator.hasNext()) {
        System.out.print(postOrderIterator.next().value + " ");
      }
    }
  }