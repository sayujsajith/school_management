import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListStudentComponent } from './list-student/list-student.component';
import { HttpClientModule} from '@angular/common/http';
import { AddStudentComponent } from './add-student/add-student.component';
import { StudentService } from 'service/student.service';
import { DeleteStudentComponent } from './delete-student/delete-student-component.component';
import { StudentUpdateComponent } from './student-update/student-update.component';
import { ViewdetailsComponent } from './ViewDetails/viewdetails.component';

@NgModule({
  declarations: [
    AppComponent,
    ListStudentComponent,
    AddStudentComponent,
    DeleteStudentComponent,
    StudentUpdateComponent,
    ViewdetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
