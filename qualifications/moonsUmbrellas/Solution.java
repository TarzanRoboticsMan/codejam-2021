package qualifications.moonsUmbrellas;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int tests = in.nextInt();
    for (int T = 1; T <= tests; T++) {
      int x = 2;// in.nextInt();
      int y = 3;// in.nextInt();
      String mural = "CJ?CC?";// in.next();
      int fines = 0;

      char[] mChars = mural.toCharArray();
      char prev = mChars[0];
      char curr;
      for (int i = 1; i < mChars.length; i++) {
        curr = mChars[i];
        if (prev == 'C' && curr == 'J')
          fines += x;
        else if (prev == 'J' && curr == 'C')
          fines += y;
        if (curr != '?')
          prev = curr;
      }

      System.out.println("Case #" + T + ": " + fines);

    }

    in.close();
  }
}
