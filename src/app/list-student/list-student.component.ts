import { Component, OnInit } from '@angular/core';
import { StudentService } from 'service/student.service';
import { Student } from 'model/student';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit
{
  students: any;

constructor(private studentService: StudentService,private router:Router)
{}
  
ngOnInit()
{
  this.studentService.findAll().subscribe(data =>
    {
    this.students =data;
     }
  );
}
updateStudentRecord(studentId:number)
{
  this.router.navigate(['updateStudentRecords',studentId]);
}
studentDelete(studentId:number){

}
deleteStudentRecord(studentId: number) {
  this.studentService.deleteStudent(studentId)
    .subscribe(
      data => {
        alert("data deleted successfully")
        console.log(data);
        this.ngOnInit();
      })
    }

}
