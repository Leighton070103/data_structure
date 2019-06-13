package problem.course.matrix;

import static util.PrintUtil.printNum;

/**
 * Clock wise print practice.
 */
public class ClockWisePrint {
    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean reachesREnd(Coordinate endCoor) {
            return !(x < endCoor.x);
        }

        boolean reachesDEnd(Coordinate endCoor) {
            return !(y < endCoor.y);
        }

        boolean outOfDEnd(Coordinate endCoor){
            return y>endCoor.y;
        }
        boolean outOfREnd(Coordinate endCoor){
            return x>endCoor.x;
        }

        boolean reachesEnd(Coordinate endCoor) {
            return reachesREnd(endCoor) || reachesDEnd(endCoor);
        }

        void moveRight() {
            x++;
        }

        void moveLeft() {
            x--;
        }

        void moveUp() {
            y--;
        }

        void moveDown() {
            y++;
        }

        void moveRightDown() {
            x++;
            y++;
        }

        void moveLeftUp() {
            x--;
            y--;
        }

        boolean reachesLEnd(Coordinate startCoor) {
            return !(x > startCoor.x);
        }

        boolean reachesUEnd(Coordinate startCoor) {
            return !(y > startCoor.y);
        }

        Coordinate copy() {
            return new Coordinate(x, y);
        }

        void print(int[][] matrix) {
            printNum(matrix[y][x]);
        }

    }

    public void print(int[][] matrix) {
        Coordinate startCoor = new Coordinate(0, 0);
        Coordinate endCoor = new Coordinate(matrix[0].length - 1, matrix.length - 1);
        while (!startCoor.reachesEnd(endCoor)) {
            Coordinate ptrCoor = startCoor.copy();
            if (ptrCoor.reachesREnd(endCoor)) {
                do {
                    ptrCoor.print(matrix);
                    ptrCoor.moveDown();
                } while (!ptrCoor.outOfDEnd(endCoor));
            } else if (ptrCoor.reachesDEnd(endCoor)) {
                do {
                    ptrCoor.print(matrix);
                    ptrCoor.moveRight();
                } while (!ptrCoor.outOfREnd(endCoor));
            } else {
                while (!ptrCoor.reachesREnd(endCoor)) {
                    ptrCoor.print(matrix);
                    ptrCoor.moveRight();
                }
                while (!ptrCoor.reachesDEnd(endCoor)) {
                    ptrCoor.print(matrix);
                    ptrCoor.moveDown();
                }
                while (!ptrCoor.reachesLEnd(startCoor)) {
                    ptrCoor.print(matrix);
                    ptrCoor.moveLeft();
                }
                while (!ptrCoor.reachesUEnd(startCoor)) {
                    ptrCoor.print(matrix);
                    ptrCoor.moveUp();
                }
            }

            startCoor.moveRightDown();
            endCoor.moveLeftUp();
        }
    }
}
