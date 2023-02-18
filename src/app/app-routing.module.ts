import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { ListStudentComponent } from './list-student/list-student.component';
import { StudentUpdateComponent } from './student-update/student-update.component';
import { ViewdetailsComponent } from './ViewDetails/viewdetails.component';

const routes: Routes = [
  {path:'addstudent',component:AddStudentComponent},
  {path:'student',component:ListStudentComponent},
  {path: 'getStudentById/:studentId',component:ViewdetailsComponent},
  {path: 'updateStudentRecords/:studentId',component:StudentUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
