package retailhub;




public class Product{
    // Product's ID
    private int productId;
    // Product's Name
    private String name;
    // Product's Categories
    private String category;
    // Product's Price
    private double price;
    // Product's Stock.
    private int stock;
    // Supplier
    private Supplier supplier;

    /**
     * Constructor for the Product class.
     * @param productId
     * @param name
     * @param category
     * @param price
     * @param stock
     */
    public Product(int productId, String name, String category, double price, int stock,Supplier supplier) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.supplier = null;
    }
    /**
     * Unknown products Constructor
     */
    public Product() {
        this(000,"unknown-name","None",0.0,0,null);
    }

    /**
     * Constructor χωρίς supplier
     */
    public Product(int productId, String name, String category, double price, int stock) {
        this(productId, name, category, price, stock, null);
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
                " Category: "+category+" Price: "+price+" (€)"+" In Stock: "+stock+ (supplier != null ? " Supplier: "+ supplier.getBrandName() : ""));
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
     * Method for returning product's price.
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method for setting the product's price.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
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
}
