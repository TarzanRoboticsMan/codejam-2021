package qualifications.reversort;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int tests = 1;// in.nextInt();
    for (int i = 1; i <= tests; i++) {
      List<Integer> l = new ArrayList<Integer>();

      // int length = in.nextInt();
      // for (int el = 1; el <= length; el++) {
      // l.add(in.nextInt());
      // }
      l.add(4);
      l.add(2);
      l.add(1);
      l.add(3);

      System.out.println("Case #" + i + ": " + Reversort(l));
    }
    in.close();
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