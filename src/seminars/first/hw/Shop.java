package seminars.first.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List products){
        this.products = products;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        ArrayList<Product> sortedProducts = new ArrayList<>();

        for(Product item : products)
                sortedProducts.add(item.clone());
        Collections.sort(sortedProducts);

        return sortedProducts;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product res = null;
        if(products.size() == 0) System.out.println("Товаров нет");
        else {
            res = products.get(0);
            for (Product item : products)
                res = (item.compareTo(res) > 0) ? item : res;
        }
        return res;
    }
}