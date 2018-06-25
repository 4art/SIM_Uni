import { Component, OnInit } from '@angular/core';
import { Config } from '../config';

@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent implements OnInit {
  private text: string;
  private title: string;
  private text2: string;
  private title2: string;
  constructor() {
    let config = new Config()
    this.text = config.getText() 
    this.title = config.getTitle()
    this.text2 = config.getText2() 
    this.title2 = config.getTitle2() }
  ngOnInit() {
  }

}
