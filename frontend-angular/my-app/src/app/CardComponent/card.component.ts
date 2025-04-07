import { Component, input, Input } from '@angular/core';
import { Product } from '../../Product';
import { ProductService } from '../home/product.service';
import { ChangeDetectorRef } from '@angular/core';

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
   
    priceTotal:number=1;
    productCard?:Product;
    ngOnInit() {

        
      }
    constructor( private cd: ChangeDetectorRef, private productService: ProductService){
       
    }

     
    
    isDisabled:boolean=true;
    decrementUnit():void{
        if(this.num>1){
            this.num--;
            this.checkDisabled();
            
            
            //this.priceTotal = (this.productCard?.priceUnit ?? 0) * this.num;
            this.priceTotal = (this.data()?.priceUnit ?? 0) * this.num;
            
            this.cd.detectChanges();
        }
    }
    
    increaseUnit():void{
        this.num++;
        this.checkDisabled();
        this.priceTotal = (this.data()?.priceUnit ?? 0) * this.num;
       
        this.cd.detectChanges();
    }
    checkDisabled():void{
        this.isDisabled = this.num == 1;
    }

    deleteCard():void{
        console.log("Estoy eliminando este producti:" , this.data());
        let algo=this.data().id_product;
        console.log("El id de data es: ", algo)
        this.productService.deleteProduct(algo);
    }
}