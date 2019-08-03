package Homework01;

public class Totalizator {
    public static int totalizator(int firstTeamScore, int secondTeamScore, int firstTeamScoreBet, int secondTeamScoreBet) {
        if ((firstTeamScore < secondTeamScore != firstTeamScoreBet < secondTeamScoreBet)
                || (firstTeamScore > secondTeamScore != firstTeamScoreBet > secondTeamScoreBet)
                || ((firstTeamScore != secondTeamScore) != (firstTeamScoreBet != secondTeamScoreBet))) {
            return 0;
        }
        return ((firstTeamScore - secondTeamScore) == (firstTeamScoreBet - secondTeamScoreBet)) ? 2 : 1;
    }
}