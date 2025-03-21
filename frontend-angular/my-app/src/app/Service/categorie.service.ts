import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from "../../Product";

import { ApiResponse } from "../home/ApiResponse";

@Injectable({
    providedIn:'root'
})
export class CategorieService{

    constructor(private http: HttpClient,){}
    
    private urlAll:string="http://localhost:9001/product/v1/getUniqueCategorie"
    getAllCategorie():Observable<ApiResponse<string>>{
        console.log(this.http.get<ApiResponse<string>>(this.urlAll));
        console.log("estoy entrando a ala url");
        return this.http.get<ApiResponse<string>>(this.urlAll);
    }

}