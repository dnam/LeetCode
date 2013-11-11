package surroundedRegion;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		char[][] a = {{'X', 'X', 'X', 'X'},
				 {'X', 'O', 'O', 'X'},
				 {'X', 'X', 'O', 'X'},
				 {'X', 'O', 'X', 'X'}};
		
		(new Solution()).solve(a);
		
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
	
    public void solve(char[][] board) {
    	// instead of capture all surrounded regions,
    	// we detect all 'O's that are not surrounded
    	Queue<int[]> free = new LinkedList<int[]>();
    	
    	// find all o's at the edges
    	for (int i = 0; i < board.length; i++) {
    		if (board[0][i] == 'O') 
    			free.add(makePair(0, i));
    		if (board[i][0] == 'O')
    			free.add(makePair(i, 0));
    		if (board[board.length - 1][i] == 'O')
    			free.add(makePair(board.length - 1, i));
    		if (board[i][board.length - 1] == 'O')
    			free.add(makePair(i, board.length - 1));
    	}
    	
    	while (!free.isEmpty()) {
    		int[] loc = free.remove();
    		int x = loc[0];
    		int y = loc[1];
    		board[x][y] = 'F'; // free 'O'
    		
    		// check four directions
    		if (x + 1 < board.length && board[x + 1][y] == 'O')
    			free.add(makePair(x+1, y));
    		if (y + 1 < board.length && board[x][y + 1] == 'O')
    			free.add(makePair(x, y + 1));
    		if (x > 0 && board[x-1][y] == 'O')
    			free.add(makePair(x-1, y));
    		if (y > 0 && board[x][y-1] == 'O')
    			free.add(makePair(x, y-1));
    	}
    	
    	// change all surrounded o's into x's
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++)
    			if (board[i][j] == 'O')
    				board[i][j] = 'X';
    	}
    	
    	// restore all free o's back
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++)
    			if (board[i][j] == 'F')
    				board[i][j] = 'O';
    	}
    }
    
    private int[] makePair(int x, int y) {
    	int[] pair = new int[2];
    	pair[0] = x;
    	pair[1] = y;
    	
    	return pair;
    }
}