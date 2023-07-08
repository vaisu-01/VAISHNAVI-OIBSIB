package vaisu;


    import java.util.Scanner;
    public class OnlineExamSystem {
        private String userID;
        private String password;
        private boolean LoggedIn;

        private int RemainingTime;
        private int no_of_questions;
        private int[]userAnswers;
        private int[]correctAnswer;
        public OnlineExamSystem(String username,String password){
            this.userID=username;
            this.password=password;
            System.out.println("you are registered successfully");
            this.LoggedIn=false;
            this.RemainingTime=10;
            this.no_of_questions=10;
            this.userAnswers=new int[no_of_questions];
            this.correctAnswer=new int[no_of_questions];
            for(int i=0;i<no_of_questions;i++){
                correctAnswer[i]=(int)Math.round(Math.random());
            }
        }
        public void login(){
            System.out.println("first login and then given exam ");
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserID:");
            String inputUserId=scanner.nextLine();
            System.out.print("password:");
            String inputPassword=scanner.nextLine();
            if(inputUserId.equals(userID)&&inputPassword.equals(password)){
                LoggedIn=true;
                System.out.println("login successful");
            }else{
                System.out.println("login failed");
            }

        }
        public void logout(){
            LoggedIn=false;
            System.out.println("logout successful");

        }
        public void startExam(){
            if(!LoggedIn){
                System.out.println("please login first");
                return;
            }
            Scanner scanner =new Scanner (System.in);
            System.out.println("you have" + RemainingTime + "minute to complete your exam");
            for(int i=0;i<no_of_questions;i++){
                System.out.println("Questions" +(i+1) +":");
                System.out.println("1. option 1");
                System.out.println("2. option 2");
                System.out.println("3. option 3");
                System.out.println("4. option 4");
                System.out.println("your answer(option 1, option 2,option 3,option 4,option 5):");
                int answer= scanner.nextInt();
                userAnswers[i]=answer;
            }
            System.out.println("would you like to submit?\n1:Yes\n2:No");
            int n=scanner .nextInt();
            if (n==1){
                submitExam();

            }
            else{
                try{
                    Thread.sleep(RemainingTime*10*1000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                    submitExam();
                }

            }
        }
        public void submitExam(){
            if(!LoggedIn){
                System.out.println("please login first");
                return;

            }
            int score=0;
            for(int i=0;i<no_of_questions;i++){
                if (userAnswers[i]==correctAnswer[i]){
                    score++;

                }

            }
            System.out.println(" your score is "+ score + " out of " + no_of_questions +" ");
            if(score<=5){
                System.out.println("you are fail");
            }else {
                System.out.println("you are pass");
            }
            logout();

        }
        public static void main(String args[]){
            Scanner sc=new Scanner (System.in);
            System.out.println("enter your userId");
            String YourName=sc.nextLine();
            System.out.println("password");
            String password=sc.nextLine();
            OnlineExamSystem examSystem=new OnlineExamSystem(YourName,password);
            examSystem.login();
            examSystem.startExam();
        }

    }

