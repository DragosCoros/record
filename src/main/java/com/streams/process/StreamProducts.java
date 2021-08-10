package com.streams.process;

import com.streams.dto.Product;
import com.streams.dto.ProductTestCategory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static com.streams.helper.StaticHelperStream.maxList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamProducts {

    public static void main(String[] args) {

        List<Product> list = buildListProducts();
        List<ProductTestCategory> productTestCategoryList = buildListProductTestCategories();

        Map<String, List<Product>> collect = list.stream()
                .collect(groupingBy(o -> o.getCategory()));

        collect.entrySet().forEach(entry -> {
            System.out.println("Product key : " + entry.getKey() + " value : " + entry.getValue());
        });

        System.out.println("|------------------------------------------------------------------------------------|");
        Map<String, Long> collectCount = list.stream()
                .collect(groupingBy(Product::getCategory, counting()));

        collectCount.entrySet().forEach(entry -> {
            System.out.println("Product key : " + entry.getKey() + " value : " + entry.getValue());
        });

        System.out.println("|----------------------Products List with max Price----------------------------------|");
/*
        Map<String, List<Product>> collectProduct = list.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice)))
                );
*/

        Map<String, List<Product>> collectProduct = list.stream()
                .collect(
                        groupingBy(
                                Product::getCategory,
                                maxList(Comparator.comparing(Product::getPrice))
                        )
                );

        collectProduct.entrySet().forEach(entry -> {
            System.out.println("Product key : " + entry.getKey() + " value : " + entry.getValue());
        });

        System.out.println("|----------------------test key sort----------------------------------|");
        Map<Long, List<ProductTestCategory>> collectLongListMap = productTestCategoryList.stream()
                .collect(
                        groupingBy(
                                ProductTestCategory::getCategory,
                                maxList(Comparator.comparing(ProductTestCategory::getPrice))
                        )
                );

        collectLongListMap.entrySet().forEach(entry -> {
            System.out.println("ProductTestCategory key : " + entry.getKey() + " value : " + entry.getValue());
        });

    }


    private static List<Product> buildListProducts() {

        List<Product> productList = new ArrayList<>();
        productList.add(createProduct("name1", "category1", 90.00));
        productList.add(createProduct("name2", "category1", 100.00));
        productList.add(createProduct("name3", "category1", 100.00));
        productList.add(createProduct("name4", "category2", 120.00));
        productList.add(createProduct("name5", "category2", 130.00));
        productList.add(createProduct("name6", "category1", 100.00));
        productList.add(createProduct("name7", "category2", 140.00));
        productList.add(createProduct("name8", "category3", 100.00));
        productList.add(createProduct("name9", "category2", 140.00));

        return productList;
    }

    private static List<ProductTestCategory> buildListProductTestCategories() {

        List<ProductTestCategory> productTestCategoryList = new ArrayList<>();
        productTestCategoryList.add(createProductTestCategory("name1", 1L, 90.00));
        productTestCategoryList.add(createProductTestCategory("name2", 1L, 100.00));
        productTestCategoryList.add(createProductTestCategory("name3", 1L, 100.00));
        productTestCategoryList.add(createProductTestCategory("name4", 2L, 120.00));
        productTestCategoryList.add(createProductTestCategory("name5", 2L, 130.00));
        productTestCategoryList.add(createProductTestCategory("name6", 1L, 100.00));
        productTestCategoryList.add(createProductTestCategory("name7", 2L, 140.00));
        productTestCategoryList.add(createProductTestCategory("name8", 3L, 100.00));
        productTestCategoryList.add(createProductTestCategory("name9", 2L, 140.00));

        return productTestCategoryList;
    }

    private static Product createProduct(String name, String category, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        return product;
    }

    private static ProductTestCategory createProductTestCategory(String name, Long category, Double price) {
            ProductTestCategory productTestCategory = new ProductTestCategory();
            productTestCategory.setName(name);
            productTestCategory.setCategory(category);
            productTestCategory.setPrice(price);
            return productTestCategory;
        }


}
