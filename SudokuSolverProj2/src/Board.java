import java.util.*;

public class Board  {

	int [][] cells;
	boolean [][] fixed;

	Board(String[] s){
		cells= new int [9][9];
		fixed = new boolean [9][9];
		cellFiller(s);
		//System.out.println("print construct");
	}

	public void cellFiller(String []s){
 System.out.println(s);
		String t = "";
		for (int i = 0; i < 9; i++){
			t = t + s[i]+" ";
		}
	//	System.out.println(t);
		Scanner sca = new Scanner(t);
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				cells[i][j] = sca.nextInt();
				if (cells[i][j] != 0){
					fixed[i][j]=true;
				}
			}
		}
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++){
	//	System.out.println("i+" + i +  " "+ "j=" + j+ " " +fixed[i][j]);
			}
	
	}


	public int getCell(int x, int y){
		return cells[x][y];
	}
	public void setCell(int x, int y, int n){
		cells[x][y] = n;
	}
	public Boolean getFixed(int x, int y){
		return fixed[x][y];
	}
	public void setFixed(int x, int y, boolean n){
		fixed[x][y] = n;
	}





	public void move(Move m) throws BadMoveException{
		//TODO add check to see if it is a good move and throw BadMoveException
		if (fixed[m.getRow()][m.getColumn()] == true){
			throw new BadMoveException("Bad move was made");
		}


		cells[m.getRow()][m.getColumn()]=m.getValue();

	}



	public boolean isBad1(){
		for(int j =0; j < 9;j++){
			int [] temp = new int [10];
			for (int i = 0; i < 9; i++){
				temp[cells[i][j]]++;
				//System.out.println("i="+i+ "+ "+"j="+j+" "+cells[i][j] + " " +temp[cells[i][j]]);
				if (cells[i][j]!= 0 && temp[cells[i][j]]>1){return true;}
			}
		}
		int [] temp2 = new int [10];
		for(int j =0; j < 9;j++){
			for (int i = 0; i < 9; i++){
				temp2[cells[j][i]]++;
				//  System.out.println("i="+i+ "+ "+"j="+j+" "+cells[j][i] + " " +temp2[cells[j][i]]);
				if (cells[j][i]!= 0 &&temp2[cells[j][i]]>1){return true;}
			}temp2 = new int [10];
		}




		//TODO check boxes
/*
		for ( int j = 0; j < 9; j++){
			int xOffSet = 0;
			int yOffSet = 0;
			int [] testB = new int [10];
			for (int i = yOffSet; i < 3; i++){
				for (int n = xOffSet; n < 3; n++){
					int valueB = cells[i][n];
					testB [valueB]++;
				}
			}
			xOffSet+=3;
			if (xOffSet == 9){
				xOffSet = 0;
				yOffSet += 3;
			}
			for(int i = 1; i > testB.length; i++){
				if (testB[i]>1)return true;
			}

		}
*/
		for (int i = 0; i < 3; i++){
			for (int n = 0; n < 3; n++){
			int []	temp3 = new int [10];
				for (int j = i*3; j < i*3+3; j++){
					for (int c = n*3; c <n* 3+3; c++){
						temp3[cells[j][c]]++;
						
						if (cells[j][c]!= 0 &&temp3[cells[j][c]]>1){return true;}
					}
				}
			}
		}
		return false;
	}





}// end

