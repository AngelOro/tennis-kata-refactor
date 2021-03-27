public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String[] scores = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score;
        if (player1Score == player2Score) {
            score = tieGame(player1Score);
        }
        else if (player1Score >= 4 || player2Score >= 4) {
            score = gameAdvantage();
        }
        else {
            score = currentScore();
        }
        return score;
    }


    public String tieGame (int gameScore){
        String score;
        if(gameScore <= 2){
            score = scores[gameScore] + "-All";
        }
        else {
            score = "Deuce";
        }
        return score;
    }

    public int differenceResult(){
        return player1Score - player2Score;
    }

    public String gameAdvantage(){
        String score;
        if (differenceResult()==1){
            score ="Advantage player1";
        }
        else if (differenceResult() ==-1) {
            score ="Advantage player2";
        }
        else {
            score = winner();
        }
        return score;
    }
    public String winner(){
        String score;
        if (differenceResult()>=2) {
            score = "Win for player1";
        }
        else {
            score ="Win for player2";
        }
        return score;
    }

    public String currentScore(){
        return scores[player1Score] + "-" +scores[player2Score];
    }

}
