package com.cucumber.customTypes;

import com.pojo.objects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTable
{
    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry){
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
