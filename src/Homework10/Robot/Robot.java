package Homework10.Robot;

public class Robot {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean move = false;
        int connectionAttempt = 3;
        while (connectionAttempt > 0 || move == false) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                move = true;
            } catch (RobotConnectionException e) {
                connectionAttempt--;
            }
        }
        if (connectionAttempt == 0) {
            throw new RobotConnectionException("Connection failed!");
        }
    }
}
