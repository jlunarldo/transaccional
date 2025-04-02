import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Product } from '../../Product';
import { ProductRequest } from '../add-form/ProductRequest';


@Injectable({
  providedIn: 'root'
})
export class EventFormService {
    private eventSubject = new Subject<ProductRequest>();

    event$ = this.eventSubject.asObservable(); // Sigue siendo un observable
  
    triggerEvent(data: ProductRequest) {
      this.eventSubject.next(data);
    }
}
