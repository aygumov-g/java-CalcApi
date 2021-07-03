/*
 * Copyright (c) 2003, 2020. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 */


import java.util.ArrayList;

import java.util.Arrays;


/**
 * This calculator module can calculate both negative numbers and brackets, as well as trigonometric functions and factorials.
 * A usage example is provided.
 * {@code System.in}:
 * <blockquote><pre>{@code
 *      Calc.express("2+2*2")
 * }</pre></blockquote>
 * The result can be simply output:
 * <blockquote><pre>{@code
 *      System.out.println(Calc.express("sin5 + cos10"))
 * }</pre></blockquote>
 * So assign it to a variable (DOUBLE IS MANDATORY, THE TYPE OF WHICH SHOULD BE PERMANENT):
 * <blockquote><pre>{@code
 *       int n1 = 5;
 *       int n2 = 10;
 *       double answer = Calc.express(String.valueOf(n1 + n2));
 *       double answerFactorial = Calc.express(answer + "!");
 *       System.out.println(answerFactorial);
 * }</pre></blockquote>
 * Calculation of trigonometric functions:
 * <blockquote><pre>{@code
 *        String n1 = "arccos5";
 *        String n2 = "arcsin(2+3)!";
 *        String answer = MessageFormat.format("{0}+{1}", n1, n2);
 *        System.out.println(Calc.express(answer));
 * }</pre></blockquote>
 *
 * The Calc. express method accepts only LOWERCASE VALUES
 */


public class Calc {



    public static double express(String mathInput) {

        return collectArray(mathInput);

    }



    private static double collectArray(String mathInput) {

        String replaceMathInput = mathInput.replaceAll(" ", "");

        StringBuilder returnMathInput = new StringBuilder(String.valueOf(replaceMathInput.charAt(0)));

        String sim;

        String simTrig = "sin cos tan arcsin arccos arctan";

        for (int i = 0; i < replaceMathInput.length()+1; i++) {


            if (i == 0) {


                continue;


            }

            sim = String.valueOf(replaceMathInput.charAt(i - 1));

            try {


                if (isNumeric(sim)) {


                    if (isNumeric(String.valueOf(replaceMathInput.charAt(i)))) {


                        returnMathInput.append(replaceMathInput.charAt(i));


                    } else {


                        if (String.valueOf(replaceMathInput.charAt(i)).equals(".")) {


                            returnMathInput.append(replaceMathInput.charAt(i));


                        } else if (String.valueOf(replaceMathInput.charAt(i)).equals("!")) {


                            returnMathInput.append(replaceMathInput.charAt(i));


                        } else if (String.valueOf(replaceMathInput.charAt(i)).equals("%")) {


                            returnMathInput.append(replaceMathInput.charAt(i));


                        } else {


                            returnMathInput.append(" ").append(replaceMathInput.charAt(i));


                        }


                    }


                } else {


                    if (sim.equals(".")) {


                        returnMathInput.append(replaceMathInput.charAt(i));


                    } else if (simTrig.contains(sim) && !String.valueOf(replaceMathInput.charAt(i)).equals("(")) {


                        returnMathInput.append(replaceMathInput.charAt(i));


                    } else {


                        if (i == 1 || String.valueOf(replaceMathInput.charAt(i-2)).equals("(") && sim.equals("-")) {


                            if (!sim.equals("(")) {


                                returnMathInput.append(replaceMathInput.charAt(i));


                            } else {

                                returnMathInput.append(" ").append(replaceMathInput.charAt(i));

                            }


                        } else {


                            returnMathInput.append(" ").append(replaceMathInput.charAt(i));


                        }


                    }


                }


            } catch (Exception ignore) {}


        }

        String[] mainMathArray = returnMathInput.toString().split(" ");

        return checkMain(mainMathArray);


    }



    private static double checkMain(String[] mathArray) {

        StringBuilder mathString = new StringBuilder();

        for (String s : mathArray) {


            mathString.append(s);


        }

        if (mathString.toString().contains("(") || mathString.toString().contains(")")) {


            int lenOpenBrackets = 0;

            for (int i = 0; i < mathString.length(); i++) {


                if (String.valueOf(mathString.charAt(i)).equals("(")) {


                    lenOpenBrackets++;


                }


            }

            for (int i = 0; i < lenOpenBrackets; i++) {


                mathArray = brackets(mathArray);


            }


        }


        return equation(mathArray);


    }



    private static double equation(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        StringBuilder mathString = new StringBuilder();

        for (String s : mathArray) {


            mathString.append(s);


        }

        if (mathString.toString().contains("arcsin")) {


            mathArrayList = new ArrayList<>(Arrays.asList(arcsin(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("arccos")) {


            mathArrayList = new ArrayList<>(Arrays.asList(arccos(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("arctan")) {


            mathArrayList = new ArrayList<>(Arrays.asList(arctan(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("sin")) {


            mathArrayList = new ArrayList<>(Arrays.asList(sin(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("cos")) {

            mathArrayList = new ArrayList<>(Arrays.asList(cos(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("tan")) {

            mathArrayList = new ArrayList<>(Arrays.asList(tan(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("%")) {
            mathArrayList = new ArrayList<>(Arrays.asList(percent(mathArray)));
            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }
        }

        if (mathString.toString().contains("!")) {
            mathArrayList = new ArrayList<>(Arrays.asList(factorial(mathArray)));
            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }
        }

        if (mathString.toString().contains("^")) {

            mathArrayList = new ArrayList<>(Arrays.asList(degree(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        if (mathString.toString().contains("*") || mathString.toString().contains("/")) {

            mathArrayList = new ArrayList<>(Arrays.asList(multiplyShare(mathArray)));

            for (int i = 0; i < mathArrayList.size(); i++) { mathArray[i] = mathArrayList.get(i); }


        }

        return additionSubtraction(mathArrayList);


    }



    private static String[] brackets(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        StringBuilder expression = new StringBuilder();

        ArrayList<String> deleteMathListArrayIndex = new ArrayList<>();

        int bracketsCloseIndex = 0;

        int bracketsOpenIndex = 0;

        for (int i = 0; i < mathArrayList.size(); i++) {


            if (mathArrayList.get(i).equals(")")) {


                bracketsCloseIndex = i;


                for (int j = i - 1; j >= 0; j--) {


                    if (mathArrayList.get(j).equals("(")) {


                        bracketsOpenIndex = j;


                        for (int k = j + 1; k < i; k++) {


                            expression.append(mathArrayList.get(k)).append(" ");

                            deleteMathListArrayIndex.add(String.valueOf(k));


                        }


                        break;
                    }


                }


                break;
            }


        }

        mathArrayList.set(bracketsOpenIndex, String.valueOf(equation(expression.toString().split(" "))));

        mathArrayList.remove(bracketsCloseIndex);

        for (int i = deleteMathListArrayIndex.size()-1; i >= 0; i--) {


            mathArrayList.remove(Integer.parseInt(deleteMathListArrayIndex.get(i)));


        }


        String[] returnMathArray = new String[mathArrayList.size()];

        for (int i = 0; i < mathArrayList.size(); i++) {


            returnMathArray[i] = mathArrayList.get(i);


        }


        return returnMathArray;


    }



    private static String[] arcsin(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("arcsin")) {


                    mathArrayList.set(i, String.valueOf(Math.asin(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("arcsin", ""))))));


                }

            } catch (Exception exception) {


                mathArrayList.set(i+1, String.valueOf(Math.asin(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("arcsin", ""))))));


                mathArrayList.remove(i);
            }


        }


        return rebuild(mathArrayList);


    }



    private static String[] arccos(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("arccos")) {


                    mathArrayList.set(i, String.valueOf(Math.acos(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("arccos", ""))))));


                }

            } catch (Exception exception) {


                mathArrayList.set(i+1, String.valueOf(Math.acos(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("arccos", ""))))));


                mathArrayList.remove(i);
            }


        }


        return rebuild(mathArrayList);


    }



    private static String[] arctan(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {

                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("tan")) {


                    mathArrayList.set(i, String.valueOf(Math.atan(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("arctan", ""))))));


                }

            } catch (Exception exception) {


                mathArrayList.set(i+1, String.valueOf(Math.atan(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("arctan", ""))))));

                mathArrayList.remove(i);


            }


        }

        return rebuild(mathArrayList);


    }



    private static String[] sin(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("sin")) {


                    mathArrayList.set(i, String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("sin", ""))))));


                }

            } catch (Exception exception) {


                mathArrayList.set(i+1, String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("sin", ""))))));


                mathArrayList.remove(i);

            }

        }

        return rebuild(mathArrayList);


    }



    private static String[] cos(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("cos")) {


                    mathArrayList.set(i, String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("cos", ""))))));


                }
            } catch (Exception exception) {

                mathArrayList.set(i+1, String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("cos", ""))))));


                mathArrayList.remove(i);

            }
        }


        return rebuild(mathArrayList);


    }



    private static String[] tan(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);

                if (mathArrayListElement.contains("tan")) {


                    mathArrayList.set(i, String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(mathArrayListElement.replaceAll("tan", ""))))));

                }

            } catch (Exception exception) {


                mathArrayList.set(i+1, String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(mathArrayList.get(i+1).replaceAll("tan", ""))))));


                mathArrayList.remove(i);


            }


        }

        return rebuild(mathArrayList);


    }



    private static String[] percent(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElementPercent = mathArrayList.get(i);


                if (mathArrayListElementPercent.contains("%")) {

                    String mathArrayListElementPercentNumber = mathArrayList.get(i+1);

                    double percentElement = Double.parseDouble(mathArrayListElementPercent.replaceAll("%", ""));

                    double answerPercentElement = percentElement / 100 * Double.parseDouble(mathArrayListElementPercentNumber);

                    mathArrayList.set(i, String.valueOf(answerPercentElement));

                    mathArrayList.remove(i+1);


                }


            } catch (Exception exception) {


                String mathArrayListElementPercent = mathArrayList.get(i-1);

                String mathArrayListElementPercentNumber = mathArrayList.get(i+1);

                double percentElement = Double.parseDouble(mathArrayListElementPercent.replaceAll("%", ""));

                double answerPercentElement = percentElement / 100 * Double.parseDouble(mathArrayListElementPercentNumber);

                mathArrayList.set(i, String.valueOf(answerPercentElement));

                mathArrayList.remove(i+1);

                mathArrayList.remove(i-1);


            }


        }

        return rebuild(mathArrayList);

    }




    private static String[] factorial(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            try {


                String mathArrayListElement = mathArrayList.get(i);


                if (mathArrayListElement.contains("!")) {


                    double sumFactorial = 1;

                    double mathArrayListElementFactorial = Double.parseDouble(mathArrayListElement.replaceAll("!", ""));

                    if (mathArrayListElementFactorial > 0) {


                        while (mathArrayListElementFactorial > 0) {


                            sumFactorial *= mathArrayListElementFactorial;

                            mathArrayListElementFactorial--;


                        }


                    } else {


                        while (mathArrayListElementFactorial < 0) {


                            sumFactorial *= mathArrayListElementFactorial;

                            mathArrayListElementFactorial++;


                        }


                    }


                    mathArrayList.set(i, String.valueOf(sumFactorial));
                }


            } catch (Exception exception) {


                String mathArrayListElement = mathArrayList.get(i-1);

                double sumFactorial = 1;

                double mathArrayListElementFactorial = Double.parseDouble(mathArrayListElement.replaceAll("!", ""));

                if (mathArrayListElementFactorial > 0) {


                    while (mathArrayListElementFactorial > 0) {


                        sumFactorial *= mathArrayListElementFactorial;

                        mathArrayListElementFactorial--;


                    }

                } else {


                    while (mathArrayListElementFactorial < 0) {


                        sumFactorial *= mathArrayListElementFactorial;

                        mathArrayListElementFactorial++;

                    }


                }

                mathArrayList.set(i-1, String.valueOf(sumFactorial));

                mathArrayList.remove(i);


            }


        }

        return rebuild(mathArrayList);

    }



    private static String[] degree(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            double sum = 1;

            if (mathArrayList.get(i).equals("^")) {


                double step = Double.parseDouble(mathArrayList.get(i+1));

                while (step > 0) {


                    sum *= Double.parseDouble(mathArrayList.get(i-1));

                    step--;


                }

                mathArrayList.set(i, Double.toString(sum));

                mathArrayList.remove(i+1);

                mathArrayList.remove(i-1);

            }


        }

        return rebuild(mathArrayList);


    }



    private static String[] multiplyShare(String[] mathArray) {

        ArrayList<String> mathArrayList = new ArrayList<>(Arrays.asList(mathArray));

        for (int i = 0; i < mathArrayList.size(); i++) {


            if (mathArrayList.get(i).equals("*")) {


                mathArrayList.set(i, Double.toString(Double.parseDouble(mathArrayList.get(i-1)) * Double.parseDouble(mathArrayList.get(i+1))));

                mathArrayList.remove(i+1);

                mathArrayList.remove(i-1);


            } else if (mathArrayList.get(i).equals("/")) {


                mathArrayList.set(i, Double.toString(Double.parseDouble(mathArrayList.get(i-1)) / Double.parseDouble(mathArrayList.get(i+1))));

                mathArrayList.remove(i+1);

                mathArrayList.remove(i-1);


            }


        }


        return rebuild(mathArrayList);


    }



    private static double additionSubtraction(ArrayList<String> mathArrayList) {

        double sum = 0;

        for (int i = 0; i < mathArrayList.size(); i++) {


            if (i == 0) {


                if (!mathArrayList.get(i).equals("")) {


                    sum = Double.parseDouble(mathArrayList.get(i));


                } else {


                    sum = Double.parseDouble(mathArrayList.get(i+1));


                }

            } else {

                if (mathArrayList.get(i-1).equals("+")) {


                    sum += Double.parseDouble(mathArrayList.get(i));


                } else if (mathArrayList.get(i-1).equals("-")) {


                    sum -= Double.parseDouble(mathArrayList.get(i));
                }

            }


        }


        return sum;


    }



    private static boolean isNumeric(String str) {

        try {


            Double.parseDouble(str);

            return true;


        } catch (NumberFormatException e) {


            return false;
        }

    }



    private static String[] rebuild(ArrayList<String> mathArrayList) {

        String[] returnMathArray = new String[mathArrayList.size()];

        for (int i = 0; i < mathArrayList.size(); i++) {


            returnMathArray[i] = mathArrayList.get(i);


        }


        return returnMathArray;

    }


}
