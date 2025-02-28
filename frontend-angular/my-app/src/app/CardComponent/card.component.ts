import { Component, input, Input } from '@angular/core';
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
    data =input.required<Product>()
    // @Input() data!: Product;
   
    priceTotal:number=0;
    productCard?:Product;
    ngOnInit() {

        
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
            
            
            //this.priceTotal = (this.productCard?.priceUnit ?? 0) * this.num;
            this.priceTotal = (this.data()?.priceUnit ?? 0) * this.num;
            console.log("acaban de actualizar el precio:"+this.priceTotal );
        }
    }
    
    increaseUnit():void{
        this.num++;
        this.checkDisabled();
        this.priceTotal = (this.data()?.priceUnit ?? 0) * this.num;
        console.log("acaban de actualizar el precio:"+this.priceTotal );
    }
    checkDisabled():void{
        this.isDisabled = this.num == 1;
    }

  
}