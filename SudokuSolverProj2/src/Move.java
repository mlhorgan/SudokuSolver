
public class Move {

	int row;
	int column;
	int value;
	
	Move(int x, int y, int v ){
		row = x;
		column = y;
		value = v;
	}
	
	public void setRow(int x){
		row=x;
	}
	public int getRow(){
	return row;
	}
	
	public void setColumn(int y){
		column=y;
	}
	public int getColumn(){
	return column;
	}
	
	public void setValue(int v){
		row=v;
	}
	public int getValue(){
	return value;
	}
	
}
