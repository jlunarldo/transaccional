import { Component, ComponentRef, inject, viewChild, ViewContainerRef } from '@angular/core';
import { Product } from '../../Product';
import { CardModule } from '../CardComponent/card.module';
import { CardComponent } from '../CardComponent/card.component';
import { ProductService } from '../home/product.service';
@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  
})
export class HomeComponent {
  products: Product[]=[
    {
      id: 1,
      nameProduct: "Laptop Gamer",
      category: "Electronics",
      priceUnit: 1500,
      subCategorie: "Computers",
      flag: 1,
      cantTotal: 2,
      priceTotal: 3000
    }
  ];
  ngOnInit() {
    this.loadProducts().then(() => {
      this.createComponent();
  });
  }

  constructor(public productService: ProductService){};
  
  /*products: Product[] = [
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
*/
  //ref= inject(ViewContainerRef);

  container= viewChild.required('container_cards',{read:  ViewContainerRef});
  
  componentRef!: ComponentRef<CardComponent>;

  loadProducts(): Promise<void> {
    return new Promise((resolve) => {
        this.productService.getAllProduct().subscribe(response => {
            console.log("Response completa:", response);
            this.products = response.list;
            resolve(); 
        });
    });
  }

  getAllProduct(): void {
    console.log("entré aquí");
    this.productService.getAllProduct().subscribe(response => {
       
        this.products=response.list;
      console.log("primer llamado"+this.products)
    });
  }
  


  createComponent(){
    for (let i = 0; i < this.products.length; i++) {
      this.componentRef=this.container().createComponent(CardComponent);
      console.log("segundo llamado"+this.products)
      this.componentRef.setInput('data', this.products[i]);//nueva forma y dicen q es la mejor
      //this.componentRef.instance.data=this.products[i];
    }
  }


} 
