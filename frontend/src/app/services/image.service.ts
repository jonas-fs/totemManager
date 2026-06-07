import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  apiUrl: string = environment.apiUrl;

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

  list (screenID : string) {
    const params = new HttpParams().set('screenID', screenID);
    return this.httpClient.get<any[]>(this.apiUrl + "/image", {params});
    
  }
}
