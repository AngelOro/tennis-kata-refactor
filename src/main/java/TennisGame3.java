
public class TennisGame3 implements TennisGame {
    
    private int player2Score;
    private int player1Score;
    private final String player1Name;
    private final String player2Name;
    private final String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /*
     * Sumatoria de puntos a cada jugador
     * player1Score -> Puntaje jugador 1
     * player2Score -> Puntaje jugador 2
     * */
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

    /*
     * Obtiene resultado del juego
     * */
    public String getScore() {
        String scoreMessage;
        if (noWinner() && !(isDeuce())) {
            scoreMessage = (isTie()) ? gameTie() : currentScore();
        }else if (isDeuce()){
            scoreMessage = "Deuce";
        }else {
            scoreMessage = advanceGame();
        }
        return scoreMessage;
    }

    /*
     * Verifica si está en empate
     * */
    public boolean isTie(){
        return player1Score == player2Score;
    }

    /*
     * Devuelve el mensaje de empate de acuerdo al array points[]
     * */
    public String gameTie(){
        return points[player1Score] + "-All";
    }

    /*
     * Método que verifica si se llega a empatar a 40
     * */
    public boolean isDeuce(){
        return ((isTie()) && (player1Score + player2Score >= 6));
    }

    /*
     * Devuelve el puntaje actual del juego
     * */
    public String currentScore(){
        return points[player1Score] + "-" + points[player2Score];
    }

    /*
    * Develve true si aún no hay ganadores
    * */
    public boolean noWinner(){
        return player1Score < 4 && player2Score < 4;
    }

    /*
     * Se obtiene la diferencia de puntos entre los jugadores
     * */
    public int differencePoints(){
        return player1Score - player2Score;
    }

    /*
    * Se eleva a potencia par a la diferencia de puntos
    * */
    public int differencePointsPow(){
        return (int) Math.pow(differencePoints(),2);
    }

    /*
    * Obtiene el nombre del jugador
    * */
    public String getPlayerName(){
        return player1Score > player2Score ? player1Name : player2Name;
    }

    /*
    * Devuelve True si un jugador tomó ventaja
    * */
    public boolean isAdvantage(){
        return differencePointsPow() == 1;
    }

    /*
    * Devuelve los jugadores que toman ventaja o los que ganan el partido
    * */
    public String advanceGame(){
        return (isAdvantage()) ? "Advantage " + getPlayerName() : "Win for " + getPlayerName();
    }

}
