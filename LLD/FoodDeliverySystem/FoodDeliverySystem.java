package LLD.FoodDeliverySystem;

import LLD.WhatAppMessenger.Message;
import LLD.WhatAppMessenger.NotificationObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FoodDeliverySystem {
    List <Restaurant> restaurants;
    User user;
    static FoodDeliverySystem foodDeliverySystem;

    private FoodDeliverySystem() {
        restaurants=new ArrayList<>();
    }
    public static FoodDeliverySystem getInstance(){
        if(foodDeliverySystem==null){
            synchronized (FoodDeliverySystem.class){
                if(foodDeliverySystem==null)
                    foodDeliverySystem=new FoodDeliverySystem();
            }
        }
        return foodDeliverySystem;
    }

    void addRestaurants(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    void removeRestaurant(Restaurant restaurant){
        restaurants.remove(restaurant);
    }

    void registerUser(User user){
        this.user=user;
    }


}
interface OrderNotificationObservable{
    void register(User user);
    void unRegister(User user);
    void notifyStatus();
}
class OrderTracker implements OrderNotificationObservable {

    @Override
    public void register(User user) {

    }

    @Override
    public void unRegister(User user) {

    }

    @Override
    public void notifyStatus() {

    }
}
interface NotificationObserver{
    void update(Order order);
}
class User implements NotificationObserver{
    UUID userId;
    String userName;
    String address;
    String phoneNum;
    String email;
    List<Order> orders;

    public User(String userName, String address, String phoneNum, String email) {
        this.userId=UUID.randomUUID();
        this.userName=userName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
        orders = new ArrayList<>();
    }

    @Override
    public void update(Order order) {
        System.out.println("Order Status="+order.getOrderStatus());
    }
}
class Restaurant{
    UUID restaurantId;
    String restaurantName;
    String address;
    String phoneNum;
    Cuisine cuisine;
    List<Item> items;
    Rating starRating;
    List<Order> orders;

    public Restaurant(String restaurantName, String address, String phoneNum, Cuisine cuisine, Rating starRating) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.cuisine = cuisine;
        this.starRating = starRating;
        items=new ArrayList<>();
        orders=new ArrayList<>();
    }

    void addItem(Item item){
        items.add(item);
    }
    void removeItem(Item item){
        items.remove(item);
    }
}
enum Rating{
    ONE,TWO,THREE,FOUR,FIVE;
}
enum Cuisine{
    INDIAN,CHINESE,SOUTHINDIAN;
}
class Item{
    UUID itemId;
    String itemName;
    double price;
    ItemType itemType;

    public Item(String itemName, double price, ItemType itemType) {
        itemId=UUID.randomUUID();
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }
}
enum ItemType{
    VEG, NONVEG;
}

class Order{
    UUID orderId;
    Restaurant restaurant;
    User user;
    Map<Item, Integer> itemsQuantityMap;
    String deliveryAddress;
    String paymentMethod;
    OrderStatus orderStatus;

    public Order(User user,Map<Item, Integer> items, String deliveryAddress, String paymentMethod) {
        this.orderId=UUID.randomUUID();
        this.user = user;
        this.itemsQuantityMap = items;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus=OrderStatus.RECIEVED;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}

enum OrderStatus{
    RECIEVED,COOKING ,ONTHEWAY, DELIVERED;
}
class Client{
    public static void main(String []args){
        //Create instance for app
        FoodDeliverySystem foodDeliverySystem=FoodDeliverySystem.getInstance();
        //Add Restaurants
        Restaurant r1=new Restaurant("Oh Calcutta","NehruPlace, Kalkaji","82681739",Cuisine.INDIAN,Rating.THREE);
        Restaurant r2=new Restaurant("Mainland China","NehruPlace, Kalkaji","87981739",Cuisine.CHINESE,Rating.FOUR);
        //Add items to restaurants
        Item item1 = new Item("Chicken Curry",500,ItemType.NONVEG);
        Item item2 = new Item("Rice",500,ItemType.VEG);
        r1.addItem(item1);
        r1.addItem(item2);

        Item item3 = new Item("Noodles",500,ItemType.VEG);
        Item item4 = new Item("Dimsum",500,ItemType.VEG);
        r2.addItem(item3);
        r2.addItem(item4);

        //View List of Restaurants
        //View List of Items

        User user=new User("Shreya","NehruPlace, Kalkaji","979797","xyz@gmail.com");
       // Order order=new Order()

        foodDeliverySystem.registerUser(user);




    }
}
