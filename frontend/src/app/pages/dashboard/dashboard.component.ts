import { HeaderComponent } from '../../components/header/header.component';
import { FooterComponent } from "../../components/footer/footer.component";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { MatIcon } from '@angular/material/icon';

@Component({
  selector: 'app-dashboard',
  imports: [
    CommonModule, HeaderComponent, FooterComponent, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, MatIcon
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent {  
  imagePreview: string | ArrayBuffer | null = null;
  fileName = "NomeImagem";

onFileSelected(event: Event) {
  const input = event.target as HTMLInputElement;

  if (!input.files || input.files.length === 0) return;
  const file = input.files[0];
  this.fileName = file.name;  
  
  if (!file.type.startsWith('image/')) {
    alert('Selecione apenas imagens.');
    return;
  }

  const reader = new FileReader();

  reader.onload = () => {
    this.imagePreview = reader.result;    
  };

  reader.readAsDataURL(file);
}

}






