Bowling Scorer

This is a Java-based console application that simulates a bowling game, allowing players to input their scores frame by frame. The application calculates and displays each player's total score after each frame, with special rules applied for strikes, spares, and the 10th frame.

Features
- Multiple Players: Supports any number of players, with names inputted at the start of the game.
- Frame-by-Frame Input: Players input their scores for each frame, with validation to ensure realistic scores.
- Automatic Scoring: The application automatically calculates and updates scores after each frame, including bonuses for strikes and spares.
- 10th Frame Special Rules: Handles the special scoring rules for the 10th frame, allowing for a third throw if a strike or spare is scored.


Table of Contents
- Installation
- Usage
- Example Gameplay
- File Structure
- Contributing
- License


Installation

Clone the repository:
  git clone https://github.com/bstahlman27/Bowling-Scorer.git
  cd bowling-scorer


Compile the Java files:

javac bowlingScorer/*.java


Run the application:

java bowlingScorer.BowlingGame


Usage

When you run the application, you'll be prompted to enter the number of players and each player's name. The game will then proceed frame by frame, asking each player for their throws in each frame. The application ensures that inputs are valid and handles special cases like strikes, spares, and the 10th frame's extra throw.

Example Gameplay (please use code view):

Enter number of players:
2
Enter player 1 name:
Jim
Enter player 2 name:
Bob

Jim - Frame 1
Enter first throw:
7
Enter second throw:
2
Bob - Frame 1
Enter first throw:
10

Jim's total score after frame 1: 9
Bob's total score after frame 1: 10

Jim - Frame 2
Enter first throw:
8
Enter second throw:
1
Bob - Frame 2
Enter first throw:
7
Enter second throw:
3

Jim's total score after frame 2: 18
Bob's total score after frame 2: 30
...
10th Frame Example

Jim - Frame 10
Enter first throw:
10
Enter second throw:
10
Enter third throw:
7


File Structure

BowlingGame.java: Contains the main method and handles the game loop and user interaction.
Player.java: Represents a player, including their name and the frames they have played.
Frame.java: Represents a single frame in the game, including the throws, and whether it's a strike or spare.


Contributing

Contributions and ideas are welcome. You are free to download these files and make any changes for yourself.

License
This project currently has no license.
