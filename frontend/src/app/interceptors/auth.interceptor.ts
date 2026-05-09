import { HttpInterceptorFn } from '@angular/common/http';
import { AuthGuard } from '../services/auth-guard.service';
import { inject } from '@angular/core';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authGuard = inject(AuthGuard);

  //Ignora endpoints publicos
  if (req.url.includes("/login")) {
    return next(req);
  }

  const token = authGuard.getToken();

  //Se não houver token
  if (!token) {
    return next(req);
  }

  //Clona a requisição adicionando o header
  console.log(token);
  const authReq = req.clone({
    setHeaders: {      
      Authorization: `Bearer ${token}`
    }
  });

  return next(authReq);
};
