import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name, email, address, id;
    private int phone;
    List<Item> rentalItems = new ArrayList<Item>();
    List<Rental> rentals = new ArrayList<Rental>();

    Customer(String name, String email, int phone, String address, String id) {
        boolean let = false;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        if (!Item.itemsIdCheck.contains(id) && !Item.rentalsIdCheck.contains(id) && !Item.customersIdCheck.contains(id)) {
            let = false;
            this.id = id;
            Item.customersIdCheck.add(id);
        } else {
            System.out.println("This ID has already been taken");
            let = true;
        }
        while (let) {
            System.out.print("Enter another ID : ");
            Scanner input = new Scanner(System.in);
            id = input.nextLine();
            if (!Item.itemsIdCheck.contains(id) && !Item.rentalsIdCheck.contains(id) && !Item.customersIdCheck.contains(id)) {
                this.id = id;
                Item.customersIdCheck.add(id);
                let = false;
            } else {
                System.out.println("This ID has already been taken");
            }
        }
    }

    String getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    String getEmail() {
        return this.email;
    }

    int getPhone() {
        return this.phone;
    }

    String getAddress() {
        return this.address;
    }

    void getRentalItems() {
        int count = 0;
        if (rentalItems.isEmpty()) {
            System.out.println("The List is Empty!");
        } else {
            for (int i = 0; i < rentalItems.size(); i++) {
                if (rentalItems.get(i) != null) {
                    count++;
                    System.out.println(count + " " + rentalItems.get(i).getAllInformation());
                }
            }
        }
    }

    void getRentalsID() {
        int count = 0;
        if (rentals.isEmpty()) {
            System.out.println("The List is Empty!");
        } else {
            for (int i = 0; i < rentals.size(); i++) {
                if (rentals.get(i) != null) {
                    count++;
                    System.out.println(count + " " + rentals.get(i).getId());
                }
            }
        }
    }

    public String getAllInformation() {
        return "Name : " + this.name + ", Phone Number : " + this.phone + ", Address : " + this.address + ", Email : " + this.email + " ,ID : " + this.id;
    }
}