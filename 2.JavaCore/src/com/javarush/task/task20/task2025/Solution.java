package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[][] matrix;
        long[] maxs;
        long[] mins;
        ArrayList<Long> resultList = new ArrayList<>(); //  список с найденными числами
        if (N < 0) return new long[0];
        long[] result;
        int digNumb = getDigNumb(N); //  определяем количество цифр в N

        matrix = new long[10][digNumb]; // матрица с цифрами, возведенными в степень от 1 до digNumb
        maxs = new long[digNumb]; // массив с максимальными значениями для соответствующего разряда
        mins = new long[digNumb]; // массив с минимальными значениями для соответствующего разряда
        // заполняем matrix, maxs, mins
        for (int j = 0; j < digNumb; j++) {
            mins[j] = 1*pow(10, j);
            maxs[j] = 1*pow(10, j+1) - 1;
            for (int i = 0; i < 10; i++) {
                matrix[i][j] = pow(i, j + 1);
            }
        }
        maxs[digNumb - 1] = N - 1; // максимальное число, для которого будет осуществлятся поиск (меньше N)
        // ищем числа Армстронга для каждого порядка отдельно, начиная с 1
        for (int r = 1; r <= digNumb ; r++) {
            proc(0, 1, r, resultList, matrix, mins, maxs);
        }
        // переписываем полученные значения из списка в массив
        Collections.sort(resultList);
        if (resultList.size() > 0) {
            result = new long[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
        }
        else{
            result = new long[0];
        }

        return result;
    }
    //рекурсивно перебираем все числа. first - наименьшая цифра для текущего разряда;
    // digPos - текущий разряд, позиция цифры в числе; numb - число старшего разряда
    private static void proc(long numb, int first, int digPos, List<Long> resultList, long[][] matrix, long[] mins, long[] maxs) {
        for (int i = first; i < 10; i++) {
            long number = i * pow(10, digPos - 1) + numb;
            // если текущее число превысило максимальное для Long (стало меньше ноля), выходим
            if (number < 0) return;
            // если из number путем перестановки его цифр можно получить число Армстронга, находим его
            long arm = getArmst(number, mins, matrix, maxs);
            if (arm >= 0 && !resultList.contains(arm))
                resultList.add(arm);
            if (digPos > 1) proc(number, i, digPos - 1, resultList, matrix, mins, maxs);
        }
        return;
    }

    // если сумма цифр числа N, возведенных в степень порядка числа N, является числом Армстронга того же порядка, что
    // и N, получаем его, иначе возвращается -1. Если найденное число Армстронга не меньше числа N,
    // также возвращается -1
    private static long getArmst (long numb, long[] mins, long[][] matrix, long[] maxs) {
        long sum = 0;
        int digNumb = getDigNumb(numb); // количество цифр в Numb
        // считаем sum - сумму всех цифр, возведенных в степень порядка числа
        do {
            sum += matrix[(int) (numb % 10)][digNumb - 1];
        } while ((numb /= 10) > 0);
        // если sum больше максимального или минимального числа для данного порядка, возвращаем -1
        if(sum > maxs[digNumb - 1] || sum < mins[digNumb - 1]) return -1;
        // проверяем, является ли sum числом Армстронга, если да, возвращаем его, если нет, возвращаем -1
        long sum1 = 0;
        for (long i = sum; i > 0 ; i = i/10) {
            sum1 += matrix[(int) (i % 10)][digNumb - 1];
        }
        if (sum1 != sum) return -1;
        return sum;
    }

    //количество цифр в numb
    private static int getDigNumb (long numb) {
        long temp = 0L;
        int digNumb = 1;
        while ((temp = (temp << 3) + (temp << 1) + 9L) < numb && temp > 0)
            digNumb++;
        return digNumb;
    }

    // возведение в степень exp числа num
    public static long pow (int num, int exp) {
        long l = 1;
        for (int i = 0; i < exp; i++)
            l *= (long)num;
        return l;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long [] result = getNumbers(Long.MAX_VALUE);
        long [] result1 = getNumbers(100);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));

        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1-t0) + " ms");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");
        System.out.println("Найдено чисел: " + result.length);
    }

    /*public static long[] getNumbers(long N) {
        long sumOfPowers;
        Long[][] matrix = new Long[10][20];
        Set<Long> armstrongNumbers = new TreeSet<>();
        for(long i = 0; i < N; i++){
            if (isNotChecked(i)){
                sumOfPowers = getSumOfPowers(i, matrix);
                if (sumOfPowers == getSumOfPowers(sumOfPowers, matrix)) {
                    armstrongNumbers.add(sumOfPowers);
                }
            }
        }

        int index = 0;
        long[] result = new long[armstrongNumbers.size()];
        for (Long num : armstrongNumbers){
            result[index++] = num;
        }
        return result;
    }

    private static boolean isNotChecked(long i){
        int digits = String.valueOf(i).length();
        int lastDigit = (int) (i % 10);
        int currentDigit;
        for (int j = digits - 1; j > 0; j--){
            i /= 10;
            currentDigit = (int) (i % 10);
            if (currentDigit == 0){
                return true;
            }
            if (currentDigit > lastDigit){
                return false;
            }
            lastDigit = currentDigit;
        }
        return true;
    }

    private static long getSumOfPowers(long j, Long[][] matrix){
        long sum = 0;
        long remainder = j;
        Long power;
        int digits = String.valueOf(j).length();
        int digit;
        while (remainder != 0){
            digit = (int) (remainder % 10);
            power = matrix[digit][digits];
            if (power == null){
                power = (long) Math.pow(remainder % 10, digits);
                matrix[digit][digits] = power;
            }
            sum += power;
            remainder /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long[] result = getNumbers(100_000_000);
        for(long i : result){
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println(endTime - startTime);
    }*/

}
