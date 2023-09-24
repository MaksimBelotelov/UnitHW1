package seminars.first.hw;

public class Product implements Comparable<Product> {
    private int cost; // Стоимость продукта
    private String title; // Название

    public Product(int cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    public Product() {
        this(0, "Название не указано");
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(this.cost, product.getCost());
    }

    @Override
    public Product clone() {
        Product newProduct = new Product();
        newProduct.title = this.title;
        newProduct.cost = this.cost;
        return newProduct;
    }

    @Override
    public String toString() {
        return "Название: " + title + "\n" +
                "Цена: " + cost + "\n";
    }
}