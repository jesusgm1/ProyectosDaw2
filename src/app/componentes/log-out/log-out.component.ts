import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit{
  router:any;
  token=localStorage.getItem('token');



  ngOnInit(): void {
    if (this.token){
      localStorage.removeItem('token');
      this.router.navigate(['/MostrarCanciones']);
    }
  }

}
