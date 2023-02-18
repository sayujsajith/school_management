import { Component } from '@angular/core';
import { StudentService } from 'service/student.service';
import { Student } from 'model/student';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {

  student: Student;
  constructor(private router: Router,private route:ActivatedRoute,private studentService:StudentService)
  {
    this.student=new Student();
  }
onSubmit()
 {
  this.studentService['save'](this.student).subscribe((result:any)=>this.student=result);
  alert("Student Details Saved Sucessfully");
}

}
