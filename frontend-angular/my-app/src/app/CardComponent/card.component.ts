import { Component } from '@angular/core';
import { Product } from '../../Product';
@Component({
  selector: 'card-component',
  templateUrl: './card.component.html',
  standalone: false,
  styleUrl: './card.component.css'
})

export class CardComponent {
    num:number=0;
    priceTotal:number=0;
    productCard:Product={
        id:1,
    nameProduct:"two",
    category:"three",
    priceUnit:15.90
    }
    
    isDisabled:boolean=true;
    decrementUnit():void{
        if(this.num>0){
            this.num--;
            this.checkDisabled();
           this.priceTotal=this.productCard.priceUnit*this.num;
        }
    }
    
    increaseUnit():void{
        this.num++;
        this.checkDisabled();
        this.priceTotal=this.productCard.priceUnit*this.num;
    }
    checkDisabled():void{
        this.isDisabled = this.num == 0;
    }

  
}