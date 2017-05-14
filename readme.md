RaceGame
========
Usage :

Go to car-race-game/run directory and execute below command 

To execute run:  car-race-gamerun.bat

To change track, open config.properties and update track

=========

So for instance the following in the race.txt file 
00011

Means 3 straight line units and 2 corners

Now you have 4 cars that need to race in the game at the same time. Each car has different speed attributes.
Namely: 
Acceleration (A)
TopSpeed	(TS)
and Cornering (C)

The higher the speed value for each one the better it is

So for instance
Car A:
A : 5
TS : 10
C : 2

Car B:
A :3
TS : 9
C : 6

Car C:
A :3
TS : 15
C : 3

Car D:
A :7
TS : 12
C : 3

In order to play the game you have to use the given cars values for either a straight line or corner. You add up the values for each and the car with the
highest total at the end of the track wins.
Note that Top Speed is a limiting factor

Here is an example:

Assume track is as follows

0000111

Game play is as follows for the first 4 straights and 3 corners, remember that when accelerating the value is ADDED to the previous speed value. 
so if the current speed is 8 and its acceleration is 3 the total for that straight would be 11 (Take note of the cars topspeed. if its less than the value. Ie 10) then limit it to 10
Corners do not accumulate as the car is not accelerating.

Car A Game Play
(A) 5 + (A) 10 (Total is now 10 but can NOT go faster than its top speed of 10) so any subsequent straight lines will be limited to 10 unless it slows down

Then it goes into a corner and its speed drops  2, it has another corner and its value is still 2 (Remember that you are adding up all these values as you go along but car does not accelerate in corners so values dont accumulate)

so Car A total at the end of the short race is:  5 + 10 + 10 + 10 + 2 + 2 + 2 = 41

Car B 
(A) 3 + (A) 3 (its still accelerating as it has not hit its top speed) +  (A) 3 (It's now at top speed) + 9 + 6 + 6 (it slowed down to 6 in the corners)

So Car total at the end of the short race is: 3 + 6 + 9 + 9 + 6 + 6 + 6 = 45
Car B Wins.
The other cars should play accordingly.

So from the above it can be seen that Car B won due to its cornering ability

Play the entire game with the values given for the cars above. and the input values for the track
