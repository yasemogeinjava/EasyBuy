package com.easybuy.entity;

import java.util.List;

public class Data {
    List<ProductCategory> categoryList1;
    List<ProductCategory> categoryList2;
    List<ProductCategory> categoryList3;

    public Data() {
    }

    public Data(List<ProductCategory> categoryList1, List<ProductCategory> categoryList2, List<ProductCategory> categoryList3) {
        this.categoryList1 = categoryList1;
        this.categoryList2 = categoryList2;
        this.categoryList3 = categoryList3;
    }

    public List<ProductCategory> getCategoryList1() {
        return categoryList1;
    }

    public void setCategoryList1(List<ProductCategory> categoryList1) {
        this.categoryList1 = categoryList1;
    }

    public List<ProductCategory> getCategoryList2() {
        return categoryList2;
    }

    public void setCategoryList2(List<ProductCategory> categoryList2) {
        this.categoryList2 = categoryList2;
    }

    public List<ProductCategory> getCategoryList3() {
        return categoryList3;
    }

    public void setCategoryList3(List<ProductCategory> categoryList3) {
        this.categoryList3 = categoryList3;
    }
}
