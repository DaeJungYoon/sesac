package com.example.springprac.myshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {
    // product를 데이터로서 저장을 하여 사용하고 싶어서
    // Product를 하나에 list에 저장을 함
    List<Product> products = new ArrayList<>();
    // product 생성할 때 id를 생성하기 위해
    private Long id = 0L;

    // home
    // 처음 페이지 에러메세지 나오는 것이 불편해서
    @GetMapping("/")
    public String homePage(){
        return "HOME SWEET HOME";
    }

    // 새로운 product Create
    // 필요한 것 product / 내용 / url
    @GetMapping("/products/create")
    public Product createProduct(){
        // 새로운 product 생성
        Product product =new Product(++id, "상품명", 22200);

        // 생성한 product 를 List products 에 추가
        products.add(product);

        // 생성한 product 반환
        return product;
    }

    // 전체 product read
    // get / Products
    @GetMapping("/products")
    // product 들을 가져와야 하는데
    // product 들은 List products에 저장되어 있음
    public List<Product> readProducts(){
    // products를 반환하는데
    // 타입은 List<Product>
        return products;
    }
    // 특정 product read
    // 필요한 것  products/ product / id
    @GetMapping("/products/{id}")
    // url(pathparameter)을 받아 id를 받기위해
    public Product readProduct(@PathVariable Long id){
        // List products에 저장된 Product클래스의 product 접근
        for (Product product : products){
            // product의 id를 가져와서 매개변수로 받은 id가 같으면
            if(product.getId().equals(id)){
                //product 반환
                return product;
            }
        }
        return null;
    }

    //특정 product update
    //필요한 것 변경 내용 / id / url
    @GetMapping("/products/{id}/update")
    public Product updateProducts(@PathVariable("id") Long id){
        for(Product product : products){
            if(product.getId().equals(id)){
                // product의 setName 메소드를 이용하여 "상품명2"로 변경
                product.setName("상품명2");
                // product의 setPrice 메소드를 이용하여 11000"로 변경
                product.setPrice(11000);
                // 하고 product를 리턴
                return product;
            }
        }
        return null;
    }


    // 특정 product delete
    // 필요한 거 id / url
    @GetMapping("products/{id}/delete")
    public Product deleteProduct(@PathVariable("id") Long id) {
        Product removedProduct = null;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                removedProduct = product;
                break;
            }
        }
        products.remove(removedProduct);
        return null;
    }
}
