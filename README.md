# AI-class
This was done as an exersice for the AI class COMP417
A solution to the missionaries and cannibals problem, AKA jealous husbands problem (sounds racist/sexist tbh)
https://en.wikipedia.org/wiki/Missionaries_and_cannibals_problem
The implementation is based on this code:
https://medium.com/compute-and-beyond/breadth-first-insert-search-algorithm-to-create-groot-the-tree-45700b8c1109
It uses the BFS algo to move through allowable states to the end goal as per the "solving" section of the wiki page.
The solution is not optimal (14 steps for BFS but can be done as fast as in 11 steps)
Compilation and running:
I coded and compiled it on windows 10 (my linux hard drive is done for and I'm waiting for a new one), netbeans
but also tried to compile it from the command prompt
Here's how to:
1. browse to ../src/ file
2. type javac ds/tree/*.java missionariesandcannibalsai/*.java (ignore the warnings, they're about typecasting)
3. type java missionariesandcannibalsai.MissionariesAndCannibalsAI and it should run fine
