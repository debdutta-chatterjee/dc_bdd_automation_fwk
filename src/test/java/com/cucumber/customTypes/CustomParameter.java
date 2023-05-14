package com.cucumber.customTypes;

import com.pojo.objects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameter
{
    @ParameterType(".*")
    public Product product(String name){

        return new Product(name.replace("\"", ""),0);
    }
}
