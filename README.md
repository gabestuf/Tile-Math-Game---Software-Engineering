# Tile_Math_Game__Software_Engineering
The independent project portion of my Software Engineering class.

## How to play!!
There is a 3x3 grid of numbers. The goal of the game is to eliminate all the tiles except the middle one. By selecting each tile, a number of arrows may appear that allows you to move one tile into another one by performing some math operation. Try to figure out how it works!

<details> 
  <summary>If you're pressed for time, here's what each arrow does: </summary>
 - Moving right adds the numbers
 - Moving left subtracts the selected tile from the left tile, only works if result is positive
 - Moving down divides bottom tile by selected tile, only works if result is whole number
 - Moving up multiplies the two numbers
</details>

<details> 
  <summary>And if you're really lazy, here's a solution: </summary>
  Move bottom left -> bottom center
  Move bottom right -> bottom center
  Move top right -> top center 
  Move top left -> top center
  Move everything into the center, but do the middle left side last
  
</details>


<details> 
  <summaryFor an extra challenge, try to get the middle tile to equal 0: </summary>
  Move the 7 into the 2, then the 8 into the 1 that was just created.  
  Move the 6 right and the leftmost 1 right
  Move the bottom 9 up and the 1 down
  Move the bottom right up and then into the middle!
  
</details>
Good luck!
