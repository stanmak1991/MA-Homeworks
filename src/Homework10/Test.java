package Homework10;

import Homework10.Robot.Robot;
import Homework10.Robot.RobotConnection;
import Homework10.Robot.RobotConnectionManager;

public class Test {
    public void testHashCodeAndEquals() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        b = null;
        System.out.println(a.equals(b));
    }

    public void testAsciiCharSequence() {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
        //проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }

    /*public void testRobot() {
        Robot robot = new Robot();
        RobotConnectionManager robotConnectionManager = new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        robot.moveRobot(robotConnectionManager, );
                    }

                    @Override
                    public void close() {

                    }
                };
            }
        };
        robot.moveRobot(robotConnectionManager, 3, 0);
    }*/
}
