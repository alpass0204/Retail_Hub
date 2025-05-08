package retailhub;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages a list of products available in the store
 * Supports adding, removing, updating, searching, printing products
 */

public class ProductList {

    private static final SecurityLayer viewList = SecurityLayer.layer1;
    private static final SecurityLayer manageList = SecurityLayer.layer2;
    private ArrayList<Product> products; // List storing all products

    /**
     * Constructor for list of products.
     */
    public ProductList() {
        this.products = new ArrayList<Product>();
    }

    /**
     * Add product to the list.
     */
    public void addProduct(Product Product) {
        products.add(Product);
    }

    /**
     * Method for removing products from the list!
     *
     * @param id
     */
    public void removeProduct(User performerUser, int id) throws SecurityException {
        if (!performerUser.getSecurityLevel().canManageProducts(performerUser, false))
            throw new SecurityException("Forbidden");
        if(id==0){
            throw new SecurityException("Id cant be null");
        }
        Iterator<Product> iterator = products.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (product.getProductId() == id) {
                System.out.println("The product has been removed Successfully!");
                iterator.remove();
                found = true;
                break;
            }}
            if(!found){
                System.out.println("Product ID is not found!");
            }
        }


    /**
     * Method for searching product in the list through ID.
     *
     * @param id the product ID to search for
     * @return the product if found, otherwise null
     */

    public Product searchProducts(User performerUser, int id) throws SecurityException {
        // Permission check
        if (!performerUser.getSecurityLevel().hasRequiredLevel(viewList)) {
            throw new SecurityException("Forbidden");
        }

        // ID sanity check
        if (id <= 0) {
            System.out.println("Give a valid ID number");
            return null;
        }

        // Search for the product in the list
        for (Product product : products) {
            if (product.getProductId() == id) {
                product.printProduct();
                System.out.println("Product with ID " + product.getProductId() + " has been found.");
                return product;
            }
        }

        System.out.println("Product not found");
        return null;
    }




    /**
         * Method for printing the list of products.
         */
        public void printList (User performerUser) throws SecurityException {
            if (!performerUser.getSecurityLevel().hasRequiredLevel(viewList))
                throw new SecurityException("Forbidden");
            for (Product product : products) {
                product.printProduct();
            }
        }

        /**
         * Method for updating a product's name, category, price, and stock
         * @param id ID of the product to be updated
         * @param newName New product name
         * @param newCategory New product category
         * @param newPurchasePrice New purchase price
         * @param newSellPrice New sell price
         * @param newStock New stock quantity
         * @param supplier Supplier
         * @param newNotificationStock New stock notification
         */
        //TODO --SUPPLIER NEEDS TO BE UPDATED WHEN PRODUCT IS UPDATED--
        public void updateProduct (User performerUser,int id, String newName, String newCategory,
        double newPurchasePrice,
        double newSellPrice, int newStock, Supplier supplier,int newNotificationStock) throws SecurityException {
            if (!performerUser.getSecurityLevel().canManageProducts(performerUser, false))
                throw new SecurityException("Forbidden");

            boolean found = false;
            for (Product product : products) {
                if (product.getProductId() == id) {
                    product.setName(newName);
                    product.setCategory(newCategory);
                    product.setPurchasePrice(newPurchasePrice);
                    product.setSellPrice(newSellPrice);
                    product.setStock(newStock);
                    product.setNotificationStock(newNotificationStock);
                    System.out.println("The Product has been Updated Successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Product not found");
            }
        }

        /**
         * Method for creating a product and adding it directly to the product list.
         * Makes sure product is unique
         * @param name Product name
         * @param category Product category
         * @param purchasePrice Purchase price
         * @param sellPrice Sell price
         * @param stock Initial stock
         * @param supplier Supplier
         * @param notificationStock Stock notification
         */
        public void createProduct (User performerUser, String name, String category,double purchasePrice,
        double sellPrice, int stock, Supplier supplier,int notificationStock) throws SecurityException {
            if (!performerUser.getSecurityLevel().canManageProducts(performerUser, false)) {
                throw new SecurityException("Forbidden.");
            }
            if (name.trim().isEmpty()) {
                throw new SecurityException("Name can't be empty.");
            }
            if (sellPrice < 0 && stock < 1) {
                throw new SecurityException("Price or stock value error");
            }
            if (purchasePrice < 0 && stock < 1) {
                throw new SecurityException("Price or stock value error");
            }
            Product newProduct = new Product(name, category, purchasePrice, sellPrice, stock, supplier, notificationStock);
            products.add(newProduct);
            System.out.println("The product has been added Successfully.");

        }
    }
