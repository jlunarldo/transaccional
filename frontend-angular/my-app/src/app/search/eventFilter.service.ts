import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventFilterService {
  private eventSubject = new Subject<string>(); // Ahora envía un string

  event$ = this.eventSubject.asObservable(); //el $ es para indicarlo que es un evento reactivo

  triggerEvent(data: string) {
    this.eventSubject.next(data);
  }
}