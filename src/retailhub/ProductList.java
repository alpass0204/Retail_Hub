package retailhub;
import java.util.ArrayList;
import java.util.Iterator;


public class ProductList {
    private ArrayList<Product> products;

    /**
     * Constructor for list of products.
     */
    public ProductList(){
        this.products = new ArrayList<Product>();
    }

    /**
     * Add product to the list.
     */
    public void addProduct(Product Product){
        products.add(Product);
    }

    /**
     * Method for removing products from the list!
     * @param id
     */
    public void removeProduct(int id){
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();
            if(product.getProductId() == id){
                System.out.println("The product has been removed Successfully!");
                iterator.remove();
                break;
            }
            else {
                System.out.println("Product ID is not found!");
            }
        }
    }

    /**
     * Method for searching product in the list through ID.
     * @param id
     * @return
     */
    public Product searchProducts(int id){
        if(id<=0){
            System.out.println("Give a valid ID number");
            return null;
        }
        for(Product product : products){
            if(product.getProductId() == id){
                product.printProduct();
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    /**
     * Method for printing the list of products.
     */
    public void printList(){
        for (Product product : products){
            product.printProduct();
        }
    }

    /**
     * Method for updating fields of products.
     * @param id
     * @param newName
     * @param newCategory
     * @param Price
     * @param newStock
     */
    public void updateList(int id, String newName, String newCategory, double Price, int newStock){
        for(Product product : products){
            if(product.getProductId() == id){
                product.setName(newName);
                product.setCategory(newCategory);
                product.setPrice(Price); //πρεπει να αλλάζει εδώ? αποφυγή λάθους τυπογράφησης.
                product.setStock(newStock); //πρεπει να αλλάζει εδώ? αποφυγή λάθους τυπογράφησης.
                System.out.println("The Product has been Updated Successfully!");
            }
            else {
                System.out.println("Product not found!");
            }
        }
    }

    /**
     * Method for creating a product and adding it directly to the product list.
     * @param productId
     * @param name
     * @param category
     * @param price
     * @param stock
     */
    public void createProduct(int productId, String name, String category, double price, int stock) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                System.out.println("Product id " + productId + " is already used. Please enter a valid productId.");
            }
            else{
                Product newProduct = new Product(productId, name, category, price, stock);
                products.add(newProduct);
                System.out.println("The product has been added Successfully.");
            }

        }
    }
}
