package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidEmail() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negEmail.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidPassword() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negPassword.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> registrationPositive() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/userData.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginWithInvalidEmail() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/invalidEmail.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginWithInvalidPassword() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/invalidPassword.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginPositive() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/userData.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> booksName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/booksName.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> price() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/price.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

}
