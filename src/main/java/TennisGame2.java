
public class TennisGame2 implements TennisGame
{
    private int player1Score;
    private int player2Score;

    private final String player1Name;
    private final String player2Name;
    private final String[] scores = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /*
     * Sumatoria de puntos a cada jugador
     * player1Score -> Puntaje jugador 1
     * player2Score -> Puntaje jugador 2
     * */
    public void wonPoint(String player) {
        if (player.equals(player1Name)){
            player1Score++;
        } else {
            player2Score++;
        }
    }

    /*
     * Obtiene resultado del juego
     * */
    public String getScore(){
        String messageScore = "";
        if (isTie()) messageScore = gameTie();
        
        if(!isTie() && isCurrentGame()) messageScore = currentScore();

        if(!isTie() && isEndGame()) messageScore = gameAdvantage();

        return messageScore;
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
    public String gameTie(){
        String score;
        if (player1Score < 3)
        {
            score = scores[player1Score] + "-All";
        }else {
            score = "Deuce";
        }
        return score;
    }

    /*
    * Verifica si aún se está jugando
    * */
    public boolean isCurrentGame(){
       return player1Score < 4 && player2Score < 4;
    }

    /*
     * Devuelve el puntaje actual del juego
     * */
    public String currentScore(){
        return scores[player1Score] + "-" + scores[player2Score];
    }

    /*
     * Se obtiene la diferencia de puntos entre los jugadores
     * */
    public int differenceResult(){
        return player1Score - player2Score;
    }

    /*
     * Se obtiene la diferencia de puntos entre los jugadores
     * */
    public boolean isEndGame(){
        return player1Score >= 4 || player2Score >= 4;
    }

    /*
     * Si el juego termina con ventaja de 1 punto devuelve mensaje de ganador
     * */
    public String gameAdvantage(){
        String score;
        if (differenceResult() == 1){
            score ="Advantage player1";
        }
        else if (differenceResult() == -1) {
            score ="Advantage player2";
        }else{
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

}