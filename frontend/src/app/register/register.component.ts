import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';
import { empty } from 'rxjs';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  alertCompletion = false;
  alertConfirm = false;
  name: string | undefined;
  userLogin: string | undefined;
  userPassword: string | undefined;
  confirmPassword: string | undefined;

  constructor(private router: Router, private userService: UserService) {  }

  ngOnInit(): void {
  }

  onSubmit = () => {
    this.router.navigate(['/api/login']);
  }

  public onAddUser(addForm: NgForm): void {
    if ((this.name == null || this.name.length == 0) ||
    (this.userLogin == null || this.userLogin.length == 0) ||
    (this.userPassword == null || this.userPassword.length == 0)) {

      this.alertCompletion = true;
    } else {
      if(this.userPassword == this.confirmPassword){
        this.userService.addUser(addForm.value).subscribe(
          (response: User) => {
            addForm.reset();
          });
        this.router.navigate(['/api/user']);
      } else {
        this.alertConfirm = true;
      }
    }
  }

  closeCopmpletion(id: string) {
    document.getElementById(id)!.style.display="none";
    this.alertCompletion = false;
  }

  closeConfirm(id: string){
    document.getElementById(id)!.style.display="none";
    this.alertConfirm = false;
  }
}
