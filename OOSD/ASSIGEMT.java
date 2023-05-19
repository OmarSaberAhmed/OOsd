import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ASSIGEMT {

	public static void main(String[] args) {

		   CoffeeShop teshaCoffeeShop = new CoffeeShop("Tesha's Coffee Shop");

	        // Create menu items
	        MenuItem item1 = new MenuItem("Cinnamon Roll", "food", 1.99);
	        MenuItem item2 = new MenuItem("Iced Coffee", "drink", 0.99);
	        MenuItem item3 = new MenuItem("Tuna Sandwich", "food", 4.99);
	        MenuItem item4 = new MenuItem("Lemonade", "drink", 2.49);
	        MenuItem item5 = new MenuItem("Ham and Cheese Sandwich", "food", 3.99);
	        MenuItem item6 = new MenuItem("Bacon and Egg Sandwich", "food", 4.49);
	        MenuItem item7 = new MenuItem("Orange Juice", "drink", 1.99);
	        MenuItem item8 = new MenuItem("Cranberry Juice", "drink", 2.99);

	        // Add menu items to the coffee shop's menu
	        teshaCoffeeShop.addToMenu(item1);
	        teshaCoffeeShop.addToMenu(item2);
	        teshaCoffeeShop.addToMenu(item3);
	        teshaCoffeeShop.addToMenu(item4);
	        teshaCoffeeShop.addToMenu(item5);
	        teshaCoffeeShop.addToMenu(item6);
	        teshaCoffeeShop.addToMenu(item7);
	        teshaCoffeeShop.addToMenu(item8);

	        // Test cases
	        System.out.println("Test Case 1:");
	        System.out.println("Adding order: hot cocoa");
	        teshaCoffeeShop.addOrder("hot cocoa");
	        System.out.println();

	        System.out.println("Test Case 2:");
	        System.out.println("Adding order: iced tea");
	        teshaCoffeeShop.addOrder("iced tea");
	        System.out.println();

	        System.out.println("Test Case 3:");
	        System.out.println("Adding order: cinnamon roll");
	        teshaCoffeeShop.addOrder("cinnamon roll");
	        System.out.println();

	        System.out.println("Test Case 4:");
	        System.out.println("Adding order: iced coffee");
	        teshaCoffeeShop.addOrder("iced coffee");
	        System.out.println();

	        System.out.println("Current orders: " + teshaCoffeeShop.listOrders());
	        System.out.println();

	        System.out.println("Due amount: $" + teshaCoffeeShop.dueAmount());
	        System.out.println();

	        System.out.println("Fulfilling orders:");
	        System.out.println(teshaCoffeeShop.fulfillOrder());
	        System.out.println(teshaCoffeeShop.fulfillOrder());
	        System.out.println(teshaCoffeeShop.fulfillOrder());
	        System.out.println();

	        System.out.println("Current orders: " + teshaCoffeeShop.listOrders());
	        System.out.println();

	        System.out.println("Due amount: $" + teshaCoffeeShop.dueAmount());
	        System.out.println();

	        System.out.println("Cheapest item: " + teshaCoffeeShop.cheapestItem());
	        System.out.println();

	        System.out.println("Drink items only: " + teshaCoffeeShop.drinksOnly());
	        System.out.println();

	        System.out.println("Food items only: " + teshaCoffeeShop.foodOnly());
	    }
    
}

  class MenuItem {
    private String itemName;
    private String type;
    private double price;

    public MenuItem(String itemName, String type, double price) {
        this.itemName = itemName;
        setType(type);
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("food") || type.equalsIgnoreCase("drink")) {
            this.type = type.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid type. Only 'food' or 'drink' are allowed.");
        }
    }

    public double getPrice() {
        return price;
    }

	public String getItemType() {
		// TODO Auto-generated method stub
		return null;
	}
}

class CoffeeShop {
    private String name;
    private List<MenuItem> menu;
    private List<String> orders;

    public CoffeeShop(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addToMenu(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void addOrder(String itemName) {
        boolean itemExistsInMenu = false;

        for (MenuItem item : menu) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemExistsInMenu = true;
                break;
            }
        }

        if (itemExistsInMenu) {
            orders.add(itemName);
        } else {
            System.out.println("This item is currently unavailable");
        }
    }

    public String fulfillOrder() {
        if (!orders.isEmpty()) {
            String item = orders.remove(0);
            return "The item '" + item + "' is ready";
        } else {
            return "All orders have been fulfilled";
        }
    }

    public List<String> listOrders() {
        return new ArrayList<>(orders);
    }

    public double dueAmount() {
        double totalAmount = 0.0;

        for (String itemName : orders) {
            for (MenuItem item : menu) {
                if (item.getItemName().equalsIgnoreCase(itemName)) {
                    totalAmount += item.getPrice();
                    break;
                }
            }
        }

        return totalAmount;
    }

    public String cheapestItem() {
        if (menu.isEmpty()) {
            return null;
        }

        MenuItem cheapestItem = menu.get(0);

        for (MenuItem item : menu) {
            if (item.getPrice() < cheapestItem.getPrice()) {
                cheapestItem = item;
            }
        }

        return cheapestItem.getItemName();
    }

    public List<String> drinksOnly() {
        List<String> drinks = new ArrayList<>();

        for (MenuItem item : menu) {
            if (item.getItemType().equalsIgnoreCase("drink")) {
                drinks.add(item.getItemName());
            }
        }

        return drinks;
    }

    public List<String> foodOnly() {
        List<String> foodItems = new ArrayList<>();

        for (MenuItem item : menu) {
            if (item.getItemType().equalsIgnoreCase("food")) {
                foodItems.add(item.getItemName());
            }
        }

        return foodItems;
    }
}
