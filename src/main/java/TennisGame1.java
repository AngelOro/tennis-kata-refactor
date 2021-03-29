public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private final String[] scores = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /*
    * Sumatoria de puntos a cada jugador
    * player1Score -> Puntaje jugador 1
    * player2Score -> Puntaje jugador 2
    * */
    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score ++;
        else
            player2Score ++;
    }

    /*
    * Obtiene resultado del juego
    * */
    public String getScore() {
        String score;
        if (isTie()) {
            score = tieGame();
        }
        else if (isEndGame()) {
            score = gameAdvantage();
        }
        else {
            score = currentScore();
        }
        return score;
    }

    /*
    * Verifica si está en empate
    * */
    public boolean isTie(){
        return player1Score == player2Score;
    }

    /*
    * Devuelve el mensaje de empate de acuerdo al array scores[]
    * */
    public String tieGame (){
        String score;
        if(player1Score <= 2){
            score = scores[player1Score] + "-All";
        }
        else {
            score = "Deuce";
        }
        return score;
    }

    /*
    * Verifica si el juego terminó
    * */
    public boolean isEndGame(){
        return player1Score >= 4 || player2Score >= 4;
    }

    /*
    * Se obtiene la diferencia de puntos entre los jugadores
    * */
    public int differenceResult(){
        return player1Score - player2Score;
    }

    /*
    * Si el juego termina con ventaja de 1 punto devuelve mensaje de ganador
    * */
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

    /*
    * Si el juego termina con ventaja de 2 o más puntos devuelve mensaje de ganador
    * */
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

    /*
    * Devuelve el puntaje actual del juego
    * */
    public String currentScore(){
        return scores[player1Score] + "-" +scores[player2Score];
    }
}
