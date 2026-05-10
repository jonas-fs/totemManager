import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  apiUrl: string = "http://192.168.1.2:8080"

  constructor(private httpClient: HttpClient) { }

  save (file: File | null, screenID : string) {
    console.log("Save chamado. " + file?.name + screenID);
    
    if (!file) {
      console.error("Arquivo não informado");
      return this.httpClient.post(`/users`, ""); //TO-DO consertar isso.
    }

    const formData = new FormData();

    formData.append('file', file);
    formData.append('screenID', screenID);

    return this.httpClient.post(this.apiUrl + "/image", formData);
    
    // return this.httpClient.post(this.apiUrl + "/image", { name, file, ScreenID }).pipe(
    //   tap((value) => {
    //     console.log(value);
    //   })
    // )
  }
}
