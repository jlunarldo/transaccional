import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { catchError, Observable, tap, throwError } from "rxjs";
import { Product } from "../../Product";

import { ApiResponse } from "./ApiResponse";
import { ProductRequest } from "../add-form/ProductRequest";


@Injectable({
    providedIn:'root'
})
export class ProductService{

   

    private url: string = "http://localhost:9001/product/v1/getProduct/35";
    constructor(private http: HttpClient) {}

    getProduct(): Observable<ApiResponse<Product>> {
        return this.http.get<ApiResponse<Product>>(this.url);
    }

    private urlAll: string = "http://localhost:9001/product/v1/getAllProduct";
    getAllProduct(): Observable<ApiResponse<Product>> {
        return this.http.get<ApiResponse<Product>>(this.urlAll);
    }

    private urlCategorie: string = "http://localhost:9001/product/v1/product/";
    getProductCategories(categorie: string): Observable<ApiResponse<Product>> {
       
        return this.http.get<ApiResponse<Product>>(`${this.urlCategorie}${encodeURIComponent(categorie)}`);
    }

    getCategorieProduct(categorie: string): Observable<ApiResponse<Product>> {
        console.log(categorie); 
        if (categorie === "" || categorie === "Todos") {
            return this.getAllProduct();
        } else {
            return this.getProductCategories(categorie);
        }
    }

    private urlPost: string = "http://localhost:9001/product/v1/create";
    saveProduct(productDTO: ProductRequest): void {

        
        this.http.post<ProductRequest>(
            this.urlPost, 
            productDTO, 
            { headers: { 'Content-Type': 'application/json' } }
        ).subscribe({
            next: (response) => console.log("Producto guardado con éxito:", response),
            error: (error) => console.error("Error al guardar el producto:", error)
        });
    }

    
    
} 