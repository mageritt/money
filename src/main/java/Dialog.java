import java.util.Scanner;

     class Dialog {

        /**
         * klase skirta bendravimui su vartotoju
         */
       private Scanner scanner = new Scanner(System.in);

         /**
          * metodas isveda zinute i ekrana
          * @param message nurodomas tekstas
          */
     void show (String message){
        System.out.println(message);
    }

    private String input (){
        return scanner.nextLine();

    }
     String inputWithMessage (String message){
        System.out.print(message);
        return input();
    }

}

