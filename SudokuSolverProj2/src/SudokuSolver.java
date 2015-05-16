import java.util.Stack;




public class SudokuSolver  {

	SudokuSolver(){

	}

	Stack<Move> moves = new Stack<Move>();



	//best one 
	public String solve1(Board ba){

		int x = 0;
		int y = 0;

		// places first move


		if (ba.getFixed(x, y) == false){
			Move m = new Move(x,y,1);
			try {
				ba.move(m);
			} catch (BadMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			y++;
		}
		else{
			while (ba.getFixed(x, y)==true){
				y++;
				Move m = new Move(x,y,1);
				if (ba.getFixed(x, y)==false ){
					try {
						ba.move(m);
					} catch (BadMoveException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}



		boolean lastCellFilled = false;
		boolean noSolution = false;
		while(lastCellFilled == false && noSolution==false){  



			if (!ba.isBad1()){

				if (y == 8){
					x++;
					y=0;
				}
				Move n = new Move(x,y,1);
				moves.push(n);
				try {
					ba.move(n);
				} catch (BadMoveException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				y++;

				if (ba.getFixed(x, y)== true){
					for (int i = 1; i <= 9; i++){
						if(ba.getCell(x, y-1)== i){
							//TODO print out sudoku
							toString(ba);
							lastCellFilled = true;
						}
					}
				}else{
					for (int i = 1; i <= 9; i++){
						if(ba.getCell(x, y)== i){
							//TODO print out sudoku
							toString(ba);
							lastCellFilled = true;
						}
					}
				}


				if (ba.isBad1()){
					Move p = moves.pop();
					for ( int i = 1; i <= 10; i++){
						p.setValue(i);
						try {
							ba.move(p);
						} catch (BadMoveException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (x==0 && y==0 && i==10){
							System.out.println("No Solution");
							noSolution = true;
						}

						if(i == 10){
							Move t = moves.pop();
							int v = t.getValue()+1;
							t.setValue(v);
							try {
								ba.move(t);
							} catch (BadMoveException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}

						if(!ba.isBad1()){
							moves.push(p);
							try {
								ba.move(p);
							} catch (BadMoveException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					}
				}



			}


		}
		return "solve failed to work";

	}


	public String toString(Board b) {

		String pnt = "";
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				pnt += b.getCell(x, y) ;
				if(y<8){pnt+=" ";}
			}
			if(x<8){pnt += "\n";} // new line
		}

		return pnt;
	}


	


	public String solve(Board b){
//		System.out.println("solve()");
		Board orig = b;
		int x = 0;
		int y =0;
		while (x < 9){
			while (y < 9){
				if (!b.getFixed(x, y)){
					int num =1;
					while (x>=0 && y>=0){

						//int ret =	tryMove(x,y,num,b);
//				System.out.println(x + " " + y+ " "+ num+" "+ " " +b.isBad1());
						//if (ret == -1){
							//bad move
					//	}
						int j = num;
						for (; j<10 ; j++){
							
							Move m = new Move(x,y,j);
							try {
								b.move(m);
//								System.out.println(toString(b));
							} catch (BadMoveException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (!b.isBad1()){
//							System.out.println("board is not bad");
								moves.push(m);
								break;
							}else{
								Move reset = new Move(x,y,0);
								try {
									b.move(reset);
								} catch (BadMoveException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						if (j == 10){
							Move m = moves.pop();
//							System.out.println("pop():"+m.getValue());
							x = m.getRow();
							y = m.getColumn();
							num= m.getValue()+1;
						}
						else{break;}

					}
					if( x == 9 && y == 0){String noSolution = "This puzzle has no solution."  ;  return noSolution;  }
				}
				y++;
			}
			x++;
			y=0;
		}
	
		if (x ==9 ){return toString(b);}
		
		System.out.println("x="+x + " "+ "y= "+y);
		return "solve failed to work";
	}



	public int tryMove(int x,int y, int i, Board b){  
		System.out.println("try move("+x+" "+y+" "+i);
		if (b.getFixed(x, y)==true ){ return -1; }
		int j = i;
		for (; j<10 ; j++){
			
			Move m = new Move(x,y,j);
			try {
				b.move(m);
			} catch (BadMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!b.isBad1()){
				System.out.println("board is not bad");
				moves.push(m);
				break;
			}
		}
		if (j == 10) { return 0; } 
		return 1;
	}

}// end


