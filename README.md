# Raycaster in Java
This raycaster is programmed with the formula of line-line intersection (https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection)
Rays getting sent out of the player's point and then calculated if there is an intersection with a wall. The player point has a direction vector which is used to calculate the rays with the fov. The direction vector will later also be used to calculate the moving. After the intersection is calculated the length of the vector will be multiplied by the angle of the direction vector to minimalize the fish-eye effect. The resulting length will be used to calculate the height of the wall.



Controls will be added later. V0.1.1 has in window 2 mouse control added. Drag mouse for moving. Left and right arrow key control the direction.


Texture will eventually be added later. A map creator will also be added in a later version (other repo).

Programmed in IntelliJ.
