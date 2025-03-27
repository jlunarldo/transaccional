import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from "../../Product";

import { ApiResponse } from "./ApiResponse";

@Injectable({
    providedIn:'root'
})
export class ProductService{

    private url:string="http://localhost:9001/product/v1/getProduct/35";
    constructor(private http: HttpClient,){}
    getProduct(): Observable<ApiResponse<Product>> {
        return this.http.get<ApiResponse<Product>>(this.url);
    }
    
    private urlAll:string="http://localhost:9001/product/v1/getAllProduct"
    getAllProduct():Observable<ApiResponse<Product>>{
        //console.log(this.http.get<ApiResponse<Product>>(this.urlAll));
       
        return this.http.get<ApiResponse<Product>>(this.urlAll);
    }
    
    private urlCategorie:string= "http://localhost:9001/product/v1/product/"
    private urlCategorie2:string= "http://localhost:9001/product/v1/product/"
    getProductCategories(categorie:string):Observable<ApiResponse<Product>>{
        
       
        //%this.urlCategorie=this.urlCategorie2;
        //this.urlCategorie+=categorie;
        console.log(categorie);
        console.log(`${this.urlCategorie}${encodeURIComponent(categorie)}`);
        return this.http.get<ApiResponse<Product>>(`${this.urlCategorie}${encodeURIComponent(categorie)}`);
    }

    getCategorieProduct(categorie:string):Observable<ApiResponse<Product>>{
        console.log(categorie); 
        if(categorie==""||categorie=="Todos")
           
            return this.getAllProduct();
        
        else
            return  this.getProductCategories(categorie);

    }
}