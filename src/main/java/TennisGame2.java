
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
        if (isTie()){
            return gameTie();
        }
        if(isAdvanceGame()){
            return gameAdvantage();
        }
        else{
            return currentScore();
        }
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
        return (player1Score < 3) ? scores[player1Score] + "-All" : "Deuce";
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
     * Verifica si el juego avanzó
     * */
    public boolean isAdvanceGame(){
        return player1Score >= 4 || player2Score >= 4;
    }

    /*
     * Si el juego termina con ventaja de 1 punto devuelve mensaje de ganador
     * */
    public String gameAdvantage(){
        String score;
        if (differenceResult() == 1){
            score ="Advantage player1";
        } else if (differenceResult() == -1) {
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
        return (differenceResult()>=2) ? "Win for player1" : "Win for player2";
    }

}