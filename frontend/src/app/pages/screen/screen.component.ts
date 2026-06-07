import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ImageService } from '../../services/image.service';
import { AsyncPipe } from '@angular/common';
@Component({
  selector: 'app-screen',
  imports: [AsyncPipe],
  templateUrl: './screen.component.html',
  styleUrl: './screen.component.scss',
})
export class ScreenComponent {
  constructor(private route: ActivatedRoute) {}
  screenName: string = "";

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.screenName = params.get('screenName') ?? '';

      console.log(this.screenName);
    });
  }
  

  private service = inject(ImageService);
  imagens$ = this.service.list(this.screenName);

}
