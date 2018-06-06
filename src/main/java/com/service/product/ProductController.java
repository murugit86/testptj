package com.service.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ProductController {
    
    @RequestMapping("/")
    public String index() {
        return "Welcome!";
    }
    
    @GetMapping("/products")
    @ResponseBody
    public List<Product> getProducts() throws JsonParseException, JsonMappingException, IOException {
    	
    	InputStream inJson = Product.class.getResourceAsStream("/product.json");
    	List<Product> products = new ObjectMapper().readValue(inJson,  new TypeReference<List<Product>>(){});
        return products;
    }
 
    
}
