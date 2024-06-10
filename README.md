Mars Rover Project
This project simulates the movement of multiple Mars Rovers on a grid-based map. Each rover can receive a series of instructions to move forward or rotate left/right. The rovers are deployed on a map of Mars, and their movements are synchronized to avoid collisions.

Features
- Initialize a map of Mars with specified dimensions.
- Deploy multiple rovers on the map at specific coordinates facing a particular direction.
- Provide movement instructions for each rover.
- Detect and handle collisions between rovers.
- Stop all rovers upon detecting a collision.

Example:
1. Generate a Map: Enter the X and Y dimensions for the map.
      Generate a Map Using Inputted XY Coordinates
      10 10

2. Deploy Rovers: Specify the number of rovers and initialize each with its starting coordinates and facing direction (N, E, S, W).
      How many Rover to deploy
      2
      Initialize Rover 1 Using Inputted XY Coordinates
      1 2 N
      Coordinates acquired, situated at 1 2 facing N
      
      Initialize Rover 2 Using Inputted XY Coordinates
      3 3 E
      Coordinates acquired, situated at 3 3 facing E

3. Provide Commands: Input a sequence of commands (L, R, M) for each rover to execute.
      Provide Command Sequence LRM (Left/Right/Move) to Direct Rover 1 Operations
      LMLMLMLMM
      [L, M, L, M, L, M, L, M, M]
      
      Provide Command Sequence LRM (Left/Right/Move) to Direct Rover 2 Operations
      MMRMMRMRRM
      [M, M, R, M, M, R, M, R, R, M]


The rovers will execute their instructions, and the final positions and orientations will be displayed. If a collision is detected, all rovers will stop, and a collision message will be displayed.
