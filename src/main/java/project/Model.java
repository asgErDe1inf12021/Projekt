package project;

import Things.Cube;
import java.awt.*;

public class Model {
    private int[][] cube;
    void Model() {
        cube = new int[3][3];
        cube[0][0] = 100; // x-position
        cube[0][1] = 100; // y-position
        cube[1][0] = 20; // length
        cube[1][1] = 20; // hight
        }
    public int[][] getObj(){
        return cube;
    }
}
