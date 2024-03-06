package LLD.BookMyShow;

//Singleton Pattern
//This is central component for managing & coordinating the behavior of different elevators.
//It oversees the performance of all elevators.
public class BookMyShowController {

    private static BookMyShowController bookMyShowController;
    private BookMyShowController(){

    }
    public static BookMyShowController setInstance(){
        if(bookMyShowController==null){
            synchronized (BookMyShowController.class){
                if(bookMyShowController==null){
                    bookMyShowController=new BookMyShowController();
                }
            }
        }
        return bookMyShowController;
    }
}
