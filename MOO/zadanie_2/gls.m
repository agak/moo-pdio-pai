function x=gls(x0,sl,fn,a0,rho,c,kMax)
% Metoda najszybszego spadku
% INPUT:
%       x0 - punkt początkowy;
%       sl - nazwa kryterium;
%       f0 - funkcja podstawowa napis(np 'X^2+Y^2')   
%       a0 - początkowa długośc kroku;
%       rho - parametr backtrackingu
%       c - stała wykorzystywana w kryteriach
% OUTPUT:
%       x - rozwiązania;



%ugotuj funkcje podstawową z stringa
f=inline(fn);
f0=@(x)f(x(1),x(2));

%ugotuj gradien na podstawie przepisu w stringu
syms x y
t=[x;y];
w=fn;
gfn=matlabFunction(jacobian(w,t).');
f1=@(x)gfn(x(1),x(2));

%wybor kryterium
sl=@(x,p)backtk(sl,a0,x,p,c,f0,f1,rho);
x=x0;
k=0;

while k<kMax %warunek zakończenia, liczba iteracji
    %kierunek
    p=-f1(x);
    %długość kroku spełniająca kryterium
    a=sl(x,p);
    %kolejne przybliżenie
    x=x+a*p
    %licznik iteracji
    k=k+1;
end
%Przykłady
%gls([2;2],'armijo','X^2+Y^2',0.36,0.5,0.2,10)
%gls([2;2],'wolfes','X^2+Y^2',0.35,0.5,[0.8;0.5],10)
%gls([2;2],'wolfes','X^2+Y^2',0.35,0.5,[0.8;0.5],10)
%gls([2;2],'goldstein','X^2+Y^2',0.35,0.5,0.2,10)
     
     