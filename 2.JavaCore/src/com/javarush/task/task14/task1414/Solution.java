package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        Movie movie = null;

        while (true){
            key = reader.readLine();

                movie = MovieFactory.getMovie(key);
                if (movie == null){
                    break;
                }
                System.out.println(movie.getClass().getSimpleName());

        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            } else {
                return null;
            }

            return movie;
        }
    }

    final static String[] ALLOWED_KEYS = {"cartoon", "thriller", "soapOpera"};

    static abstract class Movie {
    }

    static class Thriller extends Movie {

    }

    static class Cartoon extends Movie {

    }

    static class SoapOpera extends Movie {
    }

}
