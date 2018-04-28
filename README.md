# QUIZZZER!

Quizzzer is a console trivia game developed by team Loki. This is the first project for Telerik Academy Alpha - Java.

## Gameplay

Player starts the game
Game prompts the player for their name (NOTE: we need this here to check if we can upgrade user or not.)
The Welcome sceen allows picking one of the following options:
  * Check if Player has above 100 points and Upgrade them
  * Start New Game - game walks player through picking the game options:
    * Select Player Mode
      - Single Player
      - Dual Player
    * Player picks category
      - Questions from random categories
      - Geography
      - Tech
      - etc...
  * Ranklist
    * Show ranklist of all players and their points
  * Instructions
  * Exit Game

### Single Player Game

Game asks question
      * Show username, show player type, show badges, show Total Points for Player
    * Question
      * Show question's rating, show how many points the question gives
    * Answers
      * Show 4 possible answers
    * Mark place where player enters their answer.
      Press ‘h’ for hint?

Player picks answer and enters it
    * Game evaluates answer
      * If answer correct
         Player receives points
      * If answer is incorrect
         Show info on correct answer
      * if next question ? 
              Next question : 
              games ends

#### Single Player Game Ends
* Show and Save player rank
* show Congrats & ranks & points
          *   Result summary - best know topic and least know topic
* Evaluate if player receives any badges. 
 *  E.g: if they answer questions correctly in a row or 
 *  if they rock in certain category


### Dual Player Game

Game asks question
     * Show username, show player type, show badges, show Total Points for Player
   * Question
    *   Show question's rating, show how many points the question gives
   *  Prompt Player 1 to enter answer
    *  Player 1 enters answer
    * Prompt Player 2 to enter answer
     * Player 2 enters answer

Game evaluates answer
   * Whomever is closer to the correct answer receives the question points.
     * If both are correct, then both players receive points.
     * If both are equally incorrect, nobody gets the points

#### Dual Player Game Ends
* Show who is the winner
* show Congrats & ranks & points
    *        Result summary - best know topic and least know topic
* Evaluate if any player receives badges. 
* E.g: if they answer questions correctly in a row or 
* if they rock in certain category

-------------------------------------------
## Not Doing:
Administrative View
* Administrators create questions 
* Add Categories
* Add Question
* Delete USers

TEST BRANCH
