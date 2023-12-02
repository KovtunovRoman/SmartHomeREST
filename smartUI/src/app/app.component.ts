import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { DxButtonModule } from 'devextreme-angular';
import {SmartService} from "../service/SmartService";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, DxButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'smartUI';
  public buttonBool: boolean = false;

  constructor(private smartService: SmartService) {
  }

  public helloWorld(){
    this.buttonBool = !this.buttonBool;
    this.smartService.getBooleanFromButton(this.buttonBool).subscribe(value => {console.log(value)});
  }

  ngOnInit(): void {

  }
}
