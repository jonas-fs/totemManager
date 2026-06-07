import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-footer',
  imports: [MatToolbarModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss',
})
export class FooterComponent {
  version: string = environment.version;

}
