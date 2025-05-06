package retailhub;

/**
 * Represents a product available in the store
 * Includes all necessary product details and stock
 */

public class Product{
    // Product's ID
    private int productId;
    // Product's Name
    private String name;
    // Product's Categories
    private String category;
    // Product's Purchase Price
    private double purchasePrice;
    // Product's Sell Price
    private double sellPrice;
    // Product's Stock.
    private int stock;
    // Supplier
    private Supplier supplier;
    private int notificationStock;

    /**
     * Constructor for the Product class.
     * @param productId
     * @param name
     * @param category
     * @param sellPrice
     * @param stock
     */
    public Product(int productId, String name, String category, double purchasePrice, double sellPrice, int stock,Supplier supplier,int notificationStock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.supplier = supplier;
        this.notificationStock = notificationStock;
    }
    /**
     * Unknown products Constructor
     */
    public Product() {
        this(000,"unknown-name","None",0.0,0.0,0,null, 0);
    }

    /**
     * Constructor without supplier
     */
    public Product(int productId, String name, String category, double purchasePrice, double sellPrice, int stock) {
        this(productId, name, category, purchasePrice, sellPrice, stock, null, 0);
    }
    /**
     * 3rd Constructor for Product Class with 3 inputs
     * @param productId
     * @param name
     * @param category
     */
    public Product(int productId, String name, String category){
        this.productId = productId;
        this.name = name;
        this.category = category;
    }
    /*
     *
     */
    public void setSupplier(Supplier s){
        this.supplier = s;
    }
    /*
     *
     */
    public Supplier getSupplier(){
        return supplier;
    }


    /**
     * Prints out information about specified product.
     */
    public void printProduct() {
        System.out.println("Product ID: "+productId+" Name: "+name+
                " Category: "+category+" Purchase Price: "+purchasePrice+" Sell Price: "+sellPrice+" (€)"+" In Stock: "+stock+ (supplier != null ? " Supplier: "+ supplier.getBrandName() : ""));
    }

    /**
     * Methods for returning product_id.
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Method for modifying product_id.
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Method for returning product name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method for modifying product name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method for returning product category.
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method for setting product's category.
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Method for returning product's purchase price.
     * @return
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Method for setting the product's purchase price.
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Method for returning product's sell price.
     * @return
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * Method for setting the product's sell price.
     * @param sellPrice
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Method for returning product's stock.
     * @return
     */
    public int getStock() {
        return stock;
    }


    /**
     * Method for updating product's stock.
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    //increase the stock of product
    public void increaseStock(int quantity) {
        this.stock += quantity;
    }

    // Decrease the stock of the product
    public void decreaseStock(int quantity) {
        this.stock -= quantity;
        notificationForLowStock();
    }
    // Prints a warning if the current stock is below the notification limit

    public void notificationForLowStock() {
        if(this.stock < notificationStock) {
            System.out.println("Warning! Low stock in this product ID!");
        }
    }

    public void setNotificationStock(int notificationStock) {
        this.notificationStock = notificationStock;
    }

    public int getNotificationStock() {
        return notificationStock;
    }
}
