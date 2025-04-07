import { Component, ComponentRef, inject, viewChild, ViewContainerRef } from '@angular/core';
import { Product } from '../../Product';
import { CardModule } from '../CardComponent/card.module';
import { CardComponent } from '../CardComponent/card.component';
import { ProductService } from '../home/product.service';
import { EventFilterService } from '../search/eventFilter.service';
@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  
})
export class HomeComponent {
   products: Product[]=[
    {
      id_product: 1,
      nameProduct: "Laptop Gamer",
      category: "Electronics",
      priceUnit: 1500,
      subCategorie: "Computers",
      flag: 1,
      cantTotal: 2,
      priceTotal: 3000
    }
  ];

  container= viewChild.required('container_cards',{read:  ViewContainerRef});
  
  componentRef!: ComponentRef<CardComponent>;
  
  
  ngOnInit() {
    this.hearEventFilterService.event$.subscribe((categorie: string) => {
      this.loadProducts(categorie).then(() => {
        this.createComponent();
      });
    });
    
  }


  constructor(public productService: ProductService, private hearEventFilterService:EventFilterService){}; //public productService: ProductService

 loadProducts(categorie:string): Promise<void> {
    return new Promise((resolve) => {
        this.productService.getCategorieProduct(categorie).subscribe(response => {
            
            this.products = response.list;
            resolve(); 
        });
    });
  }

  getAllProduct(): void {

    this.productService.getAllProduct().subscribe(response => {
       
        this.products=response.list;

    });
  }

  createComponent(){
    this.container().clear();
    for (let i = 0; i < this.products.length; i++) {
      
      this.componentRef=this.container().createComponent(CardComponent);
      
      this.componentRef.setInput('data', this.products[i]);//nueva forma y dicen q es la mejor
      //this.componentRef.instance.data=this.products[i];
    }
  }


} 
