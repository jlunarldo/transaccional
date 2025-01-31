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

    productCard:Product={
        id:1,
    nameProduct:"two",
    category:"three",
    priceUnit:15.00
    }
    
    isDisabled:boolean=true;
    decrementUnit():void{
        if(this.num>0){
            this.num--;
            this.checkDisabled();
        }
    }
    
    increaseUnit():void{
        this.num++;
        this.checkDisabled();
    }
    checkDisabled():void{
        this.isDisabled = this.num == 0;
    }
}