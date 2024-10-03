import java.util.*;

class Player {
   
    private String name;
    private String teamName;
    private int runScored;
    private int wicketsTaken;

    public Player(String name, String teamName){
            this.name = name;
            this.teamName = teamName;

            this.runScored = 0;
            this.wicketsTaken = 0;
    }

    public void addRuns(int runs){
        this.runScored += runs;
    }

    public void addWicket(){
        this.wicketsTaken++;
    }

    public String getName(){
        return name;
    }

    public String getTeamName(){
        return teamName;
    }

    public int getRunsScored(){
        return runScored;
    }

    public int getWicketsTaken(){
        return wicketsTaken;
    }

    

}

class Team{
    private String name;
    private List<Player> players;

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public String getName(){
        return name;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getPlayer(String PlayerName){
        for(Player player : players){
            if(player.getName().equals(PlayerName)){
                return player;
            }
        }
        return null;
    }

}

class Ball{

    private String result;
    private int runs;
    private boolean isWicket;

    public Ball(String result,int runs, boolean isWicket){
        this.result = result;
        this.runs = runs;
        this.isWicket  = isWicket;
    }

public int getRuns(){
    return runs;
}

public boolean isWicket(){
    
    return isWicket;

}

@Override
public String toString(){
    return "Ball:" + result;
}

}

class Match{

    private String matchId;
    private Team team1;
    private Team team2;
    private List<Ball> balls;
    private int scoreTeam1;
    private int scoreTeam2;
    private boolean isMatchOver;

    public Match(String matchId, Team team1, Team team2){

        this.matchId = matchId;
        this.team1 = team1;
        this.team1 = team2;
        this.balls = new ArrayList<>();
        this.scoreTeam1 = 0;
        this.scoreTeam2 = 0;
        this.isMatchOver = false;
    }

    public String geMatchId(){
        return matchId;
    }

    public void addball(Ball ball, String team){
        balls.add(ball);
        if(!isMatchOver){
            if(team.equals(team1.getName())){
                scoreTeam1 += ball.getRuns();

            }
            else if(team.equals(team2.getName())){
                scoreTeam2 += ball.getRuns();
            }
        }
    }


    public int getScore(String team){
        if(team.equals(team1.getName())){
            return scoreTeam1;
        }
        else if(team.equals(team2.getName())){
            return scoreTeam2;
        }
        return 0;
    }

        public void endMatch(){
            isMatchOver = true;
        }

        public String getMatchResult(){
            if(scoreTeam1 > scoreTeam2){
                return "winner is " + team1.getName();
            }
            else if(scoreTeam2 > scoreTeam1){
                return "winner is " + team2.getName();
            }

            else {
                return "Match draw";
            }


        }

        @Override
        public String toString() {
            return "Match: " + matchId + " | " + team1.getName() + " vs " + team2.getName() + 
                   " | Score: " + scoreTeam1 + "/" + scoreTeam2;
        }

}

public class CricBuzz {
    
    private Map<String,Match> matches;
    private Map<String,Player> players;

    public CricBuzz(){
        this.matches = new HashMap<>();
        this.players = new HashMap<>();

    }

    public void startMatch(String matchId, Team team1, Team team2){
        Match match = new Match(matchId, team1, team2);
        matches.put(matchId, match);
    }

    public void updateScore(String matchId,Ball ball, String teamName){
        Match match  = matches.get(matchId);
        if(match != null){
            match.addball(ball, teamName);
        }
    }

    public void endMatch(String matchId){
        Match match = matches.get(matchId);
        if(match != null){
            match.endMatch();
        }
    }

    public void displayMatchDetails(String matchId) {
        Match match = matches.get(matchId);
        if (match != null) {
            System.out.println(match);
        }
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void displayPlayerStats(String playerName) {
        Player player = players.get(playerName);
        if (player != null) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        CricBuzz cricbuzz = new CricBuzz();
        
        // Create teams
        Team india = new Team("India");
        Player virat = new Player("Virat Kohli", "India");
        Player rohit = new Player("Rohit Sharma", "India");
        india.addPlayer(virat);
        india.addPlayer(rohit);

        Team australia = new Team("Australia");
        Player smith = new Player("Steve Smith", "Australia");
        Player warner = new Player("David Warner", "Australia");
        australia.addPlayer(smith);
        australia.addPlayer(warner);

        // Add players to Cricbuzz
        cricbuzz.addPlayer(virat);
        cricbuzz.addPlayer(rohit);
        cricbuzz.addPlayer(smith);
        cricbuzz.addPlayer(warner);

        // Start a match
        cricbuzz.startMatch("INDvsAUS", india, australia);
        
        // Update score for ball-by-ball events
        cricbuzz.updateScore("INDvsAUS", new Ball("1 run", 1, false), "India");
        cricbuzz.updateScore("INDvsAUS", new Ball("Wicket", 0, true), "Australia");

        // Display match details
        cricbuzz.displayMatchDetails("INDvsAUS");

        // End the match
        cricbuzz.endMatch("INDvsAUS");

        // Display player stats
        cricbuzz.displayPlayerStats("Virat Kohli");
    }

}
