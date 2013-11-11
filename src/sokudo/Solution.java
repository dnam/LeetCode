package sokudo;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] cin = new char[input.length][input.length];
		
		for (int i = 0; i < cin.length; i++) {
			for (int j = 0; j < cin.length; j++) {
				cin[i][j] = input[i].charAt(j);
			}
			
			System.out.println(Arrays.toString(cin[i]));
		}
		
		System.out.println("Solver");
		sol.solveSudoku(cin);
		
		for (int i = 0; i < cin.length; i++)
			System.out.println(Arrays.toString(cin[i]));
		
		for (int i = 0; i < cin.length; i++) {
			for (int j = 0; j < cin.length; j++) {
				Set<Character> s = sol.getChoices(cin, i, j);
				if (s != null)
				System.out.println("[ " + i + ", " + j + "] : " + s);
			}
		}
	}
	
	Set<Character>[][] choices; // set of choices at each position
    public void solveSudoku(char[][] board) {
    	// build the possible choices
    	choices = new HashSet[board.length][board.length];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
    			choices[i][j] = getChoices(board, i, j);
    		}
    	}
    	
    	// the problem says that there is a unique position 
    	solveSudoku(board, 0, 0);
    }
    
    /**
     * Solve the sudoku problem.
     * @param board sudoku board
     * @param x row number
     * @param y column number
     * @return true if there is a solution for the configuration
     */
    private boolean solveSudoku(char[][] board, int x, int y) {
    	// assuming 0 < i <= x, 0 <= j < y: has been assigned
    	if (choices[x][y] == null) {
    		if (y + 1 < board.length)
    			return solveSudoku(board, x, y+1);
    		else if (x + 1 < board.length)
    			return solveSudoku(board, x + 1, 0);
    		else
    			return true; // finished
    	}
    	
    	// try each choice
    	Iterator<Character> it = choices[x][y].iterator();
    	while(it.hasNext()) {
    		board[x][y] = it.next();
    		
    		if (!isSuitable(board, x, y))
    			continue;
    		
    		// suitable character
    		int nextX, nextY;
    		if (y + 1 < board.length) {
    			nextX = x;
    			nextY = y + 1;
    		} else if (x + 1 < board.length) {
    			nextX = x+1;
    			nextY = 0;
    		} else // x == length - 1 && y == length - 1
    			return true; // finished 
    		
    		// move on to the next position
    		if (solveSudoku(board, nextX, nextY)) 
    			return true;
    		// else continue trying
    	}
    	
    	board[x][y] = '.';  // reset the value
    	return false;
    }
    
    /**
     * Checks if the value at the given position is valid
     * @param board sudoku board
     * @param x	row number
     * @param y column number
     * @return true if valid, false otherwise
     */
    private boolean isSuitable(char[][] board, int x, int y) {
    	char c = board[x][y];
    	
    	for (int i = 0; i < board.length; i++) {
    		if (i != y && board[x][i] == c)
    			return false;
    		if (i != x && board[i][y] == c)
    			return false;
    	}
    	
    	int arRow = x/3;
    	int arCol = y/3;
    	for (int i = arRow*3; i < (arRow+1)*3; i++) {
    		for (int j = arCol*3; j < (arCol + 1)*3; j++) {
    			if (i != x && j != y && board[i][j] == c)
    				return false;
    		}
    	}
    	
    	return true;
    }
    
    /**
     * Calculates the choices in advance
     * @param board the input board
     * @param x	row number
     * @param y colum number
     * @return set of input choices for the position
     */
	private Set<Character> getChoices(char[][] board, int x, int y) {
		if (board[x][y] != '.')
			return null;
		
		HashSet<Character> set = new HashSet<Character>();
		for (char c = '1'; c <= '9'; c++)
			set.add(c);
		
		// remove values in corresponding column and row
		for (int i = 0; i < board.length; i++) {
			set.remove(board[x][i]);
			set.remove(board[i][y]);
		}
		
		// remove values in the same area
		int arRow = x/3;
		int arCol = y/3;
				
		for (int row = arRow*3; row < (arRow+1)*3; row++) {
			for (int col = arCol*3; col < (arCol + 1)*3; col++) {
				set.remove(board[row][col]);
			}
		}
		
		if (set.size() == 0)
			return null;
		
		return set;
	}
}