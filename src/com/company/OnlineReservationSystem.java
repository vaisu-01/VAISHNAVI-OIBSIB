package com.company;

import java.util.Scanner;

public class OnlineReservationSystem {
    private static String loggInUserId;
    public static void main(String args[]){
        login();
        if(loggInUserId!=null){
            System.out.println("Online Reservation!");
            System.out.println(" WELCOME TO IXIGO TRAINS");
            boolean exit=false;
            while(!exit){
                System.out.println("select an option");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                Scanner scanner=new Scanner(System.in);
                int choose= scanner.nextInt();
                switch (choose){
                    case 1:
                        MakeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        exit=true;
                        break;
                    default:
                        System.out.println("invalid choice,please try again");
                        break;
                }
            }
        }
    }
    public static void login(){
        Scanner scanner=new Scanner (System.in);
       System.out.println(" enter your login credentials");
       System.out.println("enter your userId");
       String userId= scanner.nextLine();
       System.out.println("enter password");
       String password= scanner.nextLine();
       if (validateUser(userId,password)){
           loggInUserId=userId;
           System.out.println("login successful");

       }else{
           System.out.println("invalid login credentials.please try again");
       }
    }
    private static boolean validateUser(String UserId, String password){
        return true;

    }
    private static void MakeReservation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Reservation criteria:");
        System.out.println("enter passenger name");
        String passengerName= scanner.nextLine();
       System.out.println("enter passenger age");
       String Age= scanner.nextLine();
       System.out.println("PNR number");
       String PNR= scanner.nextLine();
       System.out.println("select class type");
       System.out.println("1.sleeper");
        System.out.println("2.second sleeper");
        System.out.println("3.Ac");
        System.out.println("4.Third AC");
        System.out.println("enter your choice");
        Scanner sc = new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                sleeper();
                break;
            case 2:
                secondsleeper();
            case 3:
                AC();
                break;
            case 4:
                ThirdAC();
                break;
            default:
                System.out.println("invalid choice");
                        break;

        }
        System.out.println("enter date of journey");
        String DateOfJourney=sc.nextLine();
        System.out.println(" enter source of location");
        String location=sc.nextLine();
        System.out.println("enter destination");
        String Destination=sc.nextLine();
        System.out.println("Reservation Successful");
    }
    public static void cancelReservation(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your PNR number");
        String PNR= sc.nextLine();
        System.out.println("cancellation successful ");


    }
    public static void sleeper(){
        Scanner sc=new Scanner(System.in);
        System.out.println("sleeper.");

    }
    public static void secondsleeper(){
        Scanner sc=new Scanner(System.in);
        System.out.println("second sleeper");
    }
    public static void AC(){
        Scanner sc=new Scanner(System.in);
        System.out.println("AC");
    }
    public static void ThirdAC(){
        Scanner sc=new Scanner(System.in);
        System.out.println("ThirdAC");
    }



}
