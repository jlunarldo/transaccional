import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from "../../Product";

import { ApiResponse } from "../home/ApiResponse";

@Injectable({
    providedIn:'root'
})
export class CategorieService{

    private urlAll: string = "http://localhost:9001/product/v1/getUniqueCategorie";

  constructor(private http: HttpClient) {}

  
  getAllCategorie(): Observable<ApiResponse<string>> {

    return this.http.get<ApiResponse<string>>(this.urlAll);
  }

}