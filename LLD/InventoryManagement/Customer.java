package LLD.InventoryManagement;

import java.util.UUID;

class Customer {
    UUID customerId;
    String customerName;
    String address;
    String email;
    String phoneNum;

    public Customer(UUID customerId, String customerName, String address, String email, String phoneNum) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    //Getters & Setters
}
