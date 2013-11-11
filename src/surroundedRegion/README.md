Surrounded Regions
===============
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

> X X X X
> X O O X
> X X O X
> X O X X

After running, the board should be

> X X X X
> X X X X
> X X X X
> X O X X

Solution
============
Instead of trying to find what regions are surrounded, find the ones that are NOT surrounded instead