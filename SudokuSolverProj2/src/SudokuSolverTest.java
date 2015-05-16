
// draft driver for Project #2, CMPSCI 187 Fall 2012
// David Mix Barrington, 1 October 2012
// solutions obtained with help of www.sudoku-solutions.com
// edited (to correct errors pointed out by a student) 3 October 2012
// another error fixed early on 5 October 2012

public class SudokuSolverTest {
   public static void main (String [ ] args) {
      SudokuSolver ss = new SudokuSolver( );
      String [ ] array1, array2, array3;
      // Board board1, board2, board3;
      // String output1, output2, output3;
      boolean correct1, correct2, correct3;

      // puzzle of all blanks, ss should find first solution
      // this may not actually be the first one, if so I will fix it
      array1 = new String[9];
      for (int i = 0; i < 9; i++)
          array1[i] = "0 0 0 0 0 0 0 0 0";
      Board board1 = new Board(array1);
      String output1 = ss.solve(board1);
      System.out.println("Output of first solution =:\n" + output1);
      correct1 = output1.equals(
         "1 2 3 4 5 6 7 8 9\n" +
         "4 5 6 7 8 9 1 2 3\n" +
         "7 8 9 1 2 3 4 5 6\n" +
         "2 1 4 3 6 5 8 9 7\n" +
         "3 6 5 8 9 7 2 1 4\n" +
         "8 9 7 2 1 4 3 6 5\n" +
         "5 3 1 6 4 2 9 7 8\n" +
         "6 4 2 9 7 8 5 3 1\n" +
         "9 7 8 5 3 1 6 4 2");
      if (correct1) System.out.println ("Test 1 PASS");
      else System.out.println ("Test 1 FAIL");

      // NYT difficult puzzle of 30 Sept 2012
      array2 = new String[9];
         array2[0] = "8 0 0 0 0 0 0 0 5";
         array2[1] = "7 0 0 0 0 6 0 1 0";
         array2[2] = "0 6 0 5 3 2 0 0 0";
         array2[3] = "0 5 0 0 0 0 0 0 9";
         array2[4] = "0 0 2 0 7 9 0 0 0";
         array2[5] = "0 0 4 0 0 0 7 0 0";
         array2[6] = "0 0 0 8 0 0 0 0 0";
         array2[7] = "0 0 0 0 0 0 0 6 4";
         array2[8] = "4 9 0 3 1 0 0 0 0";
      Board board2 = new Board(array2);
      String output2 = ss.solve(board2);
      System.out.println("Output of second solution =:\n" + output2);
      correct2 = output2.equals(
         "8 2 3 7 4 1 6 9 5\n" +
         "7 4 5 9 8 6 3 1 2\n" +
         "1 6 9 5 3 2 8 4 7\n" +
         "6 5 7 1 2 8 4 3 9\n" +
         "3 1 2 4 7 9 5 8 6\n" +
         "9 8 4 6 5 3 7 2 1\n" +
         "2 7 1 8 6 4 9 5 3\n" +
         "5 3 8 2 9 7 1 6 4\n" +
         "4 9 6 3 1 5 2 7 8");
      if (correct2) System.out.println ("Test 2 PASS");
      else System.out.println ("Test 2 FAIL");

      // NYT difficult puzzle of 30 Sept 2012 with one wrong number added
      array3 = new String[9];
         array3[0] = "8 0 0 0 0 0 0 0 5";
         array3[1] = "7 0 0 0 0 6 0 1 0";
         array3[2] = "0 6 0 5 3 2 0 0 0";
         array3[3] = "0 5 0 0 0 0 0 0 9";
         array3[4] = "1 0 2 0 7 9 0 0 0";
         array3[5] = "0 0 4 0 0 0 7 0 0";
         array3[6] = "0 0 0 8 0 0 0 0 0";
         array3[7] = "0 0 0 0 0 0 0 6 4";
         array3[8] = "4 9 0 3 1 0 0 0 0";
      Board board3 = new Board(array3);
      String output3 = ss.solve(board3);
      System.out.println("Output of second solution =:\n" + output3);
      correct3 = output3.equals("This puzzle has no solution.");
      if (correct3) System.out.println ("Test 3 PASS");
      else System.out.println ("Test 3 FAIL");}}
    

      