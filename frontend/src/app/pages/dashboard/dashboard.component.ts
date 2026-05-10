import { HeaderComponent } from '../../components/header/header.component';
import { FooterComponent } from "../../components/footer/footer.component";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { MatIcon } from '@angular/material/icon';
import { AuthGuard } from '../../services/auth-guard.service';
import { ImageService } from '../../services/image.service';
import { ToastrService } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  imports: [
    CommonModule, HeaderComponent, FooterComponent, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, MatIcon, FormsModule
  ],
  providers: [
    ImageService
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent implements OnInit {
  constructor(private authGuard: AuthGuard,
              private imageService: ImageService,
              private toastService: ToastrService
  ) {}
  userName: string | null = null;
  inputFile: File | null = null;
  screen: string = '';

  ngOnInit(): void {
    this.userName = this.authGuard.getUserName();
    console.log(this.userName);
  }

  imagePreview: string | ArrayBuffer | null = null;
  fileName = "NomeImagem";

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;

    if (!input.files || input.files.length === 0) return;
    const file = input.files[0];
    this.inputFile = input.files[0];
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

  submit(){
    console.log("Botão Clicado");
    console.log(this.screen);

    let idTela = "9d5db2bb-3d4c-4668-b5f3-764bfad72fba"; //TO-DO - MOC    
    if (this.screen === "tela_2"){ //TO-DO - MOC
      idTela = "7421852e-5b3e-451e-abdf-a19b33ed2c42"; //TO-DO - MOC
    }

    this.imageService.save(this.inputFile, idTela).subscribe({      
      next: () => {
        console.log("Chegou no next");
        this.toastService.success("Imagem Cadastrada com Sucesso.");
        //this.router.navigate(["dashboard"]);
      },
      error: () => this.toastService.error("Erro inesperado! Tente novamente mais tarde.")
    })
  }

}






