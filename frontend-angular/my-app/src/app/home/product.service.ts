import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from "../../Product";
import { map } from 'rxjs/operators';
import { tap } from 'rxjs/operators';
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
    
}