package seminars.first.hw;

import seminars.first.model.Calculator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(120, "Яблоки"));
        products.add(new Product(200, "Помидоры"));
        products.add(new Product(50, "Вода"));
        products.add(new Product(90, "Хлеб"));

        Shop myShop = new Shop(products);

        System.out.println("Отсортированный по цене список: ");
        System.out.println(myShop.getSortedListProducts());
        System.out.println("Самый дорогой продукт: ");
        System.out.println(myShop.getMostExpensiveProduct());

        // Тесты:

        //1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
        assertThat(myShop.getProducts().size()).isEqualTo(4);

        ArrayList<String> names = new ArrayList<>();
        for (Product item : myShop.getProducts()) {
            names.add(item.getTitle());
            assertThat(item.getTitle()).isIn("Яблоки", "Помидоры", "Вода", "Хлеб");
        }
        assertThat(names).doesNotHaveDuplicates();

        // 2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
        assertThat(myShop.getMostExpensiveProduct())
                .isEqualToComparingFieldByField(new Product(200, "Помидоры"));


        // 3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
        List<Product> sortedList = myShop.getSortedListProducts();
        for (int i = 0; i < myShop.getProducts().size() - 1; i++) {
            assertThat(sortedList.get(i).compareTo(sortedList.get(i + 1)))
                   .isLessThanOrEqualTo(0);
        }
    }
}




