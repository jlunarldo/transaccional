import { Component, ComponentRef, inject, viewChild, ViewContainerRef } from '@angular/core';
import { Product } from '../../Product';
import { CardModule } from '../CardComponent/card.module';
import { CardComponent } from '../CardComponent/card.component';
@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  
})
export class HomeComponent {

  ngOnInit() {
       
    this.createComponent();
  }
  products: Product[] = [
    {
      id: 1,
      nameProduct: "Laptop Gamer",
      category: "Electronics",
      priceUnit: 1500,
      subCategorie: "Computers",
      flag: 1,
      cantTotal: 2,
      priceTotal: 3000
    },
    {
      id: 2,
      nameProduct: "Smartphone Pro",
      category: "Electronics",
      priceUnit: 800,
      flag: 1
    },
    {
      id: 3,
      nameProduct: "Office Chair",
      category: "Furniture",
      priceUnit: 120,
      subCategorie: "Chairs",
      flag: 0,
      cantTotal: 4,
      priceTotal: 480
    },
    {
      id: 4,
      nameProduct: "Wireless Headphones",
      category: "Accessories",
      priceUnit: 200,
      flag: 1,
      cantTotal: 3,
      priceTotal: 600
    },
    {
      id: 5,
      nameProduct: "Gaming Mouse",
      category: "Accessories",
      priceUnit: 50,
      subCategorie: "Peripherals",
      flag: 1
    }
  ];

  ref= inject(ViewContainerRef);

  container= viewChild.required('container_cards',{read:  ViewContainerRef});
  
  componentRef!: ComponentRef<CardComponent>;

  
  createComponent(){
    for (let i = 0; i < this.products.length; i++) {
      this.componentRef=this.container().createComponent(CardComponent);
      this.componentRef.setInput('data', this.products[i]);//nueva forma y dicen q es la mejor
      //this.componentRef.instance.data=this.products[i];
    }
  }


} 
