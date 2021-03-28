package qualifications.reversortEngineering;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int tests = 1;// in.nextInt();
    for (int i = 1; i <= tests; i++) {

      int size = 4;// in.nextInt();
      int cost = 6; // in.nextInt();

      if (cost < size - 1 || cost > (size + 2) * (size - 1) / 2) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
        List<Integer> l = new ArrayList<Integer>();
        for (int el = 1; el <= size; el++) {
          l.add(el);
        }
        System.out.println("Case #" + i + ": " + ReversortEng(l, size, cost));
      }
    }
    in.close();
  }

  public static String ReversortEng(List<Integer> l, int s, int c) {
    c -= s - 1; // each step does at least 1 work
    Stack<Integer> work = new Stack<Integer>();
    for (int maxWork = s; maxWork >= 2; maxWork--) {
      System.out.println("maxWork: " + maxWork);
      if (maxWork - 1 <= c) {// -1 bc we already accounted for the 1
        c -= maxWork - 1;
        work.push(maxWork);
      } else
        work.push(1);
    }

    for (int elms = 2; elms <= s; elms++) {
      System.out.println(work + " " + elms);
      if (elms == work.peek()) {
        l = reverse(l, s - elms, s - 1);
      }
      work.pop();
    }
    System.out.println(l);
    String ans = "";
    for (Integer e : l)
      ans = ans + e + " ";
    return ans.stripTrailing();
  }

  public static int Reversort(List<Integer> l) {
    int work = 0;
    for (int i = 0; i < l.size() - 1; i++) {
      Integer min = l.get(i);
      for (int j = i + 1; j < l.size(); j++) {
        min = Math.min(min, l.get(j));
      }
      int j = l.indexOf(min);
      l = reverse(l, i, j);
      work += 1 + j - i;
      System.out.println(work);
    }
    return work;
  }

  public static List<Integer> reverse(List<Integer> l, int i, int j) {
    List<Integer> mid = l.subList(i, j + 1);
    Collections.reverse(mid);
    return l;
  }
}