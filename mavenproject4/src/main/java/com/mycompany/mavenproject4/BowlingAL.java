/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sidad
 */
public class BowlingAL {

    public String PointsSum(int[][] points) {

        // for cone simulations 
        int cones = 10;

        // adding points
        int sum = 0;

        //list of final calculations
        ArrayList<Integer> pointsum = new ArrayList<Integer>();

        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points[i].length; j++) {

                cones -= points[i][j];
                sum += points[i][j];

                if (j == 1 && points[i][j] != 10) {
//SPARE CHECKER
                    if (cones == 0) {
                        System.out.println("SPARE");
                        try {

                            // CHECKS IF FINAL ROUND
                            if (i < 9) {
                                sum += points[i + 1][j - 1];
                            } else {
                                sum += points[i + 1][j - 1];
                                pointsum.add(sum);
                                //return the final results when final row is calculted
                                return pointsum.toString();
                            }
                        } catch (Exception e) {
                            System.out.println("no more points");

                        }

                    }
// NORMAL ADDER
                    if (points[i][0] != 10) {
                        pointsum.add(sum);
                    }

                    cones = 10;
                }

// STRIKE ADDER 
                if (cones == 0) {
                    System.out.println("STRIKE");
                    //CHECKS IF FINAL ROUND
                    try {

                        if (i < 9) {

                            //CHECKS FOR MULITPLE STRIKES
                            if (points[i + 1][0] == 10 || points[i + 1][1] == 10) {

                                sum += 10;

                                if (points[i + 2][0] == 10 || points[i + 2][1] == 10) {
                                    sum += 10;

                                } else {
                                    sum += points[i + 2][0];
                                }
                            } else {
                                sum += points[i + 1][0] + points[i + 1][1];
                            }
                        } else {
                            sum += points[i + 1][0] + points[i + 1][1];
                            pointsum.add(sum);
                            //return the final results when final row is calculted
                            return pointsum.toString();
                        }
                    } catch (Exception e) {
                        System.out.println("no more points");
                    }

                    pointsum.add(sum);

                    cones = 10;
                }

            }

        }
        return pointsum.toString();

    }

}
