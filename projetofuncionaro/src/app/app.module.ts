import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginEmpresaComponent } from './login-empresa/login-empresa.component';
import { CadastroEmpresaComponent } from './cadastro-empresa/cadastro-empresa.component';
import { CadastroFuncionarioComponent } from './cadastro-funcionario/cadastro-funcionario.component';
import { ConsultaFuncionarioComponent } from './consulta-funcionario/consulta-funcionario.component';


const routes : Routes = [
{ path : 'lodin-empresa', component : LoginEmpresaComponent},
{ path : 'cadastro-empresa', component : CadastroEmpresaComponent},
{ path : 'cadastro-funcionario', component : CadastroFuncionarioComponent},
{ path : 'consulta-funcionario', component : ConsultaFuncionarioComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginEmpresaComponent,
    CadastroEmpresaComponent,
    CadastroFuncionarioComponent,
    ConsultaFuncionarioComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
