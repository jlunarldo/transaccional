import { Component } from '@angular/core';
import { Product } from '../../Product';
import { ProductService } from '../home/product.service';
@Component({
  selector: 'card-component',
  templateUrl: './card.component.html',
  standalone: false,
  styleUrl: './card.component.css'
})

export class CardComponent {
    num:number=1;
    priceTotal:number=0;
   
    
    
    productCard?:Product;
    ngOnInit() {
       
        this.getProduct();
      }
    constructor(public productService: ProductService){
       
    }

    getProduct(): void {
        this.productService.getProduct().subscribe(response => {
            this.productCard = response.object;
            //this.priceTotal = this.productCard.priceUnit * this.num;
        });
    }
    
    
    
    

    
    isDisabled:boolean=true;
    decrementUnit():void{
        if(this.num>1){
            this.num--;
            this.checkDisabled();
            this.priceTotal = (this.productCard?.priceUnit ?? 0) * this.num;
        }
    }
    
    increaseUnit():void{
        this.num++;
        this.checkDisabled();
        this.priceTotal = (this.productCard?.priceUnit ?? 0) * this.num;
    }
    checkDisabled():void{
        this.isDisabled = this.num == 1;
    }

  
}