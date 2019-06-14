# Raycaster in Java
This raycaster is programmed with the formular of line-line intersection (https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection)
Rays getting sent out of the players point and then calculated if there is an intersection with a wall. The player point has an direction vector which is used to calculate the rays with the fov. The direction vector will later also be used to calculate the moving. After the intersection is calculated the length of the vector will be multiplied by the angle of the direction vector to minimalize the fish-eye effect. The resulting length will be used to calculate the height of the wall.



Controls will be added later. V0.1.1 has in window 2 mouse control added. Drag mouse for moving. Left and right arrow key controls the direction.

Nullpointer will be fixed later (adjustable window causes it at start).

Texture will eventually be added later. Map creator will also be added in a later version (other repo).

Programmed in Intellij.

Debugger is not working because:Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended 

Idk how to fix it or what it causes. It appeared randomly.
