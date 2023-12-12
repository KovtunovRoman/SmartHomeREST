import {Component, OnInit} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { RouterOutlet } from '@angular/router';
import {DxBoxModule, DxButtonModule, DxRangeSelectorModule} from 'devextreme-angular';
import {SmartService} from "../service/SmartService";
import {DxoBackgroundModule, DxoImageModule} from "devextreme-angular/ui/nested";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, DxButtonModule, DxBoxModule, NgOptimizedImage, DxoBackgroundModule, DxoImageModule,
  DxRangeSelectorModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'smartUI';
  public buttonBool: boolean = false;

  constructor(private smartService: SmartService) {
  }

  public helloWorld = () => {
    this.buttonBool = !this.buttonBool;
    console.log("123")
    this.smartService.getBooleanFromButton(this.buttonBool).subscribe(value => {console.log(value)});
  }

  ngOnInit(): void {

  }
}
