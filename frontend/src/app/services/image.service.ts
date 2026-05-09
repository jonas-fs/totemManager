import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  apiUrl: string = "http://192.168.1.2:8080"

  constructor(private httpClient: HttpClient) { }

  save (name: string, file: File | null, ScreenID : String) {
    console.log("Save chamado. " + name + file?.name + ScreenID);
    
    return this.httpClient.post(this.apiUrl + "/image", { name, file, ScreenID }).pipe(
      tap((value) => {
        console.log(value);
      })
    )
  }
}
