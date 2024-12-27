package com.example.springprac.myshop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v4/products")
public class ProductApi4 {
    // product를 데이터로서 저장을 하여 사용하고 싶어서
    // Product를 하나에 list에 저장을 함
    List<Product> products = new ArrayList<>();
    // product 생성할 때 id를 생성하기 위해
    private Long id = 0L;
    {
        products.add(new Product(++id,"prime products",2123123));
    }
    // home
    // 처음 페이지 에러메세지 나오는 것이 불편해서
    //    @GetMapping("/")
    //    public String homePage(){
    //        return "HOME SWEET HOME";
    //    }

    // 새로운 product Create
    // 필요한 것 product / 내용 / url
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product newProduct){
        // 새로운 product 생성

        String name = newProduct.getName();
        int price = newProduct.getPrice();
        if (name == null || name.isBlank()){
            throw new RuntimeException("상품명 name을 입력하세요");
        }
        if(price <= 0){
            throw new IllegalArgumentException("가격 price를 입력해주세요");
        }

        Product product =new Product(++id, name, price);

        // 생성한 product 를 List products 에 추가
        products.add(product);

        // 생성한 product 반환
        return product;
    }

    // 전체 product read
    // get / Products
    @GetMapping
    // product 들을 가져와야 하는데
    // product 들은 List products에 저장되어 있음
    public List<Product> readProducts(){
    // products를 반환하는데
    // 타입은 List<Product>
        return products;
    }
    // 특정 product read
    // 필요한 것  products/ product / id
    @GetMapping("/{id}")
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
    @PutMapping("/{id}")
//    postman으로 수정한 상품명과 가격을 받아서 사용하고 싶음
    public Product updateProducts(@PathVariable Long id, @RequestBody Product updatedProduct){
        String name = updatedProduct.getName();
        int price = updatedProduct.getPrice();
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("상품명 name을 입력해주세요");
        }
        if(price <= 0){
            throw new IllegalArgumentException("가격 price를 0보다 크게 입력해주세요");
        }
        for(Product product : products){
            if(product.getId().equals(id)){
                product.setName(name);
                product.setPrice(price);
                return product;
            }
        }
        return null;
    }


    // 특정 product delete
    // 필요한 거 id / url
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product deleteProduct(@PathVariable Long id) {
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
